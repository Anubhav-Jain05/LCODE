class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int count =0;
        int n=tickets.length;
        while(true){
            for(int i =0 ;i<n;i++){
                if(tickets[i] > 0){
                    tickets[i] = tickets[i] - 1;
                    count ++;
                }
                if(i == k && tickets[i] == 0){
                    return count;
                }
            }
        }  
    }
}