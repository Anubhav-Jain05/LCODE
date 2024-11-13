class Solution {
    public List<Integer> targetIndices(int[] arr, int target) {
        List<Integer> list= new ArrayList<>();
        Arrays.sort(arr);
        int firstPostiton=findfirstIndex(arr,target);
        if(firstPostiton == -1)return list;
        int lastPostion=findlastIndex(arr,target);
       for (int i = firstPostiton; i <= lastPostion; i++) {
            list.add(i);
        }
        return list;

    }
    private int findfirstIndex(int[] arr,int target){
        int ans=-1;
        int low =0;
        int high=arr.length-1;
        while(low <= high){
            int mid=low + (high - low) /2;
            if(arr[mid] == target){
                ans=mid;
                high=mid-1;
            }else if(arr[mid] < target){
                low = mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
     private int findlastIndex(int[] arr,int target){
        int ans=-1;
        int low =0;
        int high=arr.length-1;
        while(low <= high){
            int mid=low + (high - low) /2;
            if(arr[mid] == target){
                ans=mid;
                low=mid+1;
            }else if(arr[mid] < target){
                low = mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }

}