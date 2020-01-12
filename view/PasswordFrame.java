package view;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PasswordFrame extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel passwordLabel;
	private JButton submit;
    private JTextArea textArea;
    private JPanel mainPanel;

    public PasswordFrame() {
    
        setTitle( "Password Input" );
        createComponents();
        setLayout();
        addComponents();
        setComponentSize();
        
        setPreferredSize( new Dimension( 270, 200 ) );
        pack();
        setLocationRelativeTo( null );
        dispatchEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
    
    }
    
    public JTextArea getPassword() {
    
        return textArea;
    
    }
    
    public JButton getSubmitButton() {
    
        return submit;
    
    }
    
    private void setComponentSize() {
    
        passwordLabel.setPreferredSize( new Dimension( 200, 100 ));
        passwordLabel.setFont( new Font( "ARIEL", Font.BOLD, 30 ) );
        
        textArea.setFont( textArea.getFont().deriveFont( 32f ) );
    
    }
    
    private void addComponents() {
    
        mainPanel.add( passwordLabel );
        mainPanel.add( textArea );
        mainPanel.add( submit );
        
        setContentPane( mainPanel );
    
    }
    
    private void setLayout() {
    
        mainPanel.setLayout( new BoxLayout( mainPanel, BoxLayout.Y_AXIS ) );
    
    }
    
    private void createComponents() {
    
        passwordLabel = new JLabel( "Password:", JLabel.CENTER );
        passwordLabel.setAlignmentX( JLabel.CENTER_ALIGNMENT );
        submit = new JButton( "Submit" );
        submit.setAlignmentX( JLabel.CENTER_ALIGNMENT );
        textArea = new JTextArea();
        mainPanel = new JPanel();
    
    }

}
