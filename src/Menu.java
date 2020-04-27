import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame implements ActionListener
{

    JFrame jf;
    JButton btn0,btn1,btn2,btn3;
    public Menu()
    {

        jf=new JFrame();
        jf.setLayout(null);

        btn0 = new JButton("Add New Room Type");
        btn0.setBounds(50,390,160,35);
        jf.add(btn0);

        btn1 = new JButton("Add New Room");
        btn1.setBounds(220,390,160,35);
        jf.add(btn1);

        btn2 = new JButton("Manage Room Type");
        btn2.setBounds(480,390,160,35);
        jf.add(btn2);

        btn3 = new JButton("Manage rooms");
        btn3.setBounds(650,390,160,35);
        jf.add(btn3);



        jf.setTitle("Menu Page");
        jf.setLocation(20,20);
        jf.setSize(900,700);
        jf.setResizable(false);

        jf.getContentPane().setBackground(Color.WHITE);
        jf.setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn0)
        {
            new AddRoomType();
        }
        if(e.getSource()==btn1)
        {
            new AddRoom();
        }
        if(e.getSource()==btn2)
        {
            new MangeRoomtype();
        }
        if(e.getSource()==btn3)
        {
            new MangeRooms();
        }

    }

    public static void main(String args[]){
        new Menu();
    }

}

