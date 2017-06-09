package LoopAndCarry.No2_AddTwoNumbers;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int sum;

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        int round = 0;

        while(l1 != null && l2 != null){
            sum = l1.val + l2.val + round;
            round = sum/10;
            node.next = new ListNode(sum%10);
            l1 = l1.next; l2= l2.next; node = node.next;
        }

        if (l1 == null) l1 = l2;
        while (l1 != null){
            sum = l1.val + round;
            round = sum/10;
            node.next = new ListNode(sum%10);
            l1 = l1.next; node = node.next;
        }

        if(round > 0) node.next = new ListNode(1);
        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        ListNode res = new ListNode(sum%10);
        addTwo(l1, l2, res, sum / 10);
        return res;
    }

    public void addTwo(ListNode l1, ListNode l2, ListNode res, int round){
        int sum;
        if(l1.next == null && l2.next == null) {
            if(round > 0) res.next = new ListNode(1);
        }else if(l1.next == null) {
            sum = l2.next.val + round;
            res.next = new ListNode(sum % 10);
            addTwo(l1, l2.next, res.next, sum / 10);
        }else if(l2.next == null){
            sum = l1.next.val + round;
            res.next = new ListNode(sum %10);
            addTwo(l1.next, l2, res.next, sum/10);
        }else {
            sum = l1.next.val + l2.next.val + round;
            res.next = new ListNode(sum %10);
            addTwo(l1.next, l2.next, res.next, sum/10);
        }
    }

}
