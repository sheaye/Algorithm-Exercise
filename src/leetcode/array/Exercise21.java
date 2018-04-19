package leetcode.array;

/**
 * Given a 2D board containing'X'and'O', capture all regions surrounded by'X'.
 * A region is captured by flipping all'O's into'X's in that surrounded region .
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class Exercise21 {

    public static void main(String[] args) {
        Exercise21 exe = new Exercise21();
        char[][] array = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        exe.solve(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(array[i][j]);
            }
            System.out.println();
        }
    }

    private int lines;
    private int rows;

    public void solve(char[][] board) {
        if (board == null) {
            return;
        }
        lines = board.length;
        if (lines < 3) {
            return;
        }
        rows = board[0].length;
        if (rows < 3) {
            return;
        }
        for (int i = 0; i < lines; i++) {
            gank(board, i, 0);
            gank(board, i, rows - 1);
        }
        for (int i = 0; i < rows; i++) {
            gank(board, 0, i);
            gank(board, lines - 1, i);
        }
        transform(board, 'O', 'X');
        transform(board, '*', 'O');
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < rows; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void gank(char[][] board, int i, int j) {
        if (i < 0 || i > lines - 1 || j < 0 || j > rows - 1) {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = '*';
            gank(board, i - 1, j);
            gank(board, i + 1, j);
            gank(board, i, j + 1);
            gank(board, i, j - 1);
        }
    }

    private void transform(char[][] board, char source, char target) {
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < rows; j++) {
                if (board[i][j] == source) {
                    board[i][j] = target;
                }
            }
        }
    }


}
