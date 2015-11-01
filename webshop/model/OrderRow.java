package se.bastagruppen.webshop.model;

import java.io.Serializable;
import java.util.UUID;

public final class OrderRow implements Serializable {
	private static final long serialVersionUID = 1465206687612696393L;
	private final String id;
	private final Product product;
	private final Integer amount;
	private final Double rowPrice;

	public OrderRow(Product product, int amount) {
		this.product = product;
		this.amount = amount;
		this.rowPrice = product.getPrice() * amount;
		this.id = UUID.randomUUID().toString();
	}

	public Product getProduct() {
		return product;
	}

	public int getAmount() {
		return amount;
	}

	public Double getRowPrice() {
		return rowPrice;
	}

	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		OrderRow other = (OrderRow) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (product == null) {
			if (other.product != null) {
				return false;
			}
		} else if (!product.equals(other.product)) {
			return false;
		}
		return true;
	}
}