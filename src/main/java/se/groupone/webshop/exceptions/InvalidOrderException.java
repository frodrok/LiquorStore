package se.groupone.webshop.exceptions;

public final class InvalidOrderException extends ServiceException {
	private static final long serialVersionUID = -6545090823988698477L;

	public InvalidOrderException(String message) {
		super(message);
	}
}