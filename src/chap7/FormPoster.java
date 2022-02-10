package chap7;

import java.io.*;
import java.net.*;

public class FormPoster {
	private URL url;
	// from Chapter 5, Example 5-8
	private QueryString query = new QueryString();
	
	public FormPoster (URL url) {
		if (!url.getProtocol().toLowerCase().startsWith("http")) {
			throw new IllegalArgumentException("Posting only works for http URLs");
		}
		this.url = url;
	}
	public void add(String name, String value) {
		query.add(name, value);
	}
	public URL getURL() {
		return this.url;
	}
	public InputStream post() throws IOException {
		// open the connection and prepare it to POST
		
		HttpURLConnection uc = (HttpURLConnection)url.openConnection();
		uc.setDoOutput(true);
		uc.setRequestProperty("Cookie", "cookie1=111; cookie2=aaa; cookie3=123");
		uc.setRequestProperty("User-agent", "Chrome");
		
		try (OutputStreamWriter out= new OutputStreamWriter(uc.getOutputStream(), "UTF-8")) {
			// The POST line, the Content-type header,
			// and the Content-length headers are sent by the URLConnection.
			// We just need to send the data
			out.write(query.toString());
			out.write("\r\n");
			out.flush();
		}// Return the response
		return uc.getInputStream();
	}
	public static void main(String[] args) {
		URL url;
		try {
			url = new URL("http://www.cafeaulait.org/books/jnp4/postquery.phtml");
		} catch (MalformedURLException ex) { // shouldn't happen
			System.err.println(ex);
			return;
		}
		FormPoster poster = new FormPoster(url);
		
		poster.add("name", "Choi");
		poster.add("email", "20171601@edu.hanbat.ac.kr");
		poster.add("age", "24");
		
		try (InputStream in = poster.post();
				OutputStream out = new FileOutputStream("outheml.html");) {
			// Read the response
			Reader r = new InputStreamReader(in);
			int c;
			while((c = r.read()) != -1) {
				System.out.print((char) c);
				out.write((byte)c);
			}
			System.out.println();
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}