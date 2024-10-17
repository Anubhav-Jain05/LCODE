class Pair{
    int vertex;
    int color;
    Pair(int vertex,int color){
        this.vertex=vertex;
        this.color=color;
    }
}
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n= graph.length;
        int[] color= new int[n];
        Arrays.fill(color,-1);
        for(int currentVertex=0;currentVertex < n;currentVertex ++){
            if(color[currentVertex] != -1){
                continue;
            }
            if(!hasCycleBFS(graph,currentVertex,0,color)){
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
     private boolean hasCycleBFS(int[][] graph,int Vertex,int currentColor,int[] color){
       Queue<Pair> queue= new LinkedList<>();
       queue.add(new Pair(Vertex,0));
       while(!queue.isEmpty()){
        Pair currentPair= queue.remove();
        int currentVertex=currentPair.vertex;
        int colors=currentPair.color;

        if(color[currentVertex] != -1){
            if(color[currentVertex] != colors){
                return false;
            }
        }
        else{
            color[currentVertex] = colors;
            for(int currentNeigh : graph[currentVertex]){
                queue.add(new Pair(currentNeigh,1-colors));
            }
            
        }

       }
        return true;
    }
}