package src.test_flows.authenication;

public class Verifier {
    public static void equals(String actualStr, String expectedStr) {
        if (!actualStr.equalsIgnoreCase(expectedStr)) {
            throw new RuntimeException("Err, dont ");
        }
    }

    public static void equals(int num1, int num2) {
        if (num1 != num2) {
            throw new RuntimeException("Err, dont ");
        }
    }
}
