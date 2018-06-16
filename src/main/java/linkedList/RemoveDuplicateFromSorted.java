package linkedList;

/**
 * Created by Administrator on 6/15/2018.
 */
public class RemoveDuplicateFromSorted {

    public static ListNode solution (ListNode head) {
        if (head == null ||head.next == null)
            return head;
        ListNode node1 = head.next;
        ListNode node2= head;
        while (node1 != null) {
            if (node1.val != node2.val) {
                node2.next = node1;
                node2 = node2.next;
            } else {
                node2.next = null;
            }
            node1 = node1.next;
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
