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

class Solution {
    public Node copyRandomList(Node head) {
        Node cur = head;
        Node newHead = null;
        Node prev = null;
        HashMap<Node, Node> origToClone = new HashMap();
        while (cur != null) {
            Node temp = new Node(cur.val);
            origToClone.put(cur, temp);
            if (newHead == null) {
                newHead = temp;
            } else {
                prev.next = temp;
            }
            prev = temp;
            cur = cur.next;
        }

        cur = head;
        Node cloneCur = newHead;
        while (cur != null && cloneCur != null) {
            cloneCur.random = origToClone.get(cur.random);
            cloneCur = cloneCur.next;
            cur = cur.next;
        }

        return newHead;
    }
}