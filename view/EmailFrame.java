package view;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class EmailFrame extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JLabel addLabel;
    private JLabel nameLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JLabel addedName;
    private JLabel addedEmail;
    private JLabel addedPassword;
    private JTextArea nameTextArea;
    private JTextArea emailTextArea;
    private JTextArea passwordTextArea;
    private JButton addEmailButton;
    
    private JPanel mainPanel;
    private JPanel namePanel;
    private JPanel emailPanel;
    private JPanel passwordPanel;
    private JPanel entityPanel;
    private JPanel addedNamePanel;
    private JPanel addedEmailPanel;
    private JPanel addedPasswordPanel;
    private JPanel addedEntityPanel;
    
    
    public EmailFrame() {
    
        setTitle( "Email Storage" );
        createComponents();
        setLayout();
        addComponents();
        setBorders();
        setSizes();
    
        setSize( new Dimension( 400, 300 ) );
        pack();
        setLocationRelativeTo( null );
        dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
        
    }
    
    public JTextArea getNameTextArea() {
    
        return nameTextArea;
    
    }
    
    public JTextArea getEmailTextArea() {
        
        return emailTextArea;
        
    }
   
    public JTextArea getPasswordTextArea() {
        
        return passwordTextArea;
        
    }
    
    public JButton getAddEmailButton() {
    
        return addEmailButton;
    
    }
    
    public JPanel getAddedNamePanel() {
    
        return addedNamePanel;
    
    }
    
    public JPanel getAddedEmailPanel() {
        
        return addedEmailPanel;
        
    }
    
    public JPanel getAddedPasswordPanel() {
        
        return addedPasswordPanel;
        
    }
    
    private void setSizes() {
    
    	addLabel.setAlignmentX( JLabel.CENTER_ALIGNMENT );
    	nameLabel.setAlignmentX( JLabel.RIGHT_ALIGNMENT );
    	emailLabel.setAlignmentX( JLabel.RIGHT_ALIGNMENT );
    	passwordLabel.setAlignmentX( JLabel.RIGHT_ALIGNMENT );
    	
    	addEmailButton.setAlignmentX( JLabel.CENTER_ALIGNMENT );
    
    	nameLabel.setPreferredSize( new Dimension( 100, 30 ) );
        emailLabel.setPreferredSize( new Dimension( 100, 30 ) );
        passwordLabel.setPreferredSize( new Dimension( 100, 30 ) );
        
        addLabel.setFont( new Font( "Ariel", 20, 20 ) );
    
        nameTextArea.setFont( nameTextArea.getFont().deriveFont( 20f ) );
        emailTextArea.setFont( nameTextArea.getFont().deriveFont( 20f ) );
        passwordTextArea.setFont( nameTextArea.getFont().deriveFont( 20f ) );
        
    }
    
    private void setBorders() {
    
        Border entityBorder = BorderFactory.createEmptyBorder( 10, 35, 10, 35 );
        Border textAreaBorder = BorderFactory.createLoweredBevelBorder();
        
        addLabel.setBorder( entityBorder );
        addedName.setBorder( entityBorder );
        addedEmail.setBorder( entityBorder );
        addedPassword.setBorder( entityBorder );
        
        nameTextArea.setBorder( textAreaBorder );
        emailTextArea.setBorder( textAreaBorder );
        passwordTextArea.setBorder( textAreaBorder );
    
    }
    
    private void addComponents() {
    
        namePanel.add( nameLabel );
        namePanel.add( nameTextArea );
        
        emailPanel.add( emailLabel );
        emailPanel.add( emailTextArea );
        
        passwordPanel.add( passwordLabel );
        passwordPanel.add( passwordTextArea );
        
        entityPanel.add( namePanel );
        entityPanel.add( emailPanel );
        entityPanel.add( passwordPanel );
        
        addedNamePanel.add( addedName );
        addedEmailPanel.add( addedEmail );
        addedPasswordPanel.add( addedPassword );
        
        addedEntityPanel.add( addedNamePanel );
        addedEntityPanel.add( addedEmailPanel );
        addedEntityPanel.add( addedPasswordPanel );
        
        mainPanel.add( addLabel );
        mainPanel.add( entityPanel );
        mainPanel.add( addEmailButton );
        mainPanel.add( addedEntityPanel );
        
        setContentPane( mainPanel );
    
    }
    
    private void setLayout() {
    
        mainPanel.setLayout( new BoxLayout( mainPanel, BoxLayout.Y_AXIS ) );
        namePanel.setLayout( new BoxLayout( namePanel, BoxLayout.X_AXIS ) );
        emailPanel.setLayout( new BoxLayout( emailPanel, BoxLayout.X_AXIS ) );
        passwordPanel.setLayout( new BoxLayout( passwordPanel, BoxLayout.X_AXIS ) );
        entityPanel.setLayout( new BoxLayout( entityPanel, BoxLayout.Y_AXIS ) );
        addedNamePanel.setLayout( new BoxLayout( addedNamePanel, BoxLayout.Y_AXIS ) );
        addedEmailPanel.setLayout( new BoxLayout( addedEmailPanel, BoxLayout.Y_AXIS ) );
        addedPasswordPanel.setLayout( new BoxLayout( addedPasswordPanel, BoxLayout.Y_AXIS ) );
        addedEntityPanel.setLayout( new BoxLayout( addedEntityPanel, BoxLayout.X_AXIS ) );
    
    }
    
    private void createComponents() {
    
        addLabel = new JLabel( "Add Entity", JLabel.CENTER  );
        nameLabel = new JLabel( "Name:    ", JLabel.RIGHT );
        emailLabel = new JLabel( "Email:    ", JLabel.RIGHT );
        passwordLabel = new JLabel( "Password:    ", JLabel.RIGHT );
        addedName = new JLabel( "Name:" );
        addedEmail = new JLabel( "Email:" );
        addedPassword = new JLabel( "Password:" );
        
        nameTextArea = new JTextArea();
        emailTextArea = new JTextArea();
        passwordTextArea = new JTextArea();
        
        addEmailButton = new JButton( "Add Email" );
        
        mainPanel = new JPanel();
        namePanel = new JPanel();
        emailPanel = new JPanel();
        passwordPanel = new JPanel();
        entityPanel = new JPanel();
        addedNamePanel = new JPanel();
        addedEmailPanel = new JPanel();
        addedPasswordPanel = new JPanel();
        addedEntityPanel = new JPanel();
    
    }

}
