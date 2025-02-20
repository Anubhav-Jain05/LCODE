class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] res=new int[k];
        for(int num:arr){
            int rem=((num % k) +k ) %k;
            res[rem]++;
        }
        for(int i=0;i<=k/2;i++){
            if(i==0){
                if(res[i] % 2!= 0)return false;
            }else if(i == k -i){
                if(res[i] % 2 != 0)return false;
            }else{
                if(res[i] != res[k-i])return false;
            }
        }
        return true;
    }
}