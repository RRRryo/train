package linkedList;

import java.util.List;

/**
 * Created by Administrator on 6/15/2018.
 */
public class Add {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode first =l3;
        ListNode prev = null;
        int up = 0;
        while ((l1 !=null || l2 != null) || up!=0) {

            int sum = (l1==null?0: l1.val) + (l2==null?0:l2.val) + up;
            l3.val = sum%10;
            up = sum/10;
            l3.next= new ListNode(0);
            prev = l3;
            l3 = l3.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        prev.next=null;
        return first;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        System.out.print(Add.addTwoNumbers(l1, l2).val);
    }
}




class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }
