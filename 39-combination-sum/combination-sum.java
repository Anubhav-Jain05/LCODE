class Solution {//solution using recurrsion nad backtracking
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list= new ArrayList<>();
        generateCom(candidates,0,target,new ArrayList<Integer>(),list);
        return list;
    }
    private void generateCom(int[] nums,int currentIndex,int target,ArrayList<Integer> current,List<List<Integer>> list){
        if(target == 0){
            // list.add(current);
            list.add(new ArrayList<>(current));
            return;
        }
        if(currentIndex >= nums.length){
            return;
        }
        if(nums[currentIndex] <= target){
            current.add(nums[currentIndex]);
            generateCom(nums,currentIndex,target-nums[currentIndex],current,list);
            current.remove(current.size()-1);
        }
        generateCom(nums,currentIndex + 1,target,current,list);
        return;
    }
}