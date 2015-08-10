import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static java.lang.System.out;

/**
 * Author: junjie
 * Date: 8/10/15.
 * Target: <>
 */
public class ExecutorDemo {
    public static void main(String[] args) {
//        direct();
        threadPerTask();
    }

    static void direct() {
        DirectExecutor direct = new DirectExecutor();
        out.println("Tid:" + H.tid());
        direct.execute(new Runnable() {
            @Override
            public void run() {
                out.println("DirectExecutor:execute()" + " Tid:" + H.tid());
            }
        });
    }

    static void threadPerTask() {
        ThreadPerTaskExecutor perTask = new ThreadPerTaskExecutor();
        out.println(String.format("ThreadPerTaskExecutor:before[tid:%d]", H.tid()));
        perTask.execute(new Runnable() {
            @Override
            public void run() {
                out.println(String.format("ThreadPerTaskExecutor:execute()[tid:%d]", H.tid()));
            }
        });
    }

    static class DirectExecutor implements Executor {

        @Override
        public void execute(Runnable command) {
            command.run();
        }
    }

    static class ThreadPerTaskExecutor implements Executor {

        @Override
        public void execute(Runnable command) {
            new Thread(command).start();
        }
    }
}
