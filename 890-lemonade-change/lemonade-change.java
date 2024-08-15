class Solution {
    public boolean lemonadeChange(int[] bills) {
        
        int count_five=0;
        int count_ten=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                count_five++;
            }else if(bills[i]==10){
                if(count_five == 0){
                    return false;
                }
                count_five--;
                count_ten++;
            }else if(bills[i]==20){
                if(count_five != 0 && count_ten != 0){
                    count_five--;
                    count_ten--;
                }else if(count_five >= 3){
                    
                    count_five-=3;
                    
                }else{
                    return false;
                }
            }
        }
        
        return true;
    }
}