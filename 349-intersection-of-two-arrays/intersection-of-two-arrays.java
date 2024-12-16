class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set= new HashSet<>();
        for(int num:nums1){
            set.add(num);
        }
        ArrayList<Integer> list= new ArrayList<>();
        for(int num:nums2){
            if(set.contains(num) && !list.contains(num)){
                list.add(num);
            }
        }
        int[] res=new int[list.size()];
        int index=0;
        for(int num:list){
            res[index++]=num;
        }
        return res;
    }
}