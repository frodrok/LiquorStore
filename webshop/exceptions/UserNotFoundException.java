package se.bastagruppen.webshop.exceptions;

public final class UserNotFoundException extends Exception {
	private static final long serialVersionUID = 4902841442097247821L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
