import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
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

public class Hangman implements KeyListener {

	int lives = 10;
	String wordS = "";
	int x1 = 200;
	int y1 = 200;

	JFrame f1 = new JFrame();
	JPanel p1 = new JPanel();
	JLabel EncryptWord = new JLabel();
	JLabel word = new JLabel();
	JLabel Lives = new JLabel();

	JLabel displayTitle = new JLabel();
	String DisplayWord = "";
	String ChosenWord = "";

	public static void main(String[] args) {

		Hangman hangmanGUI = new Hangman();

	}

	Hangman() {
		Stack<String> wordStack = new Stack<String>();
		ArrayList<String> words = new ArrayList<String>();
		Random wordChooser = new Random();
		String numsParse = JOptionPane.showInputDialog("Pick A number, any number fo.");
		int wordAmount = Integer.parseInt(numsParse);
		String fileContent = "";
		String line = "";

		// System.out.println("hi");

		Dimension d = new Dimension(100, 40);
		Dimension d2 = new Dimension(500, 500);
		displayTitle.setText("|| Hangman ||");
		// displayTitle.setSize(x1, y1);
		displayTitle.setLocation(200, 400);
		f1.setPreferredSize(d2);
		p1.setPreferredSize(d2);
		displayTitle.setPreferredSize(d);

		Lives.setText("     Lives: " + lives);
		Lives.setPreferredSize(d);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.add(p1);
		p1.add(Lives);
		p1.add(word);
		p1.add(EncryptWord);
		p1.add(displayTitle);
		f1.addKeyListener(this);
		f1.setVisible(true);

		f1.pack();
		System.out.println("hi");

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

		ChosenWord = wordStack.pop();

		for (int i = 0; i < ChosenWord.length(); i++) {
			DisplayWord += "_";
			// ChosenWord.charAt(i);
		}
		word.setText(DisplayWord);
		System.out.println(ChosenWord);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (ChosenWord.contains("" + e.getKeyChar())) {
			// New Display Word
			String emptyBoi = "";
			// String equalBoi = "";
			String tempString = "";
			String succesfulLetters = "";
			for (int i = 0; i < DisplayWord.length(); i++) {

				if (e.getKeyChar() == ChosenWord.charAt(i)) {

					emptyBoi += ChosenWord.charAt(i);

					// equalBoi += ChosenWord.charAt(i);
				} else {
					emptyBoi += DisplayWord.charAt(i);
				}

			}
			DisplayWord = emptyBoi;
			word.setText(DisplayWord);
		} else {
			lives -= 1;
			Lives.setText("     Lives: " + lives);
		}
		if(DisplayWord.length() == ChosenWord.length())  {
			if (DisplayWord.equals(ChosenWord)) {
				Reset(DisplayWord);
			}
		}
		
		if (lives == 0) {
			f1.dispatchEvent(new WindowEvent(f1, WindowEvent.WINDOW_CLOSING));
			// System.out.println("Yeet");
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public String Reset(String resetWord) {
		int Length;
		Length = DisplayWord.length();
		DisplayWord = "";
		
		for (int i = 0; i < Length; i++) {
			DisplayWord += "_";

		}
		return DisplayWord;
	}
}
