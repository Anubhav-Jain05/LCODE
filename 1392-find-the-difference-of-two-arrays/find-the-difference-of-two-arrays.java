class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> list= new ArrayList<>();
        HashMap<Integer,Boolean> map= new HashMap<>();
        for(int num:nums1){
            if(!map.containsKey(num)){
                map.put(num,true);
            }
        }
        HashMap<Integer,Boolean> map2= new HashMap<>();
        ArrayList<Integer> res= new ArrayList<>();
        for(int num:nums2){
            if(!map2.containsKey(num)){
                // list.add(num);
                map2.put(num,true);

            }
        }
        ArrayList<Integer> res2=new ArrayList<>();
        for(int num : nums1){
            if(!map2.containsKey(num) && !res.contains(num)){
                res.add(num);
            }
        }
         for(int num : nums2){
            if(!map.containsKey(num) && !res2.contains(num)){
                res2.add(num);
            }
        }
        list.add(res);
        list.add(res2);
        return list;
    }
}