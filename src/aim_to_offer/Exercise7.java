package aim_to_offer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 */
public class Exercise7 {

    public static void main(String[] args) {
        ProgramTimer.timing("Fibonacci", new ProgramTimer.Runner() {
            @Override
            public void run() {
                System.out.println(Fibonacci(5));
            }
        });

        ProgramTimer.timing("Fibonacci2", new ProgramTimer.Runner() {
            @Override
            public void run() {
                System.out.println(Fibonacci2(5));
            }
        });
    }

    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int f1 = 0, f2 = 1, f = 0;
        for (int i = 2; i <= n; i++) {
            f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f;
    }

    public static int Fibonacci2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci2(n - 1) + Fibonacci2(n - 2);
    }
}
