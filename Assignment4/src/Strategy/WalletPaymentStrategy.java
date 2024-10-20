package Strategy;

public class WalletPaymentStrategy implements PaymentStrategy {
    @Override
    public double calculateFinalCost(double amount) {
        return amount;
    }
}
