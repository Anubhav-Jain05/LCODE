class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int count_zero=0,count_one=0;
        for(int student :students){
            if(student == 1){
                count_one ++;
            }else if (student == 0){
                count_zero ++;
            }
        }
        for(int sandwich : sandwiches){
            if(sandwich == 1){
                if(count_one > 0){
                    count_one --;
                }else{
                    break;
                }
            }
            if(sandwich == 0){
                if(count_zero > 0){
                    count_zero --;
                }else{
                    break;
                }
            }
        }
        return count_one + count_zero;
    }
}