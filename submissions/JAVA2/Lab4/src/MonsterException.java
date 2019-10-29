import java.lang.Exception;

public class MonsterException extends Exception {
	/**
	 * A custom exception written to raise an exception whenever we do an invalid
	 * operation on a Monster object(or its subclasses).
	 * 
	 * @param message   The message of the error.
	 */
	public MonsterException(String message) {
		super(message);
	}
}
