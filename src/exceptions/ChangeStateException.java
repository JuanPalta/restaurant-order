package exceptions;

public class ChangeStateException extends Exception {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChangeStateException() {
		super("YOU CANT PUT THE STATE IN REVERSE");
	}
}
