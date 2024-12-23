class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        ArrayList<Integer> list= new ArrayList<>();
        for(int num : nums2){
            if(set.contains(num) && !list.contains(num)){
                list.add(num);
            }
        }
        int[] res= new int[list.size()];
        int index=0;
        for(int i=0;i<list.size();i++){
            res[index++]=list.get(i);
        }
        return res;
    }
}