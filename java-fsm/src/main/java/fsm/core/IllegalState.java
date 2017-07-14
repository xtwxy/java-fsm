package fsm.core;

public class IllegalState extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public IllegalState() {
		super();
	}

	public IllegalState(String message) {
		super(message);
	}

	public IllegalState(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalState(Throwable cause) {
		super(cause);
	}

	protected IllegalState(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
