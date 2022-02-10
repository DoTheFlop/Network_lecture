package chap7;

import java.io.*;
import java.net.*;
public class SourceViewer {
	public static void main (String[] args) {
		InputStream in = null;
		OutputStream out = null;
		try {
			// Open the URL for reading
			URL u = new URL("http://www.hanbat.ac.kr/images/kor/main/images1.jpg");
			// buffer the input to increase performance
			in = new BufferedInputStream(u.openStream());
			
			out = new FileOutputStream("hanbat.jpg");
			out = new BufferedOutputStream(out);
			// chain the InputStream to a Reader
			
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
			out.close();
		} catch (MalformedURLException ex) {
			System.err.println("https://www.hanbat.ac.kr" + " is not a parseable URL");
		} catch (IOException ex) {
			System.err.println(ex);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}
}