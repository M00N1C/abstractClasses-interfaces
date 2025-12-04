import java.time.LocalDateTime;

public abstract class Payment {
    private double amount;
    public Payment(double amount) {
        this.amount = amount;
    }
    public void logTransaction() {
        LocalDateTime now = LocalDateTime.now();
        System.out.printf("Payment:\nPrice: %.2f\nTime: %s%n", amount, now);
    }
    public abstract void processPayment();
}
