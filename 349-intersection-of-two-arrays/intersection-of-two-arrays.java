class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set= new HashSet<>();
        for(int num:nums1){
            set.add(num);
        }
        HashSet<Integer> intersection=new HashSet<>();
        for(int num:nums2){
            if(set.contains(num)){
                intersection.add(num);
            }
        }
        int[] res= new int[intersection.size()];
        int index=0;
        for(int num:intersection){
            res[index++]=num;
        }
        return res;
    }
}