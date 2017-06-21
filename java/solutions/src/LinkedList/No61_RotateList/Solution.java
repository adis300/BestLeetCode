package LinkedList.No61_RotateList;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.

 */
public class Solution {

    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
    // Count and break & reconnect
    public ListNode rotateRight1(ListNode head, int k) {
        ListNode node = head;
        int count = 0;
        while (node != null){
            node = node.next;
            ++count;
        }
        if (count < 2) return head;
        int steps = k % count;
        if(steps == 0) return head;

        node = head;
        for(int i = 1; i < count-steps; i ++)
            node = node.next;

        ListNode newHead = node.next;
        node.next = null;

        ListNode leadHalf = newHead;
        while (leadHalf.next != null){
            leadHalf = leadHalf.next;
        }
        leadHalf.next = head;

        return newHead;

    }

   // Connect into a circle and break at k
   public ListNode rotateRight(ListNode head, int k) {
       if (head == null) return head;
       ListNode node = head;
       int count = 1;
       while (node.next != null){
           node = node.next;
           ++count;
       }
       if (count < 2) return head;

       node.next = head;
       k = k % count;

       // Use head to
       for (int i = 1; i < count - k; i ++){
           head = head.next;
       }
       node = head.next;
       head.next = null;
       return node;
   }

    public static void main(String[] args){
        new Solution().rotateRight(null, 0);
    }

}


