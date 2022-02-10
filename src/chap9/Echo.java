package chap9;

import java.net.*;
import java.io.*;

public class Echo {
	public static void main(String[] args) {
		String hostname = "localhost";
		Socket socket = null;
		String[] text = {"Hello", "This is Choi", "Nice to meet you"};
		for (int i = 0; i < 3; i++) {
			try {
				socket = new Socket(hostname, 7);
				socket.setSoTimeout(10000);
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				pw.println(text[i]);
				pw.flush();
				
				StringBuilder Echo = new StringBuilder();
				InputStreamReader in = new InputStreamReader(socket.getInputStream(), "UTF-8");
				int c;
				while((c = in.read()) != -1) {
					Echo.append((char)c);
				}
				System.out.println(Echo);
			} catch (IOException ex) {
				System.err.println(ex);
			} finally {
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException ex) {
						System.err.println(ex);
					}
				}
			}
		}
	}
}