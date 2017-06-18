package Stack.No445_AddTwoNumbersII;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void addTwoNumbers2(){
        // Traverse down the node and find out the difference and redo 1-1 matching.
        // Faster but not as elegant
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null){
            s1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            s2.add(l2.val);
            l2 = l2.next;
        }
        int v1, v2, sum;

        ListNode head = new ListNode(0);
        ListNode temp;
        while (!s1.isEmpty() || !s2.isEmpty()){
            v1 = s1.isEmpty()? 0: s1.pop();
            v2 = s2.isEmpty()? 0: s2.pop();
            sum = v1 + v2 + head.val;
            head.val = sum %10;
            temp = head;
            head = new ListNode(sum/10);
            head.next = temp;
        }

        return (head.val == 0)? head.next: head;
    }

    public static void main(String[] args){

        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = new Solution().addTwoNumbers(l1,l2);
    }

}
