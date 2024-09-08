class Solution {// solution using dp
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        findCom(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    private void findCom(int ind,int[] arr,int target,List<List<Integer>> ans,List<Integer> ds){
        if(ind == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[ind] <= target){
            ds.add(arr[ind]);
            findCom(ind,arr,target-arr[ind],ans,ds);
            ds.remove(ds.size()-1);
        }
        findCom(ind + 1,arr,target,ans,ds);
    }
}