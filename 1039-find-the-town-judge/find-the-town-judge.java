class Solution {
    public int findJudge(int n, int[][] trust) {
        // int[] inDegree= new int[n+1];
        // int[] outDegree= new int[n+1];

        // for(int[] currentTrust:trust){
        //     int a=currentTrust[0];
        //     int b=currentTrust[1];

        //     inDegree[b] += 1;
        //     outDegree[a] += 1;

        // }
        // for(int currentPeople=1;currentPeople <= n;currentPeople ++){
        //     if(inDegree[currentPeople] == n-1 && outDegree[currentPeople] == 0){
        //         return currentPeople;
        //     }
        // }
        // return -1;

        int[] indegree= new int[n+1];
        int[] outdegree=new int[n+1];
        for(int[] currentTrust:trust){
            int a=currentTrust[0];
            int b=currentTrust[1];

            indegree[b] += 1;
            outdegree[a] += 1;
        }
        for(int currentpeople=1;currentpeople <= n;currentpeople++){
            if(indegree[currentpeople] == n-1 && outdegree[currentpeople] == 0){
                return currentpeople;
            }
        }
        return -1;
    }
}