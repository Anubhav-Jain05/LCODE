class Solution {
    public int findMaxK(int[] nums) {
      int largest=-1;
      HashSet<Integer> set = new HashSet<>();
      for(int num : nums){
        set.add(num);
      }
      for(int num : set){
        if(set.contains(-num)){
            largest= Math.max(largest,num);
        }
      }
      return largest;
    }
}