/**
 * 
 */
package com.veeru.spring.exceptionhandlers;

/**
 * @author Virupaksha K
 *
 */
public class ObjectNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message = "Object value not found in DB";
	private Integer errorId = 404;

	public ObjectNotFoundException() {

	}

	public ObjectNotFoundException(String message, Integer errorId) {
		super();
		this.message = message;
		this.errorId = errorId;
	}

	public String getMessage() {
		return message;
	}

	public Integer getErrorId() {
		return errorId;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setErrorId(Integer errorId) {
		this.errorId = errorId;
	}

}
