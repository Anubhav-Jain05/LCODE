class Solution {
    public int findCircleNum(int[][] graph) {
        int n=graph.length;
        int ans=0;
        boolean[] visited=new boolean[n];

       for(int currentCity=0;currentCity < n;currentCity++){
        if(visited[currentCity] == false){
            dfs(graph,currentCity,n,visited);
            ans += 1;
        }
       }
       return ans;
    }
    // using dfs
    // private void dfs(int[][] graph,int currentCity,int n,boolean[] visited){
    //     if(visited[currentCity])return;

    //     visited[currentCity]=true;
    //     int[] neighbour=graph[currentCity];

    //     for(int i=0;i<n;i++){
    //         if(neighbour[i]==1){
    //             dfs(graph,i,n,visited);
    //         }
    //     }
    //     return;
    // }

    // using BFS

    private void dfs(int[][] graph,int currentCity,int n, boolean[] visited){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(currentCity);

        while(!queue.isEmpty()){
            int currentVertex=queue.remove();
            if(visited[currentVertex])
                continue;
            
            visited[currentVertex]=true;
            int[] neightbour=graph[currentVertex];

            for(int i=0;i<n;i++){
                if(neightbour[i]==1){
                    queue.add(i);
                }
            }
        }

    }
} 