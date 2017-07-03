package se.groupone.webshop.repository;

import java.util.ArrayList;
import java.util.List;
import se.groupone.webshop.interfaces.OrderRepository;
import se.groupone.webshop.model.Order;

public final class FileOrderRepository extends FileRepository
		implements
			OrderRepository {
	private final List<Order> orders;

	@SuppressWarnings("unchecked")
	public FileOrderRepository(String dir, String filename) {
		super(dir, filename);
		this.orders = (List<Order>) restoreFromDisk(); // inherited from
														// FileRepository
	}

	@Override
	public void create(Order order) {
		if (!orders.contains(order)) {
			orders.add(order);
			writeToDisk(orders); // inherited from FileRepository
		}
	}

	@Override
	public Order findById(String id) {
		for (Order order : orders) {
			if (order.getId().equals(id)) {
				return order;
			}
		}
		return null;
	}

	@Override
	public List<Order> getAll() {
		return new ArrayList<>(orders);
	}

	@Override
	public void update(Order item) {
		for (int i = 0; i < orders.size(); i++) {
			if (item.getId().equals(orders.get(i).getId())) {
				orders.remove(i);
				orders.add(item);
				writeToDisk(orders); // inherited from FileRepository
				break;
			}
		}
	}

	@Override
	public void delete(String id) {
		for (int i = 0; i < orders.size(); i++) {
			if (id.equals(orders.get(i).getId())) {
				orders.remove(i);
				writeToDisk(orders); // inherited from FileRepository
				break;
			}
		}
	}
}
