package chap2;

import java.io.*;

public class chap2_DataOutputStream {
	
	static final String dataFile = "data.bin";

	static final int[] Integer = { 1, 2 };
	static final double[] Double = { 1.0, 2.0 };
	static final String[] Char = { "abc«—πÁ", "abc¥Î«–±≥" };
	
	public static void main(String[] args) throws IOException{
		try(DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))){
			for(int i = 0; i < Integer.length; i++) {
				out.writeInt(Integer[i]);
				out.writeDouble(Double[i]);
				out.writeUTF(Char[i]);
			}
		}
		
		try(DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)))){
			
			double Double;
			int Integer;
			String Char;
			try {
				while (true) {
					Integer = in.readInt();
					Double = in.readDouble();
					Char = in.readUTF();
					System.out.format("%d %.2f %s\n", Integer, Double, Char);
				}
			}
			catch (EOFException e) {}	
		}
	}
}
