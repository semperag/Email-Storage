package control;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import view.EmailFrame;
import view.PasswordFrame;

public class EmailControl {

    private static final int ENCRYPTION = 8;
    private static final int DECRYPTION = -8;
    private PasswordFrame passwordFrame;
    private EmailFrame emailFrame;
    
    private JTextArea nameTextArea;
    private JTextArea emailTextArea;
    private JTextArea passwordTextArea;
    private JTextArea password;
    private JButton submitButton;
    private JButton addEmailButton;
    private JPanel addedNamePanel;
    private JPanel addedEmailPanel;
    private JPanel addedPasswordPanel;
    
    private EmailListener listener;
    
    private File file;
    private BufferedReader reader;
    private BufferedWriter writer;
    
    public EmailControl() throws IOException {
    
        createComponents();
        readFile();
        setListeners();
        
        passwordFrame.setVisible( true );
        emailFrame.pack();
    
    }
    
    public JTextArea getPassword() {
    
        return password;
    
    }
    
    public JTextArea getAddedPassword() {
    
        return passwordTextArea;
    
    }
    
    public void openEmailStorage() {
    
        passwordFrame.setVisible( false );
        emailFrame.setVisible( true );
    
    }
    
    public void newEntityAdded( String passW ) throws IOException {
    
        String name = nameTextArea.getText();
        String email = emailTextArea.getText();
        
        if ( name.equals( "" ) ) {
        
        	JOptionPane.showMessageDialog( new JFrame(), "Did not enter a name" );
        
        } else if ( email.equals( "" ) ) {
        
        	JOptionPane.showMessageDialog( new JFrame(), "Did not enter an email" );
        
        } else if ( passW.equals( "" ) ) {
        
        	JOptionPane.showMessageDialog( new JFrame(), "Did not enter a password" );
        
        } else {
        
            addedNamePanel.add( new JLabel( name ) );
            addedEmailPanel.add( new JLabel( email ) );
            addedPasswordPanel.add( new JLabel( passW ) );
            name = encryptText( name );
            email = encryptText( email );
            String newPass = encryptText( passW );
            writeFile( name, email, newPass );
            
            emailFrame.pack();
            
            nameTextArea.setText( "" );
            emailTextArea.setText( "" );
            passwordTextArea.setText( "" );
            JOptionPane.showMessageDialog( new JFrame(), "Successfully added a new entity!" );
            
            listener.setPassword( "" );
        
        }
    
    }
    
    public void hidePassword( JTextArea textArea ) {
    
        String passwordText = textArea.getText();
        int length = passwordText.length();
        if ( length > 0 ) {
            passwordText = passwordText.substring( 0, length-1 );
            passwordText += "*";
        }
        
        textArea.setText( passwordText );
    
    }
    
    private void readFile() throws IOException {
        
        if ( file.canRead() ) {
            reader = new BufferedReader( new FileReader( file ) );
            String word = reader.readLine();
            
            while ( word != null ) {
                String[] entity = word.split( "," );
            
                addedNamePanel.add( new JLabel( decryptText( entity[0] ) ) );
                addedEmailPanel.add( new JLabel( decryptText( entity[1] ) ) );
                addedPasswordPanel.add( new JLabel( decryptText( entity[2] ) ) );
                word = reader.readLine();
            }
            reader.close();
        } else {
        
            file.createNewFile();
        
        }
        
    
    }
    
    private void writeFile( String name, String email, String passW ) throws IOException {
        
        if ( file.canWrite() ) {
            writer = new BufferedWriter( new FileWriter( file, true ) );
            writer.append( name + "," + email + "," + passW );
            writer.newLine();
            writer.close();
        	
        }
        
    
    }
    
    private void setListeners() {
    
        passwordTextArea.addKeyListener( listener );
        password.addKeyListener( listener );
        submitButton.addActionListener( listener );
        addEmailButton.addActionListener( listener );
    
    }

    private void createComponents() {
    
        passwordFrame = new PasswordFrame();
        emailFrame = new EmailFrame();
        
        nameTextArea = emailFrame.getNameTextArea();
        emailTextArea = emailFrame.getEmailTextArea();
        passwordTextArea = emailFrame.getPasswordTextArea();
        password = passwordFrame.getPassword();
        submitButton = passwordFrame.getSubmitButton();
        addEmailButton = emailFrame.getAddEmailButton();
        addedNamePanel = emailFrame.getAddedNamePanel();
        addedEmailPanel = emailFrame.getAddedEmailPanel();
        addedPasswordPanel = emailFrame.getAddedPasswordPanel();
        
        listener = new EmailListener( this );
    
        file = new File( "EmailStorage.txt" );
    }
    
    private String encryptText( String text ) {
    
        String result = "";
        
        for ( int i = 0; i < text.length(); i++ ) {
        
            int newValue = ( (int) text.charAt( i ) ) + ENCRYPTION;
            result += (char) newValue;
        
        }
    
        return result;
    
    }
    
    private String decryptText( String text ) {
        String result = "";
        
        for ( int i = 0; i < text.length(); i++ ) {
        
            int newValue =  ( (int) text.charAt( i ) ) + DECRYPTION;
            result += (char) newValue;
        
        }
        
        return result;
    
    }
    
}
