package Model;

public class Response<T>  { // model ส่งไปหน้าบ้าน
	private T code;
	private T result;
	
	public T getCode() {
		return code;
	}
	public void setCode(T code) {
		this.code = code;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
}
