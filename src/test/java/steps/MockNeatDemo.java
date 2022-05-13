package steps;

import net.andreinc.mockneat.MockNeat;

public class MockNeatDemo {
    public static void main(String[] args) {
        MockNeat mockNeat = MockNeat.threadLocal();

        System.out.println(mockNeat.cities().us().valStr());
        System.out.println(mockNeat.emails().valStr());
    }
}
