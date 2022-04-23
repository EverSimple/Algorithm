package LinkedList;

public class ListNode {
    public int value;
    public ListNode next;
    // public Class3.ListNode prev;
    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public int length(ListNode head) {
        int length = 0;
        while(head!= null){
            head = head.next;
            length ++;
        }
        return length;
    }

    public ListNode get(ListNode head, int index) {
        while(index > 0 && head != null) {
            head = head.next;
            index --;
        }
        return head;
    }

    public ListNode appendTail(ListNode head, int value) {
        if (head == null) {
            return new ListNode(value);
        }
        ListNode currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = new ListNode(value);
        return head;
    }


}
