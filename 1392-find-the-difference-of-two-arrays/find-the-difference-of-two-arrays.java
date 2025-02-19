class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res= new ArrayList<>();
        HashSet<Integer> set1= new HashSet<>();
        for(int num:nums1){
            set1.add(num);
        }
        HashSet<Integer> set2=new HashSet<>();
        for(int num:nums2){
            set2.add(num);
        }
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            if(!set2.contains(nums1[i]) && !list.contains(nums1[i])){
                list.add(nums1[i]);
            }
        }
        ArrayList<Integer>list2=new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
            if(!set1.contains(nums2[i]) && !list2.contains(nums2[i])){
                list2.add(nums2[i]);
            }
        }
        res.add(list);
        res.add(list2);
        return res;
    }
}