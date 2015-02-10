import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

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
        final Stack<Integer> s = new Stack<Integer>();

        do {
            input = read_line(reader);

            if (null == input) {
                continue;
            }

            if ("clear".equals(input)) {
                s.clear();
            } else if ("+".equals(input)) {
                s.push(s.pop() + s.pop());
            } else if ("-".equals(input)) {
                x = s.pop();
                y = s.pop();
                s.push(y - x);
            } else if ("*".equals(input)) {
                s.push(s.pop() * s.pop());
            } else if ("/".equals(input)) {
                x = s.pop();
                y = s.pop();
                s.push(y / x);
            } else if ("=".equals(input)) {
                out.println(s.peek());
            } else {
                try {
                    x = Integer.parseInt(input);
                    s.push(x);
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

    private Core() {
    }
}
