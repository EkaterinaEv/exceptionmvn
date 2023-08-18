package ru.netology.exeption;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(8, "ложка", 130);
    Product product2 = new Product(10, "вилка", 145);
    Product product3 = new Product(15, "тарелка", 240);

    @Test
    public void notFoundExceptionTest() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(20);
        });
    }

    @Test
    public void removeByIdTest() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.removeById(10);

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

}