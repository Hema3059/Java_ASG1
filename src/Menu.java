import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {

    JFrame jf;
    JButton btn0, btn1, btn2, btn3, btn4, btn5, btnlogout;
    JLabel lbl1;
    public Menu() {

        jf = new JFrame();
        jf.setLayout(null);

        lbl1 = new JLabel("Manager Menu");
        lbl1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lbl1.setBounds(130, 0, 200, 40);
        jf.add(lbl1);

        btn0 = new JButton("Add New Room Type");
        btn0.setBounds(150, 70, 160, 35);
        btn0.addActionListener(this);
        jf.add(btn0);

        btn1 = new JButton("Add New Room");
        btn1.setBounds(150, 110, 160, 35);
        btn1.addActionListener(this);
        jf.add(btn1);

        btn2 = new JButton("Manage Room Type");
        btn2.setBounds(150, 150, 160, 35);
        btn2.addActionListener(this);
        jf.add(btn2);

        btn3 = new JButton("Manage rooms");
        btn3.setBounds(150, 190, 160, 35);
        btn3.addActionListener(this);
        jf.add(btn3);

        btn4 = new JButton("Schedule the room");
        btn4.setBounds(150, 230, 160, 35);
        btn4.addActionListener(this);
        jf.add(btn4);

        btn5 = new JButton("View status");
        btn5.setBounds(150, 270, 160, 35);
        btn5.addActionListener(this);
        jf.add(btn5);


        btnlogout = new JButton("Logout");
        btnlogout.setBounds(150, 310, 160, 35);
        btnlogout.addActionListener(this);
        jf.add(btnlogout);


        jf.setTitle("Menu Page");
        jf.setLocation(20, 20);
        jf.setSize(900, 700);
        jf.setResizable(false);

        jf.getContentPane().setBackground(Color.lightGray);
        jf.setVisible(true);
        jf.setBounds(100,100, 500, 500);
    }

    public static void main(String args[]) {
        new Menu();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn0) {
            new AddRoomType();
        }
        if (e.getSource() == btn1) {
            new AddRoom();
        }
        if (e.getSource() == btn2) {
            new ManageRoomType();
        }
        if (e.getSource() == btn3) {
            new ManageRooms();
        }
        if (e.getSource() == btn4) {
            new ManageScheduling();
        }
        if (e.getSource() == btn5) {
            new List();
        }

        if (e.getSource() == btnlogout) {
            new Home();
            jf.dispose();
        }

    }

}

