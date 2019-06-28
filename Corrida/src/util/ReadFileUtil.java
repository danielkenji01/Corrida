package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadFileUtil {

	public static BufferedReader lerArquivo(String nomeArquivo) throws FileNotFoundException {
		return new BufferedReader(new FileReader(nomeArquivo));
	}
	
}