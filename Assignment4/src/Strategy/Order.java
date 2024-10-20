package Strategy;

public class Order {
    private double amount;
    private PaymentStrategy paymentStrategy;

    public Order(double amount) {
        this.amount = amount;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public double calculateFinalCost() {
        return paymentStrategy.calculateFinalCost(amount);
    }
}
