class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <=1)return intervals;

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        List<int[]> list = new ArrayList<>();
        int[] currentIntervals=intervals[0];
        list.add(currentIntervals);
        for(int[] interval:intervals){
            int currentEnd=currentIntervals[1];
            int nextStart=interval[0];
            int nextEnd=interval[1];

            if(currentEnd >= nextStart){
                /// if overlap
                currentIntervals[1]=Math.max(currentEnd,nextEnd);
            }else{
                //no overlap
                currentIntervals=interval;
                list.add(currentIntervals);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}