import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman {

	int lives = 10;
	String word = "";
	int x1 = 200;
	int y1 = 200;
	
	public static void main(String[] args) {
		Stack<String> wordStack = new Stack<String>();
		ArrayList<String> words = new ArrayList<String>();
		Random wordChooser = new Random();
		String numsParse = JOptionPane.showInputDialog("Pick A number, any number fo.");
		int wordAmount = Integer.parseInt(numsParse);
		String fileContent = "";
		String line = "";
		
		
		Hangman hangmanGUI = new Hangman();
		
		
		
		for (int i = 0; i < wordAmount; i++) {
			try {
				BufferedReader dictionaryReader = new BufferedReader(new FileReader("src//dictionary.txt"));
				int randWord = wordChooser.nextInt(2999);

				for (int x = 0; x < randWord; x++) {
					dictionaryReader.readLine();
				}
				line = dictionaryReader.readLine();
				// words.add(line);
				wordStack.push(line);
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
		
	}
	 Hangman(){
		//System.out.println("hi");
		JFrame f1 = new JFrame();
		JPanel p1 = new JPanel();
		JLabel GuessWord = new JLabel();
		JLabel word = new JLabel();
		JLabel Lives = new JLabel();
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel displayTitle = new JLabel();

		Dimension d = new Dimension(100,40);
		Dimension d2 = new Dimension(100,500);
		displayTitle.setText("|| Hangman ||");
		//displayTitle.setSize(x1, y1);
		displayTitle.setLocation(200, 400);
		f1.setPreferredSize(d2);
		p1.setPreferredSize(d2);
		displayTitle.setPreferredSize(d);
		
		Lives.setText("     Lives: " + lives);
		Lives.setPreferredSize(d);
		
		f1.add(p1);
		p1.add(Lives);
		p1.add(word);
		p1.add(GuessWord);
		p1.add(displayTitle);
		f1.setVisible(true);
	//	p1.setVisible(true);
		//p1.setVisible(true);
		
		f1.pack();
		System.out.println("hi");
		
		
		
	}
}
