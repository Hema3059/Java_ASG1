import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Menu extends JFrame implements ActionListener
{

    JFrame jf;
    JButton btn0,btn1,btn2,btn3,btn4,btn5;
    public Menu()
    {

        jf=new JFrame();
        jf.setLayout(null);

        btn0 = new JButton("Add New Room Type");
        btn0.setBounds(50,200,160,35);
        btn0.addActionListener(this);
        jf.add(btn0);

        btn1 = new JButton("Add New Room");
        btn1.setBounds(220,200,160,35);
        btn1.addActionListener(this);
        jf.add(btn1);

        btn2 = new JButton("Manage Room Type");
        btn2.setBounds(480,200,160,35);
        btn2.addActionListener(this);
        jf.add(btn2);

        btn3 = new JButton("Manage rooms");
        btn3.setBounds(650,200,160,35);
        btn3.addActionListener(this);
        jf.add(btn3);

        btn4 = new JButton("Schedule the room");
        btn4.setBounds(350,350,160,35);
        btn4.addActionListener(this);
        jf.add(btn4);

        //btn5 = new JButton("Manage clerks");
        //btn5.setBounds(220,200,160,35);
        //btn5.addActionListener(this);
        //jf.add(btn5);



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
            new ManageRoomType();
        }
        if(e.getSource()==btn3)
        {
            new ManageRooms();
        }
        if(e.getSource()==btn4)
        {
            new AddClerks();
        }
        if(e.getSource()==btn5)
        {
            new ManageClerks();
        }
    }

    public static void main(String args[]){
        new Menu();
    }

}

