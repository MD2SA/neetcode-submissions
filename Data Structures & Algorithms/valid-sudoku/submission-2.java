class Solution {
    private static final int board_size = 9;

    public boolean isValidSudoku(char[][] board) {
        //Validate rows
        if(!areRowsValid(board))
            return false;
        //Validate cols
        if(!areColumnsValid(board))
            return false;
        //Validate squares
        if(!areSquaresValid(board))
            return false;
        return true;

    }

    private boolean areSquaresValid(char[][] board) {
        for(int k = 0; k<board_size; k++) {
            int[] nums = new int[9];
            for(int i = 0; i<3; i++) {
                for(int j = 0; j<3; j++) {
                    int row = (k/3)*3+i;
                    int col = (k%3)*3+j;
                    if(board[row][col] == '.') continue;
                    if(nums[board[row][col]-'1']++ != 0) return false;
                }
            }
        }
        return true;
    }

    private boolean areRowsValid(char[][] board) {
        for(int i = 0; i<board_size; i++) {
            int[] nums = new int[9];
            for(char c : board[i])
                if(c!='.' && nums[c-'1']++ != 0)
                    return false;
        }
        return true;
    }


    private boolean areColumnsValid(char[][] board) {
        for(int col = 0; col<board_size; col++)  {
            int[] nums = new int[9];
            for(int i = 0; i<board_size; i++) {
                char c = board[i][col];
                if(c!='.' && nums[c-'1']++ != 0)
                    return false;
            }
        }
        return true;
    }
}
