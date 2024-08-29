class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n= nums1.length;
        int m= nums2.length;
        
        HashMap<Integer,Boolean> map = new HashMap<>();
        ArrayList<Integer> result= new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i],true);
            }
        }
        for(int i=0;i<m;i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i])){
                result.add(nums2[i]);
                map.put(nums2[i],false);
            }
        }
        int [] res= new int[result.size()];
        for(int i=0;i<result.size();i++){
            res[i]=result.get(i);
        }
        return res;
    }
}