package logico;

public class main {

	public static void main(String[] args) {
		DB db = new DB();
		Usuario user = db.getDBUser("luismateo");
		System.out.println(user);
	}

}
