class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0)return new int[0][0];
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int[] currentIntervals=intervals[0];
        ArrayList<int[]> list = new ArrayList<>();
        list.add(currentIntervals);
        for(int[] inter:intervals ){
            int currentEnd=currentIntervals[1];
            int nextStart=inter[0];
            int nextEnd=inter[1];
            if(currentEnd >= nextStart){
                currentIntervals[1]=Math.max(currentEnd,nextEnd);
            }else{
                currentIntervals=inter;
                list.add(currentIntervals);
            }
        }  
        return list.toArray(new int[list.size()][]); 
    }
}