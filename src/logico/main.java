package logico;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		DB db = new DB();
		ArrayList<Playlist> pls = db.getPlayLists("luismateo");
		System.out.println(pls.get(0).getMiscanciones().get(0).getAlbum());
	}
}
