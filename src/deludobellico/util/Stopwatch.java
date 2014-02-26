package deludobellico.util;

/**
 * @author Mario Gomez
 */
public class Stopwatch {
    private long start;
    private long stop;

    /**
     *
     */
    public void start() {
        start = System.nanoTime(); // start timing
        stop = start;
    }

    public long stop() {
        stop = System.nanoTime();
        return stop - start;
    }

    public long getTotalTime() {
        return System.nanoTime() - start;
    }

    public long getPartialTime() {
        return System.nanoTime() - stop;
    }

    public static String timeToString(long time) {
        return "   Time: " + Long.toString(time/1000) + "ms"; // returns execution time
    }


}