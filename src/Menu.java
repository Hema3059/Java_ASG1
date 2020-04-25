import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame implements ActionListener
{

    JFrame jf;
    public Menu()
    {

        jf=new JFrame();
        jf.setLayout(null);
        

        jf.setTitle("Menu Page");
        jf.setLocation(20,20);
        jf.setSize(900,700);
        jf.setResizable(false);

        jf.getContentPane().setBackground(Color.WHITE);
        jf.setVisible(true);

    }
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public static void main(String args[]){
        new Menu();
    }

}

