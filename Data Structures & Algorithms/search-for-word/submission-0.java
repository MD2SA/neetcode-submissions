class Solution {

    StringBuilder sb = new StringBuilder();
    String word;
    char[][] board;
    boolean found = false;

    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        boolean[][] checked = new boolean[board.length][board[0].length]; 
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                backtrack(i,j,checked);
            }
        }
        
        return found;
    }

    private void backtrack(int i, int j, boolean[][] checked) {
        if(!word.startsWith(sb.toString())) {
            return;
        }
        if(sb.length() == word.length()) {
            found = true;
            return;
        } 
        if(i<0 || j<0 || i>=checked.length || j>=checked[i].length || checked[i][j]) {
            return;
        }
        sb.append(board[i][j]);
        checked[i][j] = true;
        backtrack(i,j+1, checked);
        backtrack(i,j-1, checked);
        backtrack(i+1, j, checked);
        backtrack(i-1, j, checked);
        sb.deleteCharAt(sb.length()-1);
        checked[i][j] = false;
    }
}
