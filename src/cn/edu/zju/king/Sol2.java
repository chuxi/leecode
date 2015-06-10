package cn.edu.zju.king;

/**
 * Created by king on 2015/3/25.
 */

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}

public class Sol2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        if (l1 == null && l2 != null)
//            return l2;
//        if (l1.next == null && l2.next != null) {
//            l1.next = l2.next;
//            l2.next = null;
//        }
//
//        int k = l1.val;
//        if (l2 != null) k = k + l2.val;
//        ListNode tmp = new ListNode(k % 10);
//        if (l1.next == null) {
//            if (k > 9) {
//                tmp.next = new ListNode(k / 10);
//            }
//            return tmp;
//        } else {
//            if (k > 9) {
//                l1.next.val = l1.next.val +1;
//            }
//            tmp.next = addTwoNumbers(l1.next, l2.next);
//        }
//        return tmp;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        return addTwoNodes(l1, l2, 0);

    }

    public ListNode addTwoNodes(ListNode l1, ListNode l2, int c) {
        if (l1 != null) c = c + l1.val;
        if (l2 != null) c = c + l2.val;

        int nc = c > 9 ? 1: 0;

        ListNode tmp = new ListNode(c % 10);


        if (l1.next == null && l2.next != null)
            tmp.next = addTwoNodes(new ListNode(0), l2.next, nc);
        if (l1.next != null && l2.next == null)
            tmp.next = addTwoNodes(l1.next, new ListNode(0), nc);
        if (l1.next != null && l2.next != null)
            tmp.next = addTwoNodes(l1.next, l2.next, nc);
        if (l1.next == null && l2.next == null && nc > 0)
            tmp.next = new ListNode(nc);
        return tmp;
    }

    public static void main(String[] args) {
        Sol2 sol = new Sol2();
        ListNode L11 = new ListNode(2);
        ListNode L12 = new ListNode(4); L11.next = L12;
        ListNode L13 = new ListNode(3); L12.next = L13;

        ListNode L21 = new ListNode(5);
        ListNode L22 = new ListNode(6); L21.next = L22;
        ListNode L23 = new ListNode(4); L22.next = L23;

        ListNode r = sol.addTwoNumbers(L11, L21);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }

        L11.val = 1; L12.val = 8; L12.next = null;
        L21.val = 0; L21.next = null;
        r = sol.addTwoNumbers(L11, L21);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }

        L11.val = 9; L12.val = 8; L12.next = null;
        L21.val = 1; L21.next = null;
        r = sol.addTwoNumbers(L11, L21);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }

        L11.val = 0; L11.next = null;
        L21.val = 7; L22.val = 3; L21.next = L22; L22.next = null;
        r = sol.addTwoNumbers(L11, L21);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }

        L11.val = 1; L11.next = null;
        L21.val = 9; L22.val = 9; L21.next = L22; L22.next = null;
        r = sol.addTwoNumbers(L11, L21);
        while (r != null) {
            System.out.println(r.val);
            r = r.next;
        }
    }
}
