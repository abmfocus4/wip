class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        
        //create adjencylist matrix
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap();
        for(int nodeId = 0; nodeId < n; nodeId++){
            graph.putIfAbsent(nodeId, new HashMap());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).put(edge[1], edge[2]);
            graph.get(edge[1]).put(edge[0], edge[2]);
        }
        
        //Max Heap: get the node with maximum number of remaining moves
        PriorityQueue<PQElement> pq = new PriorityQueue<PQElement>((a, b) -> (b.remainingMoves - a.remainingMoves));
        pq.add(new PQElement(0, maxMoves));
        
        int nodeReachableCount = 0;
        boolean[] visited = new boolean[n];
        
        while(!pq.isEmpty()){
            PQElement currNode = pq.remove();
            
            if(visited[currNode.nodeId]) continue;
            
            //mark as visited
            visited[currNode.nodeId] = true;
            
            nodeReachableCount++;
            
            //check all adjacent node
            for(int adjNodeId : graph.get(currNode.nodeId).keySet()){
                
                int newNodeCount = graph.get(currNode.nodeId).get(adjNodeId);
                
                if(!visited[adjNodeId] && currNode.remainingMoves >= (newNodeCount + 1)){
                    pq.add(new PQElement(adjNodeId, currNode.remainingMoves - (newNodeCount + 1)));
                }
                
                //Adjust the new node count,b/w this current node and adjNode
                int actualReachNodeCount = Math.min(currNode.remainingMoves, newNodeCount);
                
                graph.get(currNode.nodeId).put(adjNodeId, newNodeCount - actualReachNodeCount);
                graph.get(adjNodeId).put(currNode.nodeId, newNodeCount - actualReachNodeCount);
                
                
                //append actual reach node count
                nodeReachableCount += actualReachNodeCount;
            }
            
        }
        
        return nodeReachableCount;
    }
}

class PQElement {
    int nodeId;
    int remainingMoves;
    
    public PQElement(int nodeId, int remainingMoves){
        this.nodeId = nodeId;
        this.remainingMoves = remainingMoves;
    }
}