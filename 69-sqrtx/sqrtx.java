class Solution {
    public int mySqrt(int x) {
        if(x==0)return 0;
       int low=1 ;
       int high=x;
       int ans=-1;
       
    //    if(x==1)return 1;
       while(low <= high){
        int mid=low + (high - low) / 2;
        // int mul=mid * mid;
        if(mid == x/mid){
            return mid;
        }
        if(mid > x/mid){
            high=mid-1;
        }else{
            ans=mid;
            low = mid + 1;    
        }
       }
       return ans;
    }
}