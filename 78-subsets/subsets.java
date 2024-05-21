class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        allSet(0,nums,new ArrayList<>(),res);
        return res;
    }
    private void allSet(int index,int[] nums,List<Integer>current,List<List<Integer>> result){
        result.add(new ArrayList<>(current));

        for(int i=index;i<nums.length;i++){
            current.add(nums[i]);

            allSet(i+1,nums,current,result);

            current.remove(current.size()-1);
        }
    }
}