package chap2;

import java.io.*;

public class chap2_Reader_Writer {
	public static void main(String args[]) {
		try(OutputStream outFile = new FileOutputStream("data.txt");
				OutputStreamWriter outWriter = new OutputStreamWriter(outFile, "utf-8")){//ms949, ascii
			outWriter.write("«—πÁ¥Î«–±≥test1234");
		}
		catch(IOException ex) {
			System.err.println(ex.getMessage());
		}
	}
}
