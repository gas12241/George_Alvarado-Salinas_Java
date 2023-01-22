public class Main {

    public static int add(int x, int y) {
        return x + y;
    }

    public static int greaterValue(int x, int y) {
        if (x > y) {
            return x;
        } else {
            return y;
        }
    }

    public static void println(Object out) {
        System.out.println(out);
    }

    public static float add(float x, float y) {
        return x + y;
    }

    public static void printAll(Object... out) {
//        for (int i = 0; i < out.length; i++) {
//            println(out[i]);
//        }
        for (Object o: out) {
            println(o);
        }

    }
    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        int c = add(a, b);
        println("a + b: ");
        println(c);

        int greatValue = greaterValue(a, b);
        println("-------------");
        println(greatValue);

        float x = 2.5f;
        float y = 7.5f;
        float z = add(x, y);
        println("x + y: ");
        println(z);

        println("Print both c and z:");
        printAll(c, z);

        String[] strings = {"Faker", "Showmaker", "Chovy"};
        println("Print each string in the array");
        printAll(strings);

//        System.out.println("Hello world!");
    }
}