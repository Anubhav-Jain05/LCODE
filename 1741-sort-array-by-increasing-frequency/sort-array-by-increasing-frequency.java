class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> temp= new ArrayList<>();
        for(int num:nums){
            temp.add(num);
        }
        Collections.sort(temp,(a,b)->{
            int freA=map.get(a);
            int freB=map.get(b);
            if(freA != freB){
                return freA-freB;
            }else{
                return b-a;
            }
        });
        for(int i=0;i<nums.length;i++){
            nums[i]=temp.get(i);
        }
        return nums;
    }
}