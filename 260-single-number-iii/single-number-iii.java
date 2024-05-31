class Solution {
    public int[] singleNumber(int[] nums) {
        int arr[]=new int[2];
        int index=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            if(entry.getValue() == 1){
                arr[index++]=entry.getKey();
                if(index == 2){
                    break;
                }
            }
        }
        return arr;
    }
}