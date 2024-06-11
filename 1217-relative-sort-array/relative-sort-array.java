class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:arr1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] res= new int[arr1.length];
        int index=0;

        for(int num : arr2){
            if(map.containsKey(num)){
                int count=map.get(num);
                while(count > 0){
                    res[index++]=num;
                    count--;
                }
                map.remove(num);
            }
        }
        List<Integer>remainingElement=new ArrayList<>();
        for(int num:map.keySet()){
            int count=map.get(num);
            while(count > 0){
                remainingElement.add(num);
                count--;
            }
        }
        Collections.sort(remainingElement);

        for(int num:remainingElement){
            res[index++]=num;
        }
        return res;
    }
}