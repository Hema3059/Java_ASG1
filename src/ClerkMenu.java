import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClerkMenu extends JFrame implements ActionListener
{
    JFrame jf;
    ClerkMenu(){
        jf = new JFrame();
        jf.setLayout(null);

        jf.setTitle("Clerk Menu Page");
        jf.setLocation(20,20);
        jf.setSize(900,700);
        jf.setResizable(false);

        jf.getContentPane().setBackground(Color.WHITE);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String args[])
    {
        new ClerkMenu();
    }
}