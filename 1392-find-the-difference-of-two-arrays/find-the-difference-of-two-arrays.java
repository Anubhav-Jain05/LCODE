class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> list= new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1=new HashSet<>();
        for(int num:nums1){
            set.add(num);
        }
        for(int num : nums2){
            set1.add(num);
        }
        ArrayList<Integer> res= new ArrayList<>();
        for(int num:nums1){
            if(!set1.contains(num) && !res.contains(num)){
                res.add(num);    
            }
        }
        ArrayList<Integer> res1=new ArrayList<>();

        for(int num : nums2){
            if(!set.contains(num) && !res1.contains(num)){
                res1.add(num);   
            }
        }
        list.add(res);
        list.add(res1);
    return list;
    }
}