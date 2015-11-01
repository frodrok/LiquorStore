package se.bastagruppen.webshop;

import se.bastagruppen.webshop.exceptions.InvalidOrderException;
import se.bastagruppen.webshop.exceptions.InvalidProductException;
import se.bastagruppen.webshop.exceptions.InvalidUserException;
import se.bastagruppen.webshop.exceptions.OrderNotFoundException;
import se.bastagruppen.webshop.exceptions.ProductNotFoundException;
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

		} catch (UserNotFoundException | InvalidUserException e) {
			e.printStackTrace();
		} catch (InvalidProductException e) {
			e.printStackTrace();
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidOrderException e) {
			e.printStackTrace();
		} catch (OrderNotFoundException e) {
			e.printStackTrace();
		}
	}
}