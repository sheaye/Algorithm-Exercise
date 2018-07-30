package leetcode.search;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * For example,
 * Given board =
 * [
 * ["ABCE"],
 * ["SFCS"],
 * ["ADEE"]
 * ]
 * word ="ABCCED", -> returns true,
 * word ="SEE", -> returns true,
 * word ="ABCB", -> returns false.
 */
public class Exercise70 {

    public static void main(String[] args) {
        Exercise70 exe = new Exercise70();
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(exe.exist(board,"ABCCED"));
        System.out.println(exe.exist(board,"SEE"));
        System.out.println(exe.exist(board,"ABCB"));
    }


    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, m, n, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int m, int n, int i, int j, String word, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || visited[i][j]) {
            return false;
        }
        if (board[i][j] == word.charAt(index)) {
            visited[i][j] = true;
            if (exist(board, m, n, i + 1, j, word, index + 1, visited) ||
                    exist(board, m, n, i - 1, j, word, index + 1, visited) ||
                    exist(board, m, n, i, j - 1, word, index + 1, visited) ||
                    exist(board, m, n, i, j + 1, word, index + 1, visited)) {
                return true;
            }
            visited[i][j] = false;
            return false;
        }
        return false;
    }

}
