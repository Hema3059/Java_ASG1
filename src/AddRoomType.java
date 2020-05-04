import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddRoomType extends JFrame implements ActionListener {
    JFrame jf;
    JLabel lbl1, lbl2;
    JTextField txt1;
    JButton btn1;
    Connection con;
    DBS db = null;
    PreparedStatement pst;

    AddRoomType() {
        jf = new JFrame();
        jf.setLayout(null);
        db = new DBS();
        lbl2 = new JLabel("Add New Room Type ");
        lbl2.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lbl2.setBounds(200, 50, 300, 40);
        lbl2.setForeground(Color.black);
        jf.add(lbl2);

        lbl1 = new JLabel("Enter Room Type Name*");
        lbl1.setBounds(150, 160, 170, 25);
        jf.add(lbl1);

        txt1 = new JTextField(20);
        txt1.setBounds(320, 160, 200, 25);
        txt1.setToolTipText("Enter Room Type Name");
        jf.add(txt1);

        btn1 = new JButton("Save");
        btn1.setBounds(250, 230, 110, 35);
        jf.add(btn1);
        btn1.addActionListener(this);

        jf.setTitle("Add Room Type");
        jf.setLocation(20, 20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.lightGray);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(100, 100, 700, 500);
        jf.setVisible(true);
    }

    public static void main(String args[])
    {
        new AddRoomType();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            try {
                con = db.getConnection();
                System.out.println("Connected to database.");
                pst = con.prepareStatement("insert into room_type (roomtype_name)values(?)");
                pst.setString(1, txt1.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Room type added Successfully!!", "Note!!!", JOptionPane.INFORMATION_MESSAGE);
                txt1.setText("");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
