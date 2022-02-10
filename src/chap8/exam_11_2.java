package chap8;

import java.net.*;
import java.io.*;

public class exam_11_2 {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("www.cafeaulait.org", 80);
			OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			
			String body = "&name=Choi&email=20171601%40edu.hanbat.ac.kr&age=24";
			
			out.write("POST /books/jnp4/postquery.phtml HTTP/1.1\r\n"
					+ "COOKIE: cookie1=111; cookie2=aaa; cookie3=123\r\n"
					+ "USER_AGENT: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36\r\n"
					+ "HOST: www.cafeaulait.org\r\n"
					+ "ACCEPT: text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2\r\n"
					+ "X_FORWARDED_PROTO: http\r\n"
					+ "X_FORWARDED_FOR: 125.248.188.32\r\n"
					+ "CONNECTION: close\r\n"
					+ "Content-Type: text/html; charset=UTF-8\r\n"
					+ "Content-Length: " + body.length() + "\r\n"
					+ "\r\n");
			out.flush();
			out.write(body);
			out.flush();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			OutputStream out2 = new FileOutputStream("outheml3.html");
			
			int c;
			while((c = in.read()) != -1) {
				System.out.print((char)c);
				out2.write((byte) c);
			}
			out2.flush();
			out2.close();
			socket.close();
		}catch(UnknownHostException ex) {
			System.err.println(ex);
		}catch(IOException er) {
			System.out.println(er);
		}
	}
}