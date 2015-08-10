import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.concurrent.*;

/**
 * Author: junjie
 * Date: 8/7/15.
 * Target: <>
 */
public class FutureDemo {

    public static void main(final String[] args) {
        raw();
        task();
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
            _l.info(s);
        } catch (ExecutionException ee) {

        } catch (InterruptedException ie) {
            _l.error(ie.getMessage(), ie);
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
            _l.info(s);
        } catch (ExecutionException ee) {
            _l.error(ee.getMessage(), ee);
        } catch (InterruptedException ie) {
            _l.error(ie.getMessage(), ie);
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
                _l.info("#canceled");
            } else {
                _l.info(future.get());
            }
        } catch (Exception e) {
            _l.error(e.getMessage(), e);
        }
    }


    private static final <T> String long_time(final T t) {
        String r = String.format("#long_time(origin:%s):%s", t, System.currentTimeMillis());
        try {
            Thread.sleep(5000);
            r = String.format("#long_time(sleep):%s", System.currentTimeMillis());
        } catch (InterruptedException ie) {
            _l.error(ie.getMessage(), ie);
        }
        return r;
    }

//    private final static Logger _l = LoggerFactory.getLogger(FutureDemo.class);
    private final static Logger _l = LogManager.getLogger(FutureDemo.class);
}
