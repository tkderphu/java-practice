package leetcode;

public class Leet79_word_search {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean res = false;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(word.charAt(0) == board[i][j]) {
                    res = res || solve(board, word, i, j, 0, n, m);
                }
            }
        }
        return res;

    }

    private boolean solve(char[][] board, String world,  int i, int j, int c, int n, int m) {
        if(i >= n || j >= m || i <= -1 || j <= -1) return false;

        if(c > world.length()) {
            return false;
        } else if(c == world.length()) {
            return true;
        }
        if(world.charAt(c) != board[i][j]) {
            return false;
        }
        boolean res = solve(board, world, i + 1, j, c + 1, n, m) ||
                solve(board, world, i, j + 1, c + 1, n, m) ||
                solve(board, world, i - 1, j, c + 1, n, m) ||
                solve(board, world, i, j - 1, c + 1, n, m);

        return res;

    }

    public static void main(String[] args) {
        new Leet79_word_search().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCB");
    }
}
