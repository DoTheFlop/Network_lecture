package chap2;

import java.io.*;
public class chap2_IOStream {
	
	public static void main(String[] args) {
		try (OutputStream out = new FileOutputStream("data.txt")){
			generateCharacters(out);
		}
		catch (IOException ex){
			System.err.println(ex.getMessage());
		}
	}
	
	public static void generateCharacters(OutputStream out) throws IOException {
		
		int firstPrintableCharacter = 33;
		int numberOfPrintableCharacters = 94;
		int numberOfCharactersPerLine = 72;
		int start = firstPrintableCharacter;
		
		for(int numLine = 0; numLine < 100; numLine++) {
			for (int i = start; i < start + numberOfCharactersPerLine; i++) {
				out.write(((i - firstPrintableCharacter) % numberOfPrintableCharacters) + firstPrintableCharacter);
			}
			out.write('\r');
			out.write('\n');
			start = ((start + 1) - firstPrintableCharacter)
			% numberOfPrintableCharacters + firstPrintableCharacter;
		}
	}
}