import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

import static java.lang.System.out;

/**
 * Author: junjie
 * Date: 2/10/15.
 */
public final class Core {

    public static void main(final String args[]) {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        int x = 0, y = 0;
        final Stack<Integer> operators = new Stack<Integer>();
        final Queue<Integer> operands = new LinkedList<Integer>();

        do {
            input = read_line(reader);

            if (null == input) {
                continue;
            }

            if ("clear".equals(input)) {
                operators.clear();
            } else if ("+".equals(input)) {
                add(operands);
            } else if ("-".equals(input)) {
                minus(operands);
            } else if ("*".equals(input)) {
                multiple(operands);
            } else if ("/".equals(input)) {
                divide(operands);
            } else if ("=".equals(input)) {
                out.println(operands.peek());
            } else {
                try {
                    x = Integer.parseInt(input);
                    operands.add(x);
                } catch (NumberFormatException e) {

                }
            }

        } while (!"quit".equals(input));
    }

    private static final String read_line(final BufferedReader reader) {
        try {
            final String s = reader.readLine();
            String i = null;
            if (null == s || s.isEmpty() || (i = s.trim()).isEmpty())
                return (null);

            return (i);
        } catch (IOException e) {

        }

        return (null);
    }

    private static final int add(final Queue<Integer> q) {
        int sum = 0;
        while (!q.isEmpty()) {
            sum += q.poll();
        }

        q.add(sum);
        return (sum);
    }

    private static final int minus(final Queue<Integer> q) {
        int m = 0;
        while (!q.isEmpty()) {
            m -= q.poll();
        }

        q.add(m);
        return (m);
    }

    private static final int multiple(final Queue<Integer> q) {
        int m = 1;
        while (!q.isEmpty()) {
            m *= q.poll();
        }

        q.add(m);
        return (m);
    }

    private static final int divide(final Queue<Integer> q) {
        if (q.isEmpty())
            return (0);

        int d = q.poll();
        while (!q.isEmpty()) {
            d /= q.poll();
        }

        q.add(d);
        return (d);
    }

    private static final int equal(final Queue<Integer> q) {
        return (q.peek());
    }

    private Core() {
    }
}
