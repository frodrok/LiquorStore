package se.groupone.webshop.exceptions;

public final class UserNotFoundException extends ServiceException {
	private static final long serialVersionUID = 4902841442097247821L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
