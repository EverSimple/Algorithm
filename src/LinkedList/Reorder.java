package LinkedList;
/** Reorder the given singly-linked list
/* N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be
/* N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null
**/
public class Reorder {
    public ListNode reorder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 1. Find the middle node, break it to two lists
        ListNode mid = middleNode(head);
        ListNode head1 = head;
        ListNode head2 = mid.next;
        // break in the middle!!! de-link the second half from the list
        mid.next = null;

        // 2. Reverse the second list
        head2 = reverse(head2);
        // 3. merge two halves
        return merge(head1, head2);
    }

    private ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next; // record the newHead after reverse the first node
            head.next = prev; // reverse the first node
            prev = head; // then move head to the next node to be reversed
            head = next;
        }
        return prev;
    }

    private ListNode merge(ListNode one, ListNode two){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (one != null && two != null){
            curr.next = one;
            one = one.next;
            curr.next.next = two;
            two = two.next;
            curr = curr.next.next;
        }
        // if still elements left, put it at the end
        if (one != null) {
            curr.next = one;
        }
        if (two != null) {
            curr.next = two;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Reorder sol = new Reorder();
        ListNode head = new ListNode(1);
        head.appendTail(head, 2);
        head.appendTail(head, 3);
        head.appendTail(head, 4);
        ListNode newHead = sol.reorder(head);
        System.out.println(newHead.value);
    }
}
