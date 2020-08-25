package DataObjects;

public class AccountRequest extends Request {

	public AccountRequest() {
		int id = 0;
	}
	
	public AccountRequest(int id) {
		this.id = id;
	}
	
	public String readToLine() {
		return ("Request for customer " + id);
	}
	
	public String toString() {
		return readToLine();
	}
}
