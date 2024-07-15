class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>list=new ArrayList<>();
        int count1=0;
        int count2=0;
        int ele1=0,ele2=0;
        for(int i=0;i<nums.length;i++){
            if(count1==0 && ele2 != nums[i]){
                count1=1;
                ele1=nums[i];
            }else if(count2==0 && ele1 != nums[i]){
                count2=1;
                ele2=nums[i];
            }else if(ele1==nums[i])count1++;
             else if(ele2==nums[i])count2++;
             else{
                count1--;
                count2--;
             }
        }
        int cnt1=0,cnt2=0;
        for(int i=0;i<nums.length;i++){
            
            if(ele1==nums[i]){
                cnt1++;
            }
            else if(ele2==nums[i]){
                cnt2++;
            }
        }
        int min=(int)(nums.length/3)+1;
        if(cnt1 >= min){
            list.add(ele1);
        }
        if(cnt2 >= min){
            list.add(ele2);
        }
        return list;


    }
}