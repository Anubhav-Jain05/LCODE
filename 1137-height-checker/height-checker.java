class Solution {
    public int heightChecker(int[] heights) {
        int[] temp=heights.clone();
        int count =0;
        Arrays.sort(temp);
        for(int i=0;i<heights.length;i++){
            if(heights[i] != temp[i]){
                count++;
            }
        }
        return count;
    }
}