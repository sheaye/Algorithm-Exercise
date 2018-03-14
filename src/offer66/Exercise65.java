package offer66;

import java.util.HashSet;
import java.util.Set;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class Exercise65 {

    public static void main(String[] args) {
        Exercise65 exe = new Exercise65();
        String matrixStr = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS";
        String str = "SGGFIECVAASABCEHJIGQEMS";
        System.out.println(exe.hasPath(matrixStr.toCharArray(), 5, 8, str.toCharArray()));
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> set = new HashSet<>();
            int x = i % cols;
            int y = i / cols;
            if (hasPath(matrix, rows, cols, str, set, 0, x, y)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasPath(char[] matrix, int rows, int cols, char[] str, Set<Integer> set, int i, int x, int y) {
        if (i >= str.length) {
            return true;
        }
        if (x < 0 || x >= cols || y < 0 || y >= rows) {
            return false;
        }
        int index = y * cols + x;
        if (set.contains(index) || matrix[index] != str[i]) {
            return false;
        }
        set.add(index);
        i++;
        return hasPath(matrix, rows, cols, str, set, i, x + 1, y) ||
                hasPath(matrix, rows, cols, str, set, i, x - 1, y) ||
                hasPath(matrix, rows, cols, str, set, i, x, y + 1) ||
                hasPath(matrix, rows, cols, str, set, i, x, y - 1);
    }

    public boolean hasPath2(char[] matrix, int rows, int cols, char[] str) {
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> set = new HashSet<>();
            if (hasPath(matrix, rows, cols, str, set, i, 0)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasPath(char[] matrix, int rows, int cols, char[] str, Set<Integer> set, int mi, int si) {
        if (si >= str.length) {
            return true;
        }
        if (mi >= matrix.length) {
            return false;
        }
        int x = mi % cols;
        int y = mi / cols;
        if (x < 0 || x >= cols || y < 0 || y >= rows || matrix[mi] != str[si] || set.contains(mi)) {
            return false;
        }
        si++;
        set.add(mi);
        return hasPath(matrix, rows, cols, str, set, (y + 1) * cols + x, si) ||
                hasPath(matrix, rows, cols, str, set, (y - 1) * cols + x, si) ||
                hasPath(matrix, rows, cols, str, set, y * cols + x + 1, si) ||
                hasPath(matrix, rows, cols, str, set, y * cols + x - 1, si);
    }
}
