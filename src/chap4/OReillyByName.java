package chap4;

import java.net.*;

public class OReillyByName {
	public static void main(String args[]) {
		try {
			InetAddress address = InetAddress.getByName("www.google.com");
			System.out.println(address);
			System.out.println("Host name: " + address.getHostName());
			System.out.println("Canonical Host name: " + address.getCanonicalHostName());
		} 
		catch (UnknownHostException ex) {
			System.out.println("Could not find www.google.com");
		}
	}
}
