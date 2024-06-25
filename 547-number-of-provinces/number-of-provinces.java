class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1)
                uf.union(i, j);
            }
        }
        return uf.numComponents;
    }

    class UnionFind {
        int[] parents;
        int[] size;
        int numComponents;

        public UnionFind(int n) {
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
                int curParent = parents[cur];
                parents[cur] = root;
                cur = curParent;
            }

            return root;
        }

        public void union(int node1, int node2) {
            int node1Parent = find(node1);
            int node2Parent = find(node2);

            if (node1Parent == node2Parent) {
                return;
            }
            
            if (size[node1Parent] > size[node2Parent]) {
                parents[node2Parent] = node1Parent;
                size[node1Parent] += size[node2Parent];
            } else {
                parents[node1Parent] = node2Parent;
                size[node2Parent] += size[node1Parent];
            }

            numComponents--;
        }
    }
}