package es.com.springdemo.rest;

public class CustomerNotFoundExcepcion extends RuntimeException {

		
	public CustomerNotFoundExcepcion(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public CustomerNotFoundExcepcion(String message) {
		super(message);
	}

	public CustomerNotFoundExcepcion(Throwable throwable) {
		super(throwable);
	}
	
	public CustomerNotFoundExcepcion() {}
	
	
	
	
	
}
