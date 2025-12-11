package ci553.happyshop.client.customer;

import ci553.happyshop.catalogue.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


class CustomerModelOrganisedTrolleyTest {

    @Test
    void mergeTrolley() {
        CustomerModel cm = new CustomerModel();
        Product p = new Product("0001", "TV", "0001.jpg", 12.01, 100);

        cm.setTheProduct(p);

        cm.makeOrganisedTrolley();
        cm.makeOrganisedTrolley();
        cm.makeOrganisedTrolley();

        ArrayList<Product> tro = cm.getTrolley();
        assertEquals(1, tro.size());
        assertEquals(3, tro.get(0).getOrderedQuantity());
    }

    @Test
    void sortTrolley() {
        CustomerModel cm = new CustomerModel();
        Product p1 = new Product("0001", "TV", "0001.jpg", 12.01, 100);
        Product p2 = new Product("0002", "Monitor", "0002.jpg", 49.99, 125);
        Product p3 = new Product("0003", "Pack of Cement", "0003.jpg", 300.00, 20);
        Product p4 = new Product("0004", "Backpack", "0004.jpg", 23.99, 300);
        Product p5 = new Product("0005", "Pen", "0005.jpg", 1.49, 80);

        cm.setTheProduct(p4);
        cm.makeOrganisedTrolley();
        cm.setTheProduct(p1);
        cm.makeOrganisedTrolley();
        cm.setTheProduct(p3);
        cm.makeOrganisedTrolley();
        cm.setTheProduct(p5);
        cm.makeOrganisedTrolley();
        cm.setTheProduct(p2);
        cm.makeOrganisedTrolley();

        ArrayList<Product> tro = cm.getTrolley();

        assertEquals("0001", tro.get(0).getProductId());
        assertEquals("0002", tro.get(1).getProductId());
        assertEquals("0003", tro.get(2).getProductId());
        assertEquals("0004", tro.get(3).getProductId());
        assertEquals("0005", tro.get(4).getProductId());
    }
};