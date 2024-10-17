class Solution {
    public boolean isBipartite(int[][] graph) {
        int n= graph.length;
        int[] color= new int[n];
        Arrays.fill(color,-1);
        for(int currentVertex=0;currentVertex < n;currentVertex ++){
            if(color[currentVertex] != -1){
                continue;
            }
            if(!hasCycle(graph,currentVertex,0,color)){
                return false;
            }
        }
        return true;
    }
    private boolean hasCycle(int[][] graph,int currentVertex,int currentColor,int[] color){
        if(color[currentVertex] != -1){
            return color[currentVertex] == currentColor;
        }
        color[currentVertex] = currentColor;

        for(int currentNeigh:graph[currentVertex]){
            if(!hasCycle(graph,currentNeigh,1-currentColor,color)){
                return false;
            }
        }
        return true;
    }
}