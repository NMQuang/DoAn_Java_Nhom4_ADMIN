package foodGroup4Quanly.common;

public class MyBadRequestException extends Exception{

	public MyBadRequestException(String url){
		super(url);
	}
	
}
