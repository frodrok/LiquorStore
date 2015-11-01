package se.bastagruppen.webshop.model;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

public final class Order implements Storable {
	private static final long serialVersionUID = -2441104069144132122L;
	private final String id;
	private final User user;
	private final List<OrderRow> orderRows;
	private Double totalPrice; // final

	public Order(User user) { // ta in orderRow, kalkylera direkt
		this.id = UUID.randomUUID().toString();
		this.user = user;
		this.orderRows = new ArrayList<>();
	}

	public void addOrderRow(OrderRow orderRow) {
		orderRows.add(orderRow);
		calculateTotalPrice();
	}

	private void calculateTotalPrice() {
		totalPrice = 0.0;
		for (int i = 0; i < orderRows.size(); i++) {
			totalPrice += orderRows.get(i).getRowPrice();
		}
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public String getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public List<OrderRow> getOrderRows() {
		return new ArrayList<>(orderRows);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}

}
