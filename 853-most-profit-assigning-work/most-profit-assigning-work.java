class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
           int n = difficulty.length;
        int[][] jobs = new int[n][2];
        
        // Combine difficulty and profit into one array
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        
        // Sort jobs by difficulty
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        // Sort worker by their abilities
        Arrays.sort(worker);
        
        int maxProfit = 0, totalProfit = 0, j = 0;
        
        // Iterate through each worker
        for (int i = 0; i < worker.length; i++) {
            // For each worker, find the most profitable job they can do
            while (j < n && worker[i] >= jobs[j][0]) {
                maxProfit = Math.max(maxProfit, jobs[j][1]);
                j++;
            }
            totalProfit += maxProfit;
        }
        
        return totalProfit;
    }
}