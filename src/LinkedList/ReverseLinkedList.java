package LinkedList;

public class ReverseLinkedList {
    public ListNode reverseLinkedList(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ReverseLinkedList sol = new ReverseLinkedList();
        ListNode head = new ListNode(4);
        head.appendTail(head, 3);
        head.appendTail(head, 2);
        head.appendTail(head, 1);
        ListNode newHead = sol.reverseLinkedList(head);
        System.out.println(newHead.next.next.next.value);
    }


}
