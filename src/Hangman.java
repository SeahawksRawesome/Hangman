import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Hangman {

	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<String>();

		String numsParse = JOptionPane.showInputDialog("Pick A number, any number fo.");

		for (int i = 0; i < numsParse.length(); i++) {

			String fileContent = "";
			try {
				BufferedReader dictionaryReader = new BufferedReader(new FileReader("src//dictionary.txt"));

				String line = dictionaryReader.readLine();
				words.add(line);

				dictionaryReader.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(words);

	}
}
