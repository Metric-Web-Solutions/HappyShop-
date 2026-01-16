package ci553.happyshop.client.customer;

import ci553.happyshop.catalogue.Order;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerController {
    public CustomerModel cusModel;
    public CustomerView cusView;
    public Order currentOrder;

    public void doAction(String action) throws SQLException, IOException {
        switch (action) {
            case "Pay":
                // Create card payment object to verify card number and security code
                Payment.CardPayment cardPayment =
                        new Payment.CardPayment(cusView.tfCardNumber.getText(), cusView.tfSecurityCode.getText());

                // Print reason for order not existing
                if (currentOrder == null) {
                    System.out.println(cusModel.displayLaSearchResult);
                    break;
                }

                // Attempt payment
                try {
                    cardPayment.pay(currentOrder);
                } catch (Payment.PaymentError e) {
                    System.out.println(e.getMessage());
                }
                cusModel.checkOut(currentOrder);
                break;
            case "Delete":
                cusModel.deleteFromTrolley();
                break;
            case "Search":
                cusModel.search();
                break;
            case "Add":
                int quantity = Integer.parseInt(cusView.tfQuantity.getText());
                cusModel.addToTrolley(quantity);
                break;
            case "Cancel":
                cusModel.cancel();
                break;
            case "Check Out":
                currentOrder = cusModel.checkOutOrder();
                break;
            case "OK & Close":
                cusModel.closeReceipt();
                break;
        }
    }

    public double getTotalPrice() {
        return cusModel.calculateTotal();
    }
}
