class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] rem=new int[k];
        for(int num:arr){
            int remainder=((num % k) + k) % k;
            rem[remainder]++;
        }
        for(int i=0;i<=k/2;i++){
            if(i==0){
                if(rem[i] % 2 != 0)return false;
            }else if(i == k-i){
                if(rem[i] % 2 != 0)return false;
            }else{
               if(rem[i] != rem[k-i])return false;
            }
        }
        return true;
    }
}