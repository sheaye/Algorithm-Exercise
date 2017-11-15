package exercise;

/**
 * Created by Yun on 2017/10/31.
 */

public class ProgramTimer {

    private static ProgramTimer sProgramTimer;
    private Point mCurrentPoint;

    private class Point {
        String tag;
        long millis;

        Point(String tag, long millis) {
            this.tag = tag;
            this.millis = millis;
        }
    }

    private ProgramTimer() {

    }

    public static ProgramTimer getInstance() {
        if (sProgramTimer == null) {
            sProgramTimer = new ProgramTimer();
        }
        return sProgramTimer;
    }

    public void start(String tag) {
        mCurrentPoint = new Point(tag, System.currentTimeMillis());
    }

    public void end(String tag) {
        if (mCurrentPoint != null) {
            System.out.println(mCurrentPoint.tag + " ----> " + tag + ": " + (System.currentTimeMillis() - mCurrentPoint.millis));
            mCurrentPoint = null;
        }
    }

}
