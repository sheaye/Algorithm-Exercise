package example.dynamic;


public class DynamicExample {

    public static void main(String[] args) {

    }

    /**
     * 有一座高度是10级台阶的楼梯，从下往上走，每跨一步只能向上1级或者2级台阶。要求用程序来求出一共有多少种走法。
     */
    public static int steps(int level) {
        if (level < 1) {
            return 0;
        }
        if (level < 2) {
            return 1;
        }
        if (level < 3) {
            return 2;
        }
        int step1 = 1;
        int step2 = 2;
        int temp = 0;
        for (int i = 3; i < level; i++) {
            temp = step1 + step2;
            step1 = step2;
            step2 = temp;
        }
        return temp;
    }

    /**
     * 有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。
     * 参与挖矿工人的总数是10人。每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。
     * 要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
     * 400/5人
     * 500/5人
     * 200/3人
     * 300/4人
     * 350/3人
     */
    public static int getMostGold(int n, int w, int[] golds, int[] workers) {
        int[] preResults = new int[workers.length];
        int[] results = new int[workers.length];
        // 第一个金矿1,2,3...10个工人所能达到的最高产量
        for (int i = 0; i <= n; i++) {
            if (i < workers[0]) {
                preResults[i] = 0;
            } else {
                preResults[i] = golds[0];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (j < workers[i]) {
                    results[j] = preResults[j];
                } else {
                    results[j] = Math.max(preResults[j], preResults[j - workers[i]] + golds[i]);
                }
            }
        }
        return results[n];
    }

}
