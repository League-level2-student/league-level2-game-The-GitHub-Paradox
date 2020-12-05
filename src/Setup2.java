import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javazoom.jl.player.advanced.AdvancedPlayer;

public class Setup2 implements ActionListener{
	JFrame f;
	JPanel p;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	JButton b7;
	JButton b8;
	JButton b9;
	public Song song;
	public Song song1;
	public Song song2;
	public Song song3;
	public Song song4;
	public Song song5;
	public Song song6;
	public Song song7;
	public Song song8;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	Setup2(){
		song = new Song("MCEP.mp3");
		song1 = new Song("Disc11.mp3");
		song2 = new Song("Disc13.mp3");
		song3 = new Song("Disc24.mp3");
		song4 = new Song("PSp.mp3");
		song5 = new Song("Stal.mp3");
		song6 = new Song("DFRR.mp3");
		song7 = new Song("Race.mp3");
		song8 = new Song("PolishCow.mp3");
		f = new JFrame("Meme Sound Board Page 2");
		p = new JPanel(new GridLayout());p.setPreferredSize(new Dimension(100, 100));
		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();
		b4 = new JButton();
		b5 = new JButton();
		b6 = new JButton();
		b7 = new JButton();
		b8 = new JButton();
		b9 = new JButton();
		f.add(p);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		b1.setBackground(Color.red);
		b2.setBackground(Color.orange);
		b3.setBackground(Color.yellow);
		b4.setBackground(Color.green);
		b5.setBackground(Color.yellow);
		b6.setBackground(Color.green);
		b7.setBackground(Color.yellow);
		b8.setBackground(Color.orange);
		b9.setBackground(Color.red);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b1.setText(" 1 ");
		b2.setText(" 2 ");
		b3.setText(" 3 ");
		b4.setText(" 4 ");
		b5.setText(" 5 ");
		b6.setText(" 6 ");
		b7.setText(" 7 ");
		b8.setText(" 8 ");
		b9.setText(" 9 ");
	}

	public void run() {
		f.setSize(WIDTH, HEIGHT);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		JButton buttonPressed = (JButton) e.getSource();
		if(e.getSource() == b1) {
			song.play();
		}
		if(e.getSource() == b2) {
			song1.play();
		}
		if(e.getSource() == b3) {
			song2.play();
		}
		if(e.getSource() == b4) {
			song3.play();
		}
		if(e.getSource() == b5) {
			song4.play();
		}
		if(e.getSource() == b6) {
			song5.play();
		}
		if(e.getSource() == b7) {
			song6.play();
		}
		if(e.getSource() == b8) {
			song7.play();
		}
		if(e.getSource() == b9) {
			song8.play();
		}
	}
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}
}

class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
}