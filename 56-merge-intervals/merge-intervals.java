class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0)return new int[0][0];
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]>list=new ArrayList<>();
        int[] currentInterVals=intervals[0];
        list.add(currentInterVals);
        for(int[] inter:intervals){
            int currEnd=currentInterVals[1];
            int nextstart=inter[0];
            int nextEnd=inter[1];
            if(currEnd >= nextstart){
                currentInterVals[1]=Math.max(currEnd,nextEnd);
            }else{
                currentInterVals=inter;
                list.add(currentInterVals);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}