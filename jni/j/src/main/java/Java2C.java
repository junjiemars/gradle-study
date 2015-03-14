/**
 * Created by junjie on 14/3/15.
 */
public class Java2C {
    public native int int_int(int n);
    public native boolean b_b(boolean b);
    public native String str_str(String s);
    public native int int_array_int(int[] v);

    public static void main(String[] args) {
        System.loadLibrary("java2c");
        final Java2C j2c = new Java2C();

        System.out.println(String.format("int_int(int %d)=%d", 3, j2c.int_int(3)));
        System.out.println(String.format("b_b(boolean %s)=%s", true, j2c.b_b(true)));
        System.out.println(String.format("str_str(String %s)=%s", "Hello", j2c.str_str("Hello")));
        System.out.println(String.format("int_array_int(int[] %d)=%d",
                new int[]{1,2,3}, j2c.int_array_int(new int[]{1,2,3})));
    }
}
