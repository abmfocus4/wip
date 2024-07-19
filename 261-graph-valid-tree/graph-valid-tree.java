class Solution {
    class UnionFind {
        int[] parents;
        int[] size;
        int numComponents;

        UnionFind(int n) {
            this.parents = new int[n];
            this.size = new int[n];
            this.numComponents = n;
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        public int find(int cur) {
            int root = cur;
            while (parents[root] != root) {
                root = parents[root];
            }

            while (cur != root) {
                int oldParents = parents[cur];
                parents[cur] = root;
                cur = oldParents;
            }

            return root;
        }

        public int getSize(int node) {
            int parent = parents[node];
            return size[parent];
        }

        public boolean union(int node1, int node2) {
            int node1Parent = find(node1);
            int node2Parent = find(node2);

            if (node1Parent == node2Parent) {
                return false;
            }

            int node1Size = size[node1Parent];
            int node2Size = size[node2Parent];

            if (node1Size < node2Size) {
                parents[node1Parent] = node2Parent;
                size[node2Parent] += node1Size;
            } else {
                parents[node2Parent] = node1Parent;
                size[node1Parent] += node2Size;
            }

            numComponents--;
            return true;

        }

    }
    public boolean validTree(int n, int[][] edges) {
        // valid tree - 1 connected component
        // each node has only one parent, no cycles

        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            if (!uf.union(start, end)) {
                return false;
            }
        }

        return uf.numComponents == 1;
    }
}