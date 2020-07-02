package cn.ac.iie.tools;

import java.util.concurrent.*;

public class TimeOutUtil {

        private static ExecutorService executor = Executors.newSingleThreadExecutor();

        public static <T> T process(Callable<T> task, long timeout) {
            if (task == null) {
                return null;
            }
            Future<T> futureRet = executor.submit(task);
            try {
                T ret = futureRet.get(timeout, TimeUnit.SECONDS);
                return ret;
            } catch (InterruptedException e) {
            } catch (ExecutionException e) {
            } catch (TimeoutException e) {
                if (futureRet != null && futureRet.isCancelled()) {
                    futureRet.cancel(true);
                }
            }
            return null;
        }
}
