class Solution {
    public long minEnd(int n, int x) {
        // long[] nums=new long[(int) n];
        // nums[0]=x;
        // long currentvalue=x;
        // for(int i=1;i<n;i++){
        //     long nextvalue=currentvalue + 1;
        //     while((nextvalue & x) != x){
        //         nextvalue++;
        //     }
        //     nums[i]=nextvalue;
        //     currentvalue=nextvalue;
        // }
        // return nums[(int) n-1];
        long result = x;
        long remaining = n - 1;
        long position = 1;
        
        while (remaining != 0) {
            if ((x & position) == 0) {
                result |= (remaining & 1) * position;
                remaining >>= 1;
            }
            position <<= 1;
        }
        
        return result;
    }
}