class Solution {
    public int numSteps(String s) {
        int step=0;
        int carry=0;

        for(int i=s.length()-1;i>0;i--){
            if(s.charAt(i) - '0' + carry == 1){
                step++;
                carry=1;
            }
            step++;

        }
        step += carry;
        return step;
        // int num=Integer.parseInt(s,2);
        // int step=0;
        // while(num > 1){
        //     if(num % 2== 0){
        //         num /=2;
        //     }else{
        //         num +=1;
        //     }
        //     step ++;
        // }
        // return step;
    }
}