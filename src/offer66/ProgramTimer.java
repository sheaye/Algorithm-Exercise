package offer66;

/**
 * Created by Yun on 2017/10/31.
 */

public class ProgramTimer {

    public interface Runner {
        void run();
    }

    public static void timing(String tag, int loopTimes, Runner runner) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < loopTimes; i++) {
            runner.run();
        }
        long end = System.currentTimeMillis();
        System.out.println(tag + " take about " + (end - start) + " millions");
    }

    private static class Point {
        String tag;

        long millis;

        Point(String tag, long millis) {
            this.tag = tag;
            this.millis = millis;
        }
    }

    private Point mCurrentPoint;

    public ProgramTimer(String tag) {
        mCurrentPoint = new Point(tag, System.currentTimeMillis());
    }

    public void markPoint(String tag) {
        if (mCurrentPoint != null) {
            System.out.println(mCurrentPoint.tag + " ----> " + tag + ": " + (System.currentTimeMillis() - mCurrentPoint.millis));
            mCurrentPoint = null;
        }
    }
}
