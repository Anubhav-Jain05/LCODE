class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       HashMap<Integer,Boolean>map=new HashMap<>();
        for(int num:nums1){
            if(!map.containsKey(num)){
                map.put(num,true);
            }
        }
        ArrayList<Integer>list=new ArrayList<>();
        for(int num : nums2){
            if(map.containsKey(num) && map.get(num)){
                list.add(num);
                map.put(num,false);
            }
        }
        int [] result=new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }
}