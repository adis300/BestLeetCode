package LinkedList._No234_PalindromeLinkedList;

/**
 * Given a singly linked list, determine if it is a palindrome.

 Follow up:
 Could you do it in O(n) time and O(1) space?
 */
public class Solution {

    // Slow fast pointer and reverse
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private class Container{
        ListNode pointer;
        boolean compareResult;
        public Container(ListNode pointer, boolean compareResult) {
            this.pointer = pointer;
            this.compareResult = compareResult;
        }
    }
    Container container;

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Recursively match node and head.
    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) return true;
        return palindromeHelper(head, head);
    }

    public boolean palindromeHelper(ListNode head, ListNode node){
        if (node.next == null){
            container = new Container(head.next, node.val == head.val);
            return container.compareResult;
        }else{
            palindromeHelper(head, node.next);
            if (container.compareResult) {
                if (container.pointer == null || container.pointer.next == null) return container.compareResult;

                // even number of items || odd number of items
                if (container.pointer == node || container.pointer.next == node){
                    container.pointer = null;
                    return container.compareResult;
                }
                container.pointer = container.pointer.next;
                return container.compareResult && node.val == container.pointer.val;
            }return false;
        }
    }


}
