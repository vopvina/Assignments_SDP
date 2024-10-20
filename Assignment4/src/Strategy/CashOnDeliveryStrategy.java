package Strategy;

public class CashOnDeliveryStrategy implements PaymentStrategy {
    @Override
    public double calculateFinalCost(double amount) {
        return amount + 300;
    }
}