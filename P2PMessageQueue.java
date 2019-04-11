/**
 * This Queue maintains the queue of messages coming from connected clients.
 */
public class P2PMessageQueue {

    private P2PMessage head = null;
    private P2PMessage tail = null;


    /**
     * This method allows adding a message object to the existing queue.
     * @param oMessage
     */
    public synchronized void enqueue(P2PMessage oMessage){

		if (head == null) {
			head = oMessage;
			tail = head;
			
		}
		else {
			P2PMessage temp = oMessage;
			tail.next = temp;
			tail = temp;
		}
    }


    /**
     * This method allows removing a message object from the existing queue.
     * @return
     */
    public synchronized P2PMessage dequeue(){

		if (head == null) {
			return null;
		}
		else {
			P2PMessage temp = head;
			head = head.next;
			return temp;
		}
    }


    public boolean hasNodes(){

		if (head != null)
			return true;
		return false;
    }
}

