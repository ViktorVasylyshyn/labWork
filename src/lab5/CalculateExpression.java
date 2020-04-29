package lab5;

public class CalculateExpression {
    private int a;
    private int b;

    public CalculateExpression(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void getResult() {
        try {
            double result = Math.sqrt(a - b);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Operation completed.");
        }
    }
}
