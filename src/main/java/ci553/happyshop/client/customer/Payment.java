package ci553.happyshop.client.customer;

import ci553.happyshop.catalogue.Order;

// Payment method logic that happens when check out button is clicked
// New payment methods can be added without modifying existing logic
public class Payment {

    public interface PaymentMethod {
        void pay(Order order) throws PaymentError;
    }

    public static class PaymentError extends Exception {
        public PaymentError(String message) {
            super(message);
        }
    }

    public static class CardPayment implements PaymentMethod {

        private final String cardNumber;
        private final String securityCode;

        public CardPayment(String cardNumber, String securityCode) {
            this.cardNumber = cardNumber;
            this.securityCode = securityCode;
        }

        // Data verification for card number and security code
        @Override
        public void pay(Order order) throws PaymentError {

            if (cardNumber == null || !cardNumber.matches("\\d{16}")) {
                throw new PaymentError("Card number must be 16 digits.");
            }

            if (securityCode == null || !securityCode.matches("\\d{3}")) {
                throw new PaymentError("Security code must be 3 digits.");
            }

            order.setPaid(true);
        }
    }
}
