package se.groupone.webshop.service;

import java.util.List;
import se.groupone.webshop.exceptions.InvalidOrderException;
import se.groupone.webshop.exceptions.InvalidProductException;
import se.groupone.webshop.exceptions.InvalidUserException;
import se.groupone.webshop.exceptions.OrderNotFoundException;
import se.groupone.webshop.exceptions.ProductNotFoundException;
import se.groupone.webshop.exceptions.UserNotFoundException;
import se.groupone.webshop.interfaces.OrderRepository;
import se.groupone.webshop.interfaces.ProductRepository;
import se.groupone.webshop.interfaces.UserRepository;
import se.groupone.webshop.model.Order;
import se.groupone.webshop.model.OrderRow;
import se.groupone.webshop.model.Product;
import se.groupone.webshop.model.User;

public final class ECommerceService {
	private final UserRepository userRepo;
	private final OrderRepository orderRepo;
	private final ProductRepository productRepo;

	public ECommerceService(UserRepository userRepo, OrderRepository orderRepo,
			ProductRepository productRepo) {
		this.userRepo = userRepo;
		this.orderRepo = orderRepo;
		this.productRepo = productRepo;
	}

	public void addUser(User user) throws InvalidUserException {
		if (validUser(user, false)) {
			userRepo.create(user);
		} else {
			throw new InvalidUserException(
					"Can't add user with name: " + user.getUsername()
							+ " and password: " + user.getPassword());
		}
	}

	private boolean validUser(User user, Boolean update) {
		boolean emptyPassword = user.getPassword() == null
				|| user.getPassword().trim().length() == 0;
		boolean emptyUsername = user.getUsername() == null
				|| user.getUsername().trim().length() == 0;
		boolean userExists = userRepo.findById(user.getId()) != null;

		if (update){
			if (emptyPassword || emptyUsername || !userExists) {
				return false;
			}
		} else {
			if (emptyPassword || emptyUsername || userExists) {
				return false;
			}
		}
		return true;
	}

	public List<User> getAllUsers() {
		return userRepo.getAll();
	}

	public User findUserById(String id) throws UserNotFoundException {
		if (null != userRepo.findById(id)) {
			return userRepo.findById(id);
		}
		throw new UserNotFoundException("Could not find user with id: " + id);
	}

	public void deleteUser(String id) throws UserNotFoundException {
		if (null != userRepo.findById(id)) {
			userRepo.delete(id);
		} else {
			throw new UserNotFoundException(
					"Could not find user with id: " + id);
		}
	}

	public void updateUser(User user) throws InvalidUserException {
		if (validUser(user, true)) {
			userRepo.update(user);
		} else {
			throw new InvalidUserException(
					"Could not update user with id: " + user.getId());

		}
	}

	public void addOrder(Order order) throws InvalidOrderException {
		if (validOrder(order)) {
			orderRepo.create(order);
		} else {
			throw new InvalidOrderException(
					"Can't add order with ID: " + order.getId());
		}
	}

	private boolean validOrder(Order order) {
		boolean hasUser = order.getUser() != null;
		boolean orderExists = orderRepo.findById(order.getId()) != null;
		if (hasUser && !orderExists) {
			return true;
		}
		return false;
	}

	public void addOrderRow(String orderId, Product product, int amount)
			throws InvalidOrderException {
		if (orderRepo.findById(orderId) == null) {
			throw new InvalidOrderException(
					"Could not find order with ID: " + orderId);
		}

		Order tempOrder = orderRepo.findById(orderId);
		tempOrder.addOrderRow(new OrderRow(product, amount));

		orderRepo.update(tempOrder);
	}

	public List<Order> getAllOrders() {
		return orderRepo.getAll();
	}

	public Order findOrderById(String id) throws OrderNotFoundException {
		if (null != orderRepo.findById(id)) {
			return orderRepo.findById(id);
		}
		throw new OrderNotFoundException("Could not find order with id " + id);
	}

	// public void updateOrder(Order order) throws InvalidOrderException {
	// if (validOrder(order)) {
	// orderRepo.update(order);
	// } else {
	// throw new InvalidOrderException(
	// "Could not update order with id " + order.getId());
	// }
	// }

	public void deleteOrder(String id) throws OrderNotFoundException {
		if (null != orderRepo.findById(id)) {
			orderRepo.delete(id);
		} else {
			throw new OrderNotFoundException(
					"Could not find order with id " + id);
		}
	}

	public void addProduct(Product product) throws InvalidProductException {
		if (validProduct(product)) {
			productRepo.create(product);
		} else {
			throw new InvalidProductException(
					"Could not add product with name: " + product.getName()
							+ " and price: " + product.getPrice());
		}
	}

	private boolean validProduct(Product product) {
		boolean hasName = product.getName() != null;
		boolean hasPrice = product.getPrice() != null;
		boolean exists = productRepo.findById(product.getId()) != null;
		if (hasName && hasPrice && !exists) {
			return true;
		}
		return false;
	}

	public List<Product> getAllProducts() {
		return productRepo.getAll();
	}

	public void deleteProduct(String id) throws ProductNotFoundException {
		if (productRepo.findById(id) != null) {
			productRepo.delete(id);
		} else {
			throw new ProductNotFoundException(
					"Could not find product with id " + id);
		}
	}

	public void updateProduct(String id, Double newPrice)
			throws ProductNotFoundException {
		if (productRepo.findById(id) != null) {
			Product tempProduct = productRepo.findById(id);
			tempProduct.setPrice(new Double(newPrice));
			productRepo.update(tempProduct);
		} else {
			throw new ProductNotFoundException(
					"Could not find product with id " + id);
		}

	}

	public Product findProductById(String id) throws ProductNotFoundException {
		if (productRepo.findById(id) != null) {
			return productRepo.findById(id);
		}
		throw new ProductNotFoundException(
				"Could not find product with id " + id);
	}
}