package chap9;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;
public class EchoServer {
	public static int DEFAULT_PORT = 7;
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(50);		
		try (ServerSocket server = new ServerSocket(DEFAULT_PORT)) {
			while (true) {
				try {
					Socket connection = server.accept();
					Callable<Void> task = new EchoTask(connection);
					pool.submit(task);
				} catch (IOException ex) {}
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
	private static class EchoTask implements Callable<Void>{
		private Socket connection;
		EchoTask(Socket connection){
			this.connection = connection;
		}
		@Override
		public Void call(){
			try {
				Writer out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String c;
				c = in.readLine();
				out.write(c);
				out.flush();
				connection.close();
			}catch(IOException ex) {
				System.err.println(ex);
			}finally {
				try {
					connection.close();
				}catch(IOException e) {}
			}
			return null;
		}
	}
}