package br.hoteleveris.app.response;

public class BaseResponse {
	private int StatusCode;
	private String Message;
	
	public BaseResponse() {
		
	}
	
	public BaseResponse(int statusCode, String message) {
		StatusCode = statusCode;
		Message = message;
	}
	public int getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	
	
	
}
