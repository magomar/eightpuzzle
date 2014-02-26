package deludobellico.util;

/**
 * @author Mario Gomez
 */
public class SingleThreadStopwatch {
    private long start;
    private long stop;

    /**
     *
     */
    public void start() {
        start = Timing.getCpuTime(); // start timing
        stop = start;
    }

    public long stop() {
        stop = Timing.getCpuTime();
        return stop - start;
    }


    public long getTotalTime() {
        return Timing.getCpuTime() - start;
    }

    public long getPartialTime() {
        return Timing.getCpuTime() - stop;
    }

    public static String timeToString(long time) {
        return "   Time: " + Long.toString(time/1000) + "ms"; // returns execution time
    }

}
