class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list= new ArrayList<>();
        for(int row=1;row<=numRows;row++){
            list.add(generateRow(row));
        }
        return list;
    }
    private static List<Integer> generateRow(int row){
        long ans=1;
        List<Integer> list=new ArrayList<>();
        list.add(1);
        for(int col=1;col<row;col++){
            ans=ans * (row-col);
            ans=ans/col;
            list.add((int)ans);
        }
        return list;
    }
}