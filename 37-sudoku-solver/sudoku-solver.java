class Solution {
    public void solveSudoku(char[][] board) {
        sudokuSolver(board,0,0,board.length);
        return;
    }
    private boolean sudokuSolver(char[][] board,int currentRow,int currentCol,int n){
        if(currentRow == n){
            return true;
        }
        int nextRowIndex=-1;
        int nextColIndex=-1;
        if(currentCol != n-1){
             nextRowIndex=currentRow;
             nextColIndex=currentCol + 1;
        }else{
             nextRowIndex = currentRow +1;
             nextColIndex=0;
        }
        if(board[currentRow][currentCol] != '.'){
            return sudokuSolver(board,nextRowIndex,nextColIndex,n);
        }
        for(int currentVal=1;currentVal<=9;currentVal++){
            if(isValid(board,currentRow,currentCol,currentVal,n)){
                board[currentRow][currentCol]=(char)(currentVal +'0');
                if(sudokuSolver(board,nextRowIndex,nextColIndex,n)){
                    return true;
                }
                board[currentRow][currentCol]='.';
            }
        }
        return false;
    }
    private boolean isValid(char[][] board,int currentRow,int currentCol,int currentVal,int n){
        return isRowValid(board,currentRow,currentCol,currentVal,n) &&
                isColValid(board,currentRow,currentCol,currentVal,n) &&
                isSubGrid(board,currentRow,currentCol,currentVal,n);
    }
    private boolean isRowValid(char[][] board,int currentRow,int currentCol,int currentVal,int n){
        for(currentCol =0;currentCol < n; currentCol++){
            if(board[currentRow][currentCol] == (char)(currentVal +'0')){
                return false;
            }
           
        }
         return true;
    }
    private boolean isColValid(char[][] board,int currentRow,int currentCol,int currentVal,int n){
        for(currentRow =0;currentRow < n; currentRow++){
            if(board[currentRow][currentCol] == (char)(currentVal +'0')){
                return false;
            }
           
        }
         return true;
    }
    private boolean isSubGrid(char[][] board,int currentRow,int currentCol,int currentVal,int n){
        int startRowIndex=3 * (currentRow / 3);
        int startColIndex=3 * (currentCol / 3);
        for(int i=startRowIndex; i<= startRowIndex + 2;i++){
            for(int j=startColIndex;j<= startColIndex + 2;j++){
                if(board[i][j] == (char)(currentVal +'0')){
                    return false;
                }
            }
        }
        return true;
    }
}