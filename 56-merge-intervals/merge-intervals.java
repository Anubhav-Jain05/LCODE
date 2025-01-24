class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][0];
        }
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]>list= new ArrayList<>();
        int[] currentinterval=intervals[0];
        list.add(currentinterval);
        for(int[] inter:intervals){
            int currentend=currentinterval[1];
            int nextstart=inter[0];
            int nextend=inter[1];
            if(currentend >= nextstart){
                currentinterval[1]=Math.max(currentend,nextend);
            }else{
                currentinterval=inter;
                list.add(currentinterval);
            }
        }
        return list.toArray(new int[list.size()][]);

    }
}