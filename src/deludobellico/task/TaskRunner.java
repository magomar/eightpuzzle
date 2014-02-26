package deludobellico.task;

import deludobellico.util.SingleThreadStopwatch;

/**
 * Created by mario on 31/01/14.
 */
public class TaskRunner {
    private static TaskRunner ourInstance = new TaskRunner();
    private final SingleThreadStopwatch stopwatch = new SingleThreadStopwatch();

    public static TaskRunner getInstance() {
        return ourInstance;
    }

    private TaskRunner() {
    }

    public void run(Task task) {
        stopwatch.start();
        task.run();
        stopwatch.stop();
        System.out.println(SingleThreadStopwatch.timeToString(stopwatch.getTotalTime()));
    }
}
