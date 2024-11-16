class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list =  new ArrayList<>();
        Arrays.sort(nums);
        int firstPostion=findfirstIndex(nums,target);
        if(firstPostion == -1)return list;
        int endPosition=findendIndex(nums,target);
        for(int i=firstPostion;i<=endPosition;i++){
            list.add(i);
        }
        return list;
    }
    private int findfirstIndex(int[] nums,int target){
        int start = 0;
        int end = nums.length -1;
        int first= -1;
        while(start <= end){
            int mid=start + (end-start) / 2;
            if(nums[mid]  < target){
                start= mid + 1;
            }else if(nums[mid] > target){
                end = mid -1;
            }else{
                first= mid;
                end  = mid -1;
            }
        }
        return first;
    }
    private int findendIndex(int[] nums,int target){
        int last = -1;
        int start=0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] < target){
                start = mid +1 ;
            }else if(nums[mid] > target){
                end= mid -1;
            }else {
                last= mid;
                start= mid + 1;
            }
        }
        return last;
    }

}