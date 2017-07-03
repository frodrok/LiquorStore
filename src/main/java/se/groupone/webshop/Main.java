package se.groupone.webshop;

import se.groupone.webshop.exceptions.ServiceException;
import se.groupone.webshop.interfaces.OrderRepository;
import se.groupone.webshop.interfaces.ProductRepository;
import se.groupone.webshop.interfaces.UserRepository;
import se.groupone.webshop.model.Order;
import se.groupone.webshop.model.OrderRow;
import se.groupone.webshop.model.Product;
import se.groupone.webshop.model.User;
import se.groupone.webshop.repository.FileOrderRepository;
import se.groupone.webshop.repository.FileProductRepository;
import se.groupone.webshop.repository.FileUserRepository;

import se.groupone.webshop.service.ECommerceService;

import javax.xml.ws.Service;

public final class Main {

	private static ECommerceService shopService;

	public static void main(String[] args) {

		UserRepository userRepo = new FileUserRepository("users", "users.dat");
		ProductRepository productRepo = new FileProductRepository("products",
				"products.dat");
		OrderRepository orderRepo = new FileOrderRepository("orders",
				"orders.dat");

		shopService = new ECommerceService(userRepo, orderRepo, productRepo);

		User fredrik = new User("Fredrik", "Fredrik");
		User aram = new User("Aram", "Aram");
		User joanne = new User("Joanne", "Joanne");

		Product jackDaniels = new Product("Jack Daniels", 19.99);
		Product corona = new Product("Corona", 2.0);
		Product hennessy = new Product("Hennessy", 50.0);

		try {
			shopService.addUser(fredrik);
			shopService.addUser(aram);
			shopService.addUser(joanne);

			System.out.println("All users:");
			for (User user : shopService.getAllUsers()) {
				System.out.println("username: " + user.getUsername() + ", id: " + user.getId());
			}

			shopService.deleteUser(joanne.getId());
			User tempUser = shopService.findUserById(fredrik.getId());
			tempUser.setPassword("Fredrik123");
			shopService.updateUser(tempUser);

			System.out.println("\nAll users after deleting:");
			for (User user : shopService.getAllUsers()) {
				System.out.println("username: " + user.getUsername()
						+ ", password: " + user.getPassword());
			}

			shopService.addProduct(jackDaniels);
			shopService.addProduct(corona);
			shopService.addProduct(hennessy);

			System.out.println("\nAll products:");
			for (Product product : shopService.getAllProducts()) {
				System.out.println(
						product.getName() + ", price: " + product.getPrice());
			}

			shopService.deleteProduct(jackDaniels.getId());
			shopService.updateProduct(hennessy.getId(), 17.75);

			System.out.println("\nAll products after deleting:");
			for (Product product : shopService.getAllProducts()) {
				System.out.println(
						product.getName() + ", price: " + product.getPrice());
			}

			Order fredriksOrder = new Order(fredrik);
			OrderRow coronaRow = new OrderRow(corona, 110);
			OrderRow hennessyRow = new OrderRow(hennessy, 2);
			fredriksOrder.addOrderRow(coronaRow);
			fredriksOrder.addOrderRow(hennessyRow);

			Order aramsOrder = new Order(aram);
			OrderRow aramsCoronaRow = new OrderRow(corona, 26);
			aramsOrder.addOrderRow(aramsCoronaRow);

			shopService.addOrder(fredriksOrder);
			shopService.addOrder(aramsOrder);

			System.out.println("\narams id " + shopService.findUserById(aram.getId()).getId());
			System.out.println("corona id " + shopService.findProductById(corona.getId()).getId());
			System.out.println("fredriksorder id " + shopService.findOrderById(fredriksOrder.getId()).getId());

			System.out.println("\nALL ORDERS:");
			for (Order order : shopService.getAllOrders()) {
				System.out.println("ID: " + order.getId() + ", user: "
						+ order.getUser().getUsername());

				System.out.println("ORDER ROWS:");
				for (OrderRow row : order.getOrderRows()) {
					System.out.println(row.getProduct().getName() + ", price: "
							+ row.getRowPrice());
				}
			}

			shopService.deleteOrder(fredriksOrder.getId());

			System.out.println("\nALL ORDERS AFTER:");
			for (Order order : shopService.getAllOrders()) {
				System.out.println("ID: " + order.getId() + ", user: "
						+ order.getUser().getUsername());

				System.out.println("ORDER ROWS:");
				for (OrderRow row : order.getOrderRows()) {
					System.out.println(row.getProduct().getName() + ", price: "
							+ row.getRowPrice());
				}
			}

		} catch (ServiceException e) {
			System.out.println("Got a service exception, something happened within our service: ");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Error outside our service scope: " + e.getMessage());
		}
	}
}