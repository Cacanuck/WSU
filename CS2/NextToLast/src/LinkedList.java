
public class LinkedList {

    private Node head;
    private Node tail;

    public void add(String item) {

        Node newItem = new Node(item);

        // handles the case where the new item
        // is the only thing in the list
        if (head == null) {
            head = newItem;
            tail = newItem;
            return;
        }

        tail.next = newItem;
        tail = newItem;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }
    }

    /*
     * Method to get the Penultimate item in the Linked List
     * 
     * @return item if there is a penultimate item in the list
     * 
     * @return null if there is only 1 item in the list
     * 
     * @return null if there are no items in the list
     * 
     * @author Trevor Hollack
     */
    public String getPenultimate() {
        if (head == null) {
            return null; // Null if list is empty
        } else if (head.next == null) {
            return null; // Null if list has 1 item
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            return current.item; // Returns 2nd to last item
        }
    }

    class Node {
        String item;
        Node next;

        public Node(String item) {
            this.item = item;
            this.next = null;
        }
    }
}
