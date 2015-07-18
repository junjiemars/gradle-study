/**
 * Author:南山
 * Create:18/7/15.
 * Target:<>
 */
public class Core {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("pls, choice one of Deadlock ... to run");
            return;
        }

        if (Deadlock.class.getSimpleName().equals(args[0])) {
            runDeadlock();
        }
    }

    private static final void runDeadlock() {
        final Deadlock.Friend alphonse = new Deadlock.Friend("Alphonse");
        final Deadlock.Friend gaston = new Deadlock.Friend("Gaston");

        new Thread(new Runnable() {
            @Override
            public void run() {
                alphonse.bow(gaston);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                gaston.bow(alphonse);
            }
        }).start();
    }
}
