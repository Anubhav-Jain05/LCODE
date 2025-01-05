class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0)return new int[0][0];
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> list=new ArrayList<>();
        int[] currentIntervals=intervals[0];
        list.add(currentIntervals);
        for(int[] interval:intervals){
            int currentEnd=currentIntervals[1];
            int nextstart=interval[0];
            int end=interval[1];
            if(currentEnd >= nextstart){
                currentIntervals[1]=Math.max(currentEnd,end);
            }else{
                currentIntervals=interval;
                list.add(currentIntervals);
            }
        }
        return list.toArray(new int[list.size()][]);

    }
}