// class Solution {
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         ArrayList<ArrayList<Integer>> graph = constructGraph(numCourses,prerequisites);
//         boolean[] visited = new boolean[numCourses];
//         ArrayList<Integer> ans=new ArrayList<>();
//         for(int currentCourse=0;currentCourse<numCourses;currentCourse++){
//             if(visited[currentCourse] == false){
//                 if(hasOrder(graph,currentCourse,visited,new HashSet<Integer>(),ans)){
//                     return new int[0];
//                 }
//             }
//         }
//         int[] answer= new int[numCourses];
//         for(int i=0;i<numCourses;i++){
//             answer[i]=ans.get(i);
//         }
//         return answer;
//     }
//     private boolean hasOrder(ArrayList<ArrayList<Integer>> graph,int currentCourse,boolean[] visited,
//     HashSet<Integer>recStack,ArrayList<Integer> ans){
//         visited[currentCourse]= true;

//         recStack.add(currentCourse);

//         for(int currentNeigh:graph.get(currentCourse)){
//             if(visited[currentNeigh] == false){
//                 if(hasOrder(graph,currentNeigh,visited,recStack,ans)){
//                     return true;
//                 }
//                 else if(recStack.contains(currentNeigh)){
//                     return true;
//                 }
//             }
//         }
//         recStack.remove(currentCourse);
//         ans.add(currentCourse);
//         return false;
//     }
//     private  ArrayList<ArrayList<Integer>> constructGraph(int n,int [][] edges){
//          ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

//          for(int i=0;i<n;i++){
//             graph.add(new ArrayList<Integer>());
//          }

//          for(int[] currentEdge:edges){
//             int a=currentEdge[0];
//             int b=currentEdge[1];
//             graph.get(a).add(b);
//          }
//          return graph;
//     }
// }

import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = constructGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];  // Used for cycle detection
        ArrayList<Integer> ans = new ArrayList<>();

        for (int currentCourse = 0; currentCourse < numCourses; currentCourse++) {
            if (!visited[currentCourse]) {
                if (hasOrder(graph, currentCourse, visited, recStack, ans)) {
                    return new int[0];  // Return empty array if a cycle is detected
                }
            }
        }

        // Reverse the result list to get the correct topological order
        Collections.reverse(ans);

        // Convert the ArrayList to an array
        int[] answer = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }

    private boolean hasOrder(ArrayList<ArrayList<Integer>> graph, int currentCourse, boolean[] visited,
                             boolean[] recStack, ArrayList<Integer> ans) {
        visited[currentCourse] = true;
        recStack[currentCourse] = true;  // Add to recursion stack

        for (int currentNeigh : graph.get(currentCourse)) {
            if (!visited[currentNeigh]) {
                if (hasOrder(graph, currentNeigh, visited, recStack, ans)) {
                    return true;  // Cycle detected
                }
            } else if (recStack[currentNeigh]) {
                return true;  // Cycle detected
            }
        }

        recStack[currentCourse] = false;  // Remove from recursion stack
        ans.add(currentCourse);  // Post-order add to result (reverse needed later)
        return false;
    }

    private ArrayList<ArrayList<Integer>> constructGraph(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // Reverse the direction: if B → A, A depends on B, so graph[B].add(A)
        for (int[] currentEdge : edges) {
            int a = currentEdge[0];
            int b = currentEdge[1];
            graph.get(b).add(a);  // Add edge from b to a
        }

        return graph;
    }
}
