class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list= new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n=nums1.length;
        int m= nums2.length;
        int i=0;
        int j=0;
        while(i < n && j < m){
            int a=nums1[i],b=nums2[j];
            if(a==b){
                list.add(a);
                i++;
                j++;
            }else if(a < b){
                i++;
            }else{
                j++;
            }
        }
        int[] res= new int[list.size()];
        for(int k=0;k<list.size();k++){
            res[k]=list.get(k);
        }
        return res;
    }
}