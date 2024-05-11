class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int N = quality.length;
        double[][] workers = new double[N][2];
        for (int i = 0; i < N; ++i)
            workers[i] = new double[]{(double)(wage[i]) / quality[i], (double)quality[i]};
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        
        double ans = 1e9;
        int sumq = 0;
        PriorityQueue<Integer> pool = new PriorityQueue<>(Collections.reverseOrder());
        for (double[] worker: workers) {
            sumq += worker[1];
            pool.offer((int) worker[1]);
            if (pool.size() > K) sumq -= pool.poll();
            if (pool.size() == K) ans = Math.min(ans, sumq * worker[0]);
        }
        return ans;
    }
}