package offer66;

public class Exercise47 {

    /**
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     *
     */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean bool = n > 0 && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        Exercise47 exe = new Exercise47();
        System.out.println(exe.Sum_Solution(100));
    }

}
