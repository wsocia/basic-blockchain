import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;


/**
 * This class holds any utility methods needed for P2P networking communication.
 */
public class P2PUtil {


    /**
     * Allows a one time socket call to a server, gets reply, and then closes connection.
     * @param sIP
     * @param iPort
     * @param sMessage
     * @return
     */
    public static String connectForOneMessage(String sIP, int iPort, String sMessage){

    	try (Socket socket = new Socket()) {
			// Connect to server and try up to 5 seconds
			socket.connect(new InetSocketAddress(sIP, iPort), 5000);

			OutputStream output = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(output, true);

			// Send message
			writer.println(sMessage);
			writer.flush();

			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));

			String returnString = reader.readLine();

			socket.close();

			return returnString;

		} catch (IOException ex) {
			System.out.println("[CLIENT]: Client exception: " + ex.getMessage());
			ex.printStackTrace();
		}
		return null;
    }
}
