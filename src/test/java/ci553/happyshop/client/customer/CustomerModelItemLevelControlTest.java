package ci553.happyshop.client.customer;

import ci553.happyshop.catalogue.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerModelItemLevelControlTest {

    @Test
    void searchQuantity() {
        CustomerModel cm = new CustomerModel();
        cm.cusView = new CustomerView() {

            @Override
            public void update(String image, String searchResult, String trolley, String receipt) {
            }
        };

        Product p1 = new Product("0001", "TV", "0001.jpg", 12.01, 100);

        cm.setTheProduct(p1);
        cm.addToTrolley(4);

        ArrayList<Product> tro = cm.getTrolley();

        assertEquals(4, tro.get(0).getOrderedQuantity());
    };

    @Test
    void deleteTrolleyItem() {
        CustomerModel cm = new CustomerModel();
        cm.cusView = new CustomerView() {

            @Override
            public void update(String image, String searchResult, String trolley, String receipt) {
            }
        };

        Product p1 = new Product("0001", "TV", "0001.jpg", 12.01, 100);

        cm.setTheProduct(p1);
        cm.addToTrolley(4);
        cm.deleteFromTrolley();

        ArrayList<Product> tro = cm.getTrolley();

        assertTrue(tro.isEmpty());
    }
}