import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame implements ActionListener
{

    JFrame jf;
    JButton btn0,btn1;
    public Menu()
    {

        jf=new JFrame();
        jf.setLayout(null);

        btn0 = new JButton("Add New Room Type");
        btn0.setBounds(150,390,110,35);
        jf.add(btn0);

        btn1 = new JButton("Add new room");
        btn1.setBounds(200,390,110,35);
        jf.add(btn1);


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

