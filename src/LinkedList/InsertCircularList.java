package LinkedList;

public class InsertCircularList {
    public ListNode insertCircularList(ListNode head, int newVal){
        ListNode newNode = new ListNode(newVal);

        if (head == null) {
            head = newNode;
            newNode.next = newNode;
            return head;
        }

        ListNode curr = head;
        while(head != null) {
            if(curr.value <= newVal &&
                    (curr.next.value >= newVal || curr.value >= curr.next.value)) {
                newNode.next = curr.next;
                curr.next = newNode;
                return head;
            }
            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        InsertCircularList sol = new InsertCircularList();
        //ListNode head = null;
        ListNode head = new ListNode(4);
        head.appendTail(head, 1);
        // head.appendTail(head, 2);
        // head.appendTail(head, 3);
        head.next.next = head;
        ListNode newHead = sol.insertCircularList(head,5);
        System.out.println(newHead.value);
    }
}
