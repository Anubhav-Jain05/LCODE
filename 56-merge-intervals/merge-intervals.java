class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][0];
        }
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]> list= new ArrayList<>();
        int[] currentIntervals=intervals[0];
        list.add(currentIntervals);
        for(int[] intern:intervals){
            int currend=currentIntervals[1];
            int nextstart=intern[0];
            int nextend=intern[1];
            if(currend >= nextstart){
                currentIntervals[1]=Math.max(currend,nextend);
            }else{
                currentIntervals=intern;
                list.add(currentIntervals);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}