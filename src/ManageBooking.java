import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageBooking extends JFrame implements ActionListener
{
    JFrame jf;
    ManageBooking()
    {
        jf = new JFrame();
        jf.setLayout(null);

        jf.setTitle("Manage Booking");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.white);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {

    }
    public static void main(String args[])
    {
        new ManageBooking();
    }
}