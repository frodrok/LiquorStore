package se.bastagruppen.webshop.exceptions;

public final class OrderNotFoundException extends Exception {
	private static final long serialVersionUID = -4322850433980584497L;

	public OrderNotFoundException(String message) {
		super(message);
	}
}
