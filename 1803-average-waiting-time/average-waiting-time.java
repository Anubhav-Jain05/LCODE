class Solution {
    public double averageWaitingTime(int[][] customers) {
       int n=customers.length;
       long currenttime=0;
       long currentwaittime=0;
       for(int i=0;i<n;i++){
        int arrivetime=customers[i][0];
        int preptime=customers[i][1];
        if(currenttime < arrivetime){
            currenttime=arrivetime;
        }
        currenttime += preptime;
        currentwaittime +=(currenttime - arrivetime);
       }
       return (double) currentwaittime / n;
    }
}