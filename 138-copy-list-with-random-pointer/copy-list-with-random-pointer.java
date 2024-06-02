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
        HashMap<Node, Node> origNodeToCopy = new HashMap();

        Node newHead = null;
        Node cur = head;
        Node prev = null;
        while (cur != null) {
            Node temp = new Node(cur.val); // creating temp node

            origNodeToCopy.put(cur, temp); // storing temp node with orig

            if (newHead == null) { // connecting to prev node
                newHead = temp;
            } else {
                prev.next = temp;
            }
            
            prev = temp; // storing prev node for next node connection
            cur = cur.next; // iterating
        }

        cur = head;
        Node newCur = newHead;
        while (cur != null && newCur != null) {
            newCur.random = origNodeToCopy.get(cur.random); // setting random node
            newCur = newCur.next; // iterating both ll forward
            cur = cur.next;
        }

        return newHead;
    }
}