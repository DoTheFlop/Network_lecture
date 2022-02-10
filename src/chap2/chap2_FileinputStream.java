package chap2;

import java.io.*;

public class chap2_FileinputStream {
	
	public static void main(String[] args) {
		
		try (InputStream in = new FileInputStream("data.txt")){
			
			int bytesRead = 0;
			int bytesToRead = 1024;
			byte[] input = new byte[bytesToRead];
			
			while(bytesRead < bytesToRead) {
				int result = in.read(input, bytesRead, bytesToRead - bytesRead);
				System.out.println("result: " + result + "\n");
				
				if (result == -1) 
					break;
				bytesRead += result;
			}
			
			for(int i = 0; i < 500; i++) {
				System.out.print((char)input[i] + " ");
			}
		}
		catch(IOException ex) {
			System.err.println(ex.getMessage());
		}
	}
}