package Junit;

import com.example.Junit_Testing.Product;
import com.example.Junit_Testing.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class ShoppingCartTest {

    ShoppingCart shoppingCart;

    @BeforeEach
    public void setUp(){
        shoppingCart = new ShoppingCart();
    }

    @Test
    @DisplayName("Добавление продукта: корректные данные -> товар добавлен")
    public void addProduct_correctData_productAdded(){

        String name = "Хлеб";
        double price = 3.2;
        int quantity = 100;
        Product expectedProduct = new Product("Хлеб",3.2,100);

        shoppingCart.addProduct(name,price,quantity);

        assertThat(shoppingCart.getItems(), hasSize(1));
        assertThat(shoppingCart.getItems().get(0), equalTo(expectedProduct));
    }
}
