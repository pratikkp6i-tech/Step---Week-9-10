package level1;

public class ExceptionDemo {
    public static void main(String[] args) {
        handleNullPointer();
    }

    public static void handleNullPointer() {
        try {
            String text = null;
            text.length(); // Generates exception
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: Cannot access methods on a null object.");
        }
    }
}