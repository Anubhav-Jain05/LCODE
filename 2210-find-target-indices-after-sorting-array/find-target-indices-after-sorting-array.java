class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list= new ArrayList<>();
        Arrays.sort(nums);
        int firstPosition=findfirstPosition(nums,target);
        if(firstPosition == -1)return list;
        int lastPosition=findlastPosition(nums,target);
        for(int i=firstPosition;i<=lastPosition;i++){
            list.add(i);
        }
        return list;
    }
    private int findfirstPosition(int[] nums,int target){
        int ans=-1;
        int start=0;
        int end=nums.length-1;
        while(start <= end){
            int mid=start + (end - start) / 2;
            if(nums[mid] == target){
                ans=mid;
                end=mid-1;
            }
            else if(nums[mid] > target){
                end=mid-1;
            }
            else{
                start=mid + 1;
            }
        }
        return ans;
    }
    private int findlastPosition(int[] nums,int target){
        int ans=-1;
        int start=0;
        int end=nums.length-1;
        while(start <= end){
            int mid=start + (end - start) / 2;
            if(nums[mid] == target){
                ans=mid;
                start=mid+1;
            }
            else if(nums[mid] > target){
                end=mid-1;
            }
            else{
                start=mid + 1;
            }
        }
        return ans;
    }
}