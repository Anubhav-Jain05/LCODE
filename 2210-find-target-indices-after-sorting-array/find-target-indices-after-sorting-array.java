class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list= new ArrayList<>();
        Arrays.sort(nums);
        int first=-1;
        int end=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                list.add(i);
                // if(first == -1){
                //     first=i;
                //     list.add(first);
                // }
                // else if(end == -1){
                //     end=i;
                // list.add(end);
                // }   
            }
        }
        return list;
    }
}