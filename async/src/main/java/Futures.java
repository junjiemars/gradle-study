import java.util.concurrent.*;

import static java.lang.System.out;

/**
 * Author: junjie
 * Date: 8/7/15.
 * Target: <>
 */
public class Futures {

    public static void main(final String[] args) {
        //raw();
//        task();
        cancel();
    }

    private static void raw() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return long_time("raw");
            }
        });
        // do other things while calling long_time
        try {
            String s = future.get();
            out.println(s);
        } catch (ExecutionException ee) {
            out.println(ee);
        } catch (InterruptedException ie) {
            out.println(ie);
        }
    }

    private static void task() {
        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask<String> future = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return long_time("task");
            }
        });
        executor.execute(future);
        try {
            String s = future.get();
            out.println(s);
        } catch (ExecutionException ee) {
            out.println(ee);
        } catch (InterruptedException ie) {
            out.println(ie);
        }
    }

    private static void cancel() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return long_time("cancel");
            }
        });

        try {
            if (future.cancel(true)) {
                out.println("canceled");
            } else {
                out.println(future.get());
            }
        } catch (Exception e) {
            out.println(e);
        }
    }


    private static final <T> String long_time(final T t) {
        String r = String.format("#long_time(origin:%s):%s", t, System.currentTimeMillis());
        try {
            Thread.sleep(5000);
            r = String.format("#long_time(sleep):%s", System.currentTimeMillis());
        } catch (InterruptedException ie) {
            out.println(ie);
        }
        return r;
    }
}
