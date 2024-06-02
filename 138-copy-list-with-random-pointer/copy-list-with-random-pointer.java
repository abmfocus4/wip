/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
// https://www.youtube.com/watch?v=OLgXN2Yg3xQ&list=TLPQMDEwNjIwMjSUjnvbX72tSg&index=9&ab_channel=codestorywithMIK
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }   


        // inserting new node after orig node
        Node cur = head;
        while (cur != null) {
            Node curNext = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = curNext;
            cur = curNext;
        }

        cur = head;
        // random pointing update
        while (cur != null && cur.next != null) {
            if (cur.random == null) {
                cur.next.random = null;
            } else {
                cur.next.random = cur.random.next;
            }
            
            cur = cur.next.next;
        }

        // separating ll
        Node newHead = head.next;
        Node newCur = newHead;
        cur = head;
        while (cur != null && newCur != null) {
            cur.next = (cur.next == null) ? null : cur.next.next;
            newCur.next = (newCur.next == null) ? null : newCur.next.next;

            cur = cur.next;
            newCur = newCur.next;
        }

        return newHead;
    }
}