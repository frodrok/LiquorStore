package se.bastagruppen.webshop.exceptions;

public final class InvalidOrderException extends Exception {
	private static final long serialVersionUID = -6545090823988698477L;

	public InvalidOrderException(String message) {
		super(message);
	}
}