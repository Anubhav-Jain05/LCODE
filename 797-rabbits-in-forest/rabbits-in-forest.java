class Solution {
    public int numRabbits(int[] answers) {
        double ans=0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int currentKey:answers){
            if(map.containsKey(currentKey)){
                map.put(currentKey,map.get(currentKey) + 1);
            }else{
                map.put(currentKey,1);
            }
        }
        for(Integer currentKey:map.keySet()){
            double groupSize=currentKey + 1;
            double numGroup=Math.ceil(map.get(currentKey)/groupSize);
            ans += (numGroup * groupSize);
        }

        return (int)ans;
    }
}