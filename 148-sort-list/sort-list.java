public class Solution {
// https://www.youtube.com/watch?v=8ocB7a_c-Cc&list=TLPQMDEwNjIwMjSUjnvbX72tSg&index=24&ab_channel=takeUforward
    private ListNode findMiddle(ListNode head) {
        // step 1. cut the list to two halves
        ListNode slow = head, fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
  
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
        
    ListNode middle = findMiddle(head);
    ListNode right = middle.next;
    middle.next = null;
    
    // step 2. sort each half
    ListNode leftHalf = sortList(head);
    ListNode rightHalf = sortList(right);
    
    // step 3. mergeSortedLists l1 and l2
    return mergeSortedLists(leftHalf, rightHalf);
  }
  
  ListNode mergeSortedLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0), cur = dummy;
    
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }
    
    if (l1 != null)
      cur.next = l1;
    
    if (l2 != null)
      cur.next = l2;
    
    return dummy.next;
  }

}