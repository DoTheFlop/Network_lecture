package chap7;

import java.io.*;
import java.net.*;

public class Options {
	public static void main(String[] args) {
		try {		    
			URL u = new URL("http://www.cafeaulait.org/books/jnp4/postquery.phtml");
			HttpURLConnection http = (HttpURLConnection) u.openConnection();
			http.setRequestMethod("OPTIONS");
			
			for(int j = 0; ; j++) {
				String header = http.getHeaderField(j);
				if (header == null) break;
				System.out.println(http.getHeaderFieldKey(j) + ": " + header);
			}
			
		} catch (MalformedURLException ex) {
			System.err.println("not a URL I understand");
		} catch (IOException ex) {
			System.err.println(ex);
		}
		System.out.println();
	}
}