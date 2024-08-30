class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list= new ArrayList<>();
        generateSubset(nums,0,new ArrayList<>(),list);
        return list;
    }
    private void generateSubset(int[] nums,int currentIndex,ArrayList<Integer> currentsubset,List<List<Integer>>list){
        if(currentIndex==nums.length){
            list.add(new ArrayList<>(currentsubset));
            return;
        }
        currentsubset.add(nums[currentIndex]);
        generateSubset(nums,currentIndex+1,currentsubset,list);
        currentsubset.remove(currentsubset.size()-1);

        generateSubset(nums,currentIndex+1,currentsubset,list);
        return;
    }
}