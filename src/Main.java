import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.security.SecureRandom;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class Main {

	private int height, width;

	private String[] styles;
	private String[] themes;
	private String[] topics;

	BufferedReader inFile = null;

	public static void main(String[] args) {
		
		// Set's application look and feel
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}

		Main main = new Main(600, 600);
		main.loadStyles();
		main.loadThemes();
		main.loadTopics();
	}

	public Main(int height, int width) {

		this.height = height;
		this.width = width;

		// Create JFrame
		JFrame frame = new JFrame("Random Topic Generator");
		frame.setMinimumSize(new Dimension(this.height, this.width));
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(3, 2));
		frame.setResizable(false);
		frame.setVisible(true);
		frame.isFocusable();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create Topic field
		JTextArea topicArea = new JTextArea();
		topicArea.setBackground(Color.GRAY);
		topicArea.setEditable(false);
		topicArea.setLineWrap(true);
		frame.add(topicArea);

		// Random generate topic with button click
		JButton generateTopic = new JButton("Generate Random Topic");
		generateTopic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getText = topics[new SecureRandom().nextInt(topics.length)];
				topicArea.setText(getText);
			}
		});
		frame.add(generateTopic);

		// Create Theme area
		JTextArea themeArea = new JTextArea();
		themeArea.setEditable(false);
		themeArea.setBackground(Color.GRAY);
		themeArea.setLineWrap(true);
		frame.add(themeArea);

		// Random generate theme with button click
		JButton generateTheme = new JButton("Generate Random Theme");
		generateTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getText = themes[new SecureRandom().nextInt(themes.length)];
				themeArea.setText(getText);
			}
		});
		frame.add(generateTheme);

		// Create Style area
		JTextArea styleArea = new JTextArea();
		styleArea.setBackground(Color.GRAY);
		styleArea.setEditable(false);
		styleArea.setLineWrap(true);
		frame.add(styleArea);

		// Random generate style with button click
		JButton generateStyle = new JButton("Generate Random Style");
		generateStyle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getText = styles[new SecureRandom().nextInt(styles.length)];
				styleArea.setText(getText);
			}
		});
		frame.add(generateStyle);
				
		frame.pack();
	}

	public void loadStyles() {
		// Loads styles from text file and adds to array
		try {
			inFile = new BufferedReader(new FileReader("C:\\RandomTopicGen\\data files\\Styles.txt"));
			String currLine = inFile.readLine();
			while (currLine != null) {
				String[] styles = currLine.split(",");
				currLine = inFile.readLine();
				this.styles = styles;
			}
			inFile.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void loadThemes() {
		// Loads themes from text file and adds to array
		try {
			inFile = new BufferedReader(new FileReader("C:\\RandomTopicGen\\data files\\Themes.txt"));
			String currLine = inFile.readLine();
			while (currLine != null) {
				String[] themes = currLine.split(",");
				currLine = inFile.readLine();
				this.themes = themes;
			}
			inFile.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void loadTopics() {
		// Loads topics from text file and adds to array
		try {
			inFile = new BufferedReader(new FileReader("C:\\RandomTopicGen\\data files\\Topics.txt"));
			String currLine = inFile.readLine();
			while (currLine != null) {
				String[] topics = currLine.split(",");
				currLine = inFile.readLine();
				this.topics = topics;
			}
			inFile.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
