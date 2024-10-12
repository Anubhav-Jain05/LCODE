class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         ArrayList<ArrayList<Integer>> graph = constructGraph(numCourses,prerequisites);
        boolean[] visited = new boolean[numCourses];
        int[] indegree=new int[numCourses];

        for(int currentCourse=0;currentCourse < numCourses;currentCourse ++){
            for(int currentNeigh:graph.get(currentCourse)){
                indegree[currentNeigh] += 1;
            }
        }
        Queue<Integer> queue= new LinkedList<>();
        ArrayList<Integer>ans= new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int currentNode = queue.remove();

            if(visited[currentNode]){
                continue;
            }
            visited[currentNode] = true;
            ans.add(currentNode);

            for(int neigh:graph.get(currentNode)){
                indegree[neigh] -= 1;

                if(indegree[neigh] == 0){
                    queue.add(neigh);
                }
            }
        }
        // if(ans.size() != numCourses){
        //     return new int[0];
        // }
        // int[] answer= new int[numCourses];
        // for(int i=0;i<numCourses;i++){
        //     answer[i]=ans.get(i);
        // }
        // return answer;

        return ans.size() == numCourses;
    }
    private  ArrayList<ArrayList<Integer>> constructGraph(int n,int [][] edges){
         ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

         for(int i=0;i<n;i++){
            graph.add(new ArrayList<Integer>());
         }

         for(int[] currentEdge:edges){
            int a=currentEdge[0];
            int b=currentEdge[1];
            graph.get(b).add(a);
         }
         return graph;
    }
}