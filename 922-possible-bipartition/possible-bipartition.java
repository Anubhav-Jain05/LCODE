class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> graph= constructGraph(n,dislikes);

        int[] color= new int[n + 1];
        Arrays.fill(color,-1);
        for(int currentVertex=0;currentVertex <= n;currentVertex ++){
            if(currentVertex == 0 || color[currentVertex] != -1){
                continue;
            }
            if(!hasCycle(graph,currentVertex,0,color)){
                return false;
            }
        }
        return true;

    }
     private boolean hasCycle(ArrayList<ArrayList<Integer>> graph,int currentVertex,int currentColor,int[] color){
        if(color[currentVertex] != -1){
            return color[currentVertex] == currentColor;
        }
        color[currentVertex] = currentColor;

        for(int currentNeigh:graph.get(currentVertex)){
            if(!hasCycle(graph,currentNeigh,1-currentColor,color)){
                return false;
            }
        }
        return true;
    }
    private ArrayList<ArrayList<Integer>> constructGraph(int n,int[][] edges){
        ArrayList<ArrayList<Integer>> graph= new ArrayList<>();

        for(int i=0;i<= n;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int[] currentEdge:edges){
            int a= currentEdge[0];
            int b=currentEdge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return graph;
    }
}