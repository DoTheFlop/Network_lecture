package chap7;

import java.io.*;
import java.net.*;

public class AllHeaders {
	public static void main(String[] args) {
		args = new String[] {"http://localhost:8888/"};
		for (int i = 0; i < args.length; i++) {
			try {
				URL u = new URL(args[i]);
				URLConnection uc = u.openConnection();
				for (int j = 0; ; j++) {
					String header = uc.getHeaderField(j);
					if (header == null) break;
					System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
				}
			} catch (MalformedURLException ex) {
				System.err.println(args[i] + " is not a URL I understand.");
			} catch (IOException ex) {
				System.err.println(ex);
			}
			System.out.println();
		}
	}
}