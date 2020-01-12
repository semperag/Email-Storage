package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class EmailListener extends WindowAdapter implements ActionListener,
        KeyListener {

    EmailControl frame;
    String password;
    
    public EmailListener( EmailControl frame ) {
    
        this.frame = frame;
        password = "";
    
    }
    
    public void setPassword( String password ) {
    
        this.password = password;
    
    }

    @Override
    public void actionPerformed( ActionEvent e ) {
    
        JButton btn = (JButton) e.getSource();
        
        if ( btn instanceof JButton ) {
            try {
				handleActionEvents( btn );
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    
    }
    
    public void handleActionEvents( JButton btn ) throws IOException {
    
        String text = btn.getText();
        
        if ( text.equals( "Submit" ) ) {
        
           if ( password.equals( "1234" ) ) {
        	   
        	   frame.openEmailStorage();
        	   password = "";
        	   
           } else {
        	   
        	   JOptionPane.showMessageDialog( new JFrame(), "Password Is Incorrect!" );
        	   frame.getPassword().setText( "" );
        	   password = "";
        	   
           }
        
        } else if ( text.equals( "Add Email" ) ){
        
        	frame.newEntityAdded( password );;
        
        }
    
    }

    @Override
    public void windowClosing( WindowEvent e ) {

        System.exit( 0 );

    }

	@Override
	public void keyPressed( KeyEvent e ) {
        JTextArea textArea = (JTextArea) e.getSource();
        int length = password.length();
    	
    	if ( (int)e.getKeyChar() != 8 && frame.getPassword().equals( textArea ) 
    	        || frame.getAddedPassword().equals( textArea ) ) {
    		frame.hidePassword( textArea );
    	    password += e.getKeyChar();
    	} else if ( (int)e.getKeyChar() == 8 && length > 0 ) {
    	
    	    password = password.substring( 0, length - 1 );
    	
    	}
    	

   }

    @Override
    public void keyReleased( KeyEvent e ) {
        JTextArea textArea = (JTextArea) e.getSource();
    	
    	if ( (int)e.getKeyChar() != 8 ) {
            frame.hidePassword( textArea );
        }
    
    }

    @Override
    public void keyTyped( KeyEvent e ) {


    }

}
