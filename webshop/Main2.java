package se.bastagruppen.webshop;

import se.bastagruppen.webshop.exceptions.UserNotFoundException;
import se.bastagruppen.webshop.interfaces.OrderRepository;
import se.bastagruppen.webshop.interfaces.ProductRepository;
import se.bastagruppen.webshop.interfaces.UserRepository;
import se.bastagruppen.webshop.model.Order;
import se.bastagruppen.webshop.model.OrderRow;
import se.bastagruppen.webshop.model.Product;
import se.bastagruppen.webshop.model.User;
import se.bastagruppen.webshop.repository.FileOrderRepository;
import se.bastagruppen.webshop.repository.FileProductRepository;
import se.bastagruppen.webshop.repository.FileUserRepository;
import se.bastagruppen.webshop.service.ECommerceService;

public final class Main2 {

    private static ECommerceService shopService;

    public static void main(String[] args) {
        OrderRepository orderRepository = new FileOrderRepository("orders", "orders.dat");
        ProductRepository productRepository = new FileProductRepository("products", "products.dat");
        UserRepository userRepository = new FileUserRepository("users", "users.dat");

        shopService = new ECommerceService(userRepository, orderRepository, productRepository);

        System.out.println("ALL USERS:");
        for (User user : shopService.getAllUsers()) {
            System.out.println("ID: " + user.getId() + ", username: " + user.getUsername() + ", password: " + user.getPassword());
        }

        System.out.println("\nALL PRODUCTS:");
        for (Product product : shopService.getAllProducts()) {
            System.out.println("ID: " + product.getId() + ", productName: " + product.getName() + ", productPrice: " + product.getPrice());
        }

        System.out.println("\nALL ORDERS:");
        for (Order order : shopService.getAllOrders()) {
            System.out.println("ID: " + order.getId() + ", user: " + order.getUser().getUsername());

            System.out.println("ORDER ROWS:");
            for (OrderRow row : order.getOrderRows()) {
                System.out.println(row.getProduct().getName() + ", price: " + row.getRowPrice());
            }
        }
    }
}
