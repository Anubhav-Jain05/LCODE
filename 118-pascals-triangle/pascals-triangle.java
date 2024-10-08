class Solution {
    public List<List<Integer>> generate(int numRows) {
        // int n= numRows.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int row=1;row<=numRows;row++){
            list.add(generaterow(row));
        }
        return list;
    }
    private static List<Integer> generaterow(int row){
        long ans=1;
        List<Integer>res=new ArrayList<>();
        res.add(1);
        for(int col=1;col<row;col++){
            ans=ans * (row-col);
            ans=ans/col;
            res.add((int)ans);
        }
        return res;
    
    }
}