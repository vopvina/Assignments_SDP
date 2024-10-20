package Strategy;

public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public double calculateFinalCost(double amount) {
        return amount * 1.02;
    }
}
