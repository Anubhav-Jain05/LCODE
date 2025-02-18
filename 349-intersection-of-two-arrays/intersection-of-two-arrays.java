class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       HashSet<Integer> set= new HashSet<>();
       for(int num:nums1){
        set.add(num);
       } 
       HashSet<Integer> set1= new HashSet<>();
       for(int num : nums2){
        if(set.contains(num)){
            set1.add(num);
        }
       }
       int[] res= new int[set1.size()];
       int index=0;
       for(int num:set1){
        res[index++]=num;
       }
       return res;
    }
}