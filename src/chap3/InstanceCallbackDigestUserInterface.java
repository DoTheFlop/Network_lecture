package chap3;

import javax.xml.bind.*; // for DatatypeConverter; requires Java 6 or JAXB 1.0

public class InstanceCallbackDigestUserInterface {
	private String filename;
	private byte[] digest;
	public InstanceCallbackDigestUserInterface(String filename) {
		this.filename = filename;
	}
	public void calculateDigest() {
		InstanceCallbackDigest cb = new InstanceCallbackDigest(filename, this);
		Thread t = new Thread(cb);
		t.start();
	}
	
	void receiveDigest(byte[] digest) {
		this.digest = digest;
		System.out.println(this);
	}
	@Override
	
	public String toString() {
		String result = filename + ": ";
		if (digest != null) {
			result += DatatypeConverter.printHexBinary(digest);
		} else {
			result += "digest not available";
		}
		return result;
	}
	
	public static void main(String[] args) {
		String[] temp = {"data(1).txt", "data(2).txt", "data(3).txt"};
		for (String filename : temp) {// Calculate the digest
			InstanceCallbackDigestUserInterface d = new InstanceCallbackDigestUserInterface(filename);
			d.calculateDigest();
		}
	}
}
