package LinkedList._No142_LinkedListCycleII;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Note: Do not modify the linked list.

 Follow up:
 Can you solve it without using extra space?

 */
public class Solution {
    private class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (slow != null && fast != null){
            slow = slow.next;
            if(fast.next == null) return null;
            fast = fast.next.next;
            if (slow == fast){
                hasCycle = true;
                break;
            }
        }
        if (hasCycle){
            slow = head;
            while (slow != fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }
}
