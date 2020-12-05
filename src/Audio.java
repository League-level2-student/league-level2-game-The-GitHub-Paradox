import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Audio extends Setup{
	JButton b = new JButton();
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	
	public void run() {
		JFrame f = new JFrame("Audio Tester");
		f.setVisible(true);
		JPanel p = new JPanel();
		f.add(p);
		f.setSize(500, 100);
		b.setBackground(Color.yellow);
		b.setOpaque(true);
		b1.setBackground(Color.red);
		b1.setOpaque(true);
		b2.setBackground(Color.blue);
		b2.setOpaque(true);
		b3.setBackground(Color.green);
		b3.setOpaque(true);
		p.add(b);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		b.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
	}
    static void speak(String words) {
        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
                    + words + "');\"";
            try {
                Runtime.getRuntime().exec( cmd ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        } else {
            try {
                Runtime.getRuntime().exec( "say " + words ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
    }
	@Override
	public void actionPerformed(ActionEvent e) {
JButton buttonPressed = (JButton) e.getSource();
	if(e.getSource() == b) {
		speak("Welcome");
		}
	if(e.getSource() == b1) {
			speak("To");
		}
	if(e.getSource() == b2) {
			speak("Meme");
}
	if(e.getSource() == b3) {
			speak("Soundboard");
}
		
	}
}

