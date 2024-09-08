class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list= new ArrayList<>();
        findCom(candidates,0,target,new ArrayList<Integer>(),list);
        return list;

    }
    private void findCom(int[] candidates,int currentIndex,int target,ArrayList<Integer> current,    List<List<Integer>> list){
        if(target == 0){
            list.add(new ArrayList<>(current));
            return;
        }
        if(currentIndex >= candidates.length){
            return;
        }
        
        for (int i = currentIndex; i < candidates.length; i++) {
        if (i > currentIndex && candidates[i] == candidates[i - 1]) {
                continue;  // Skip duplicate
            }
        if (candidates[i] > target) {
            break;  // No need to continue if the current candidate exceeds the target
        }
        // if(candidates[currentIndex] <= target){
            current.add(candidates[i]);
            findCom(candidates,i+1,target-candidates[i],current,list);
            current.remove(current.size()-1);
        // }
        // findCom(candidates,currentIndex+1,target,current,list);
        // return;
        }
    }
}