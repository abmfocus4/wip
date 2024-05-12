class Solution {
public class UnionFind {
    private int[] parents; // parent of each node
    private int[] size; // component size of disjoint set with node
    int numOfComponents = 0; // total connected components in graph

    public UnionFind(int n) {
        // init
        parents = new int[n];
        size = new int[n];
        numOfComponents = n;

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i; // initially curr node parent is itself
            size[i] = 1; // size of node's disjoint set is 1 (only contains itself)
        } 
    }

    // find current node's root
    public int find(int cur) {
        int root = cur;
        while (root != parents[root]) { // parent of root is root
            root = parents[root];
        }

        // opt1: path compression
        while (cur != root) {
            int preParent = parents[cur];
            parents[cur] = root; // set cur node parent as root
            cur = preParent; // traverse old parent
        }
        return root;
    }

    public int findComponentSize(int cur) {
        int parent = parents[cur];
        return size[parent]; // size of connected components in root's disjoint set
    }

    // connect root of one disjoint set to root of another disjoint set
    public void union(int node1, int node2) {
        int node1Parent = find(node1); // find parent of node1
        int node2Parent = find(node2);

        if (node1Parent == node2Parent) { // if nodes are connected, nothing to do
            return;
        }

        // opt2: make smaller disjoint set point to larger disjoint set
        // reduces the number of path decompressions done in the future
        if (size[node1Parent] > size[node2Parent]) {
            // connect node2 parent to node1 parent
            parents[node2Parent] = node1Parent;
            // node2 set does not exist
            size[node1Parent] += size[node2Parent];
        } else {
            parents[node1Parent] = node2Parent;
            size[node2Parent] += size[node1Parent];
        }
        // one of the sets does not exist
        numOfComponents--;
    }
}
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.numOfComponents;
    }
}