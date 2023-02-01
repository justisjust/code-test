
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[][] visited;
    boolean exist = false;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrck(0, i, j ,board,word);
            }
        }
        return exist;
    }
    void backtrck(int start, int x, int y, char[][] board, String word) {
        if(start == word.length()) {
            exist = true;
            return;
        }
        if(x >= board.length || y >= board[0].length || x <0 || y <0 || visited[x][y]) {
            return;
        }
        if(board[x][y] == word.charAt(start)) {
            visited[x][y] = true;
            backtrck(start+1, x+1, y, board, word);
            backtrck(start+1, x-1, y, board, word);
            backtrck(start+1, x, y+1, board, word);
            backtrck(start+1, x, y-1, board, word);
            visited[x][y] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
