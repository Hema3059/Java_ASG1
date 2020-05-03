import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddRoom extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel lbl1,lbl2,lbl3,lbl4,lbl5;
    JTextField txt1,txt2,txt3,txt4;
    JComboBox cmb;
    DBS db = null;
    Connection con;
    JButton btn1;
    PreparedStatement pst;
    AddRoom()
    {
        jf = new JFrame();
        jf.setLayout(null);
        db = new DBS();

        lbl5=new JLabel("Add Rooms Here");
        lbl5.setFont(new Font("Times New Roman",Font.BOLD,25));
        lbl5.setBounds(150,50,300,40);
        lbl5.setForeground(Color.black);
        jf.add(lbl5);

        lbl1 = new JLabel("Room name*");
        lbl1.setBounds(150,160,170,25);
        jf.add(lbl1);

        txt1=new JTextField(20);
        txt1.setBounds(320,160,250,25);
        txt1.setToolTipText("Enter Room name");
        jf.add(txt1);

        lbl2 = new JLabel("Seating*");
        lbl2.setBounds(150,200,170,25);
        jf.add(lbl2);

        txt2=new JTextField(20);
        txt2.setBounds(320,200,250,25);
        txt2.setToolTipText("Enter Seating Capacity");
        jf.add(txt2);

        lbl3 = new JLabel("Room Status*");
        lbl3.setBounds(150,240,170,25);
        jf.add(lbl3);

        txt3=new JTextField(20);
        txt3.setBounds(320,240,250,25);
        txt3.setToolTipText("Availbility");
        jf.add(txt3);

        lbl4 = new JLabel("Type*");
        lbl4.setBounds(150,280,170,25);
        jf.add(lbl4);

        cmb=new JComboBox();
        cmb.setBounds(320,280,250,25);
        cmb.setToolTipText("Enter Type");
        cmb.addItem("select");
        try {
            con=db.getConnection();
            Statement stm = con.createStatement();
            ResultSet rst = stm.executeQuery("Select roomtype_name from room_type");
            while (rst.next()) {
                String mrd = rst.getString("roomtype_name");
                cmb.addItem(mrd);
            }

            rst.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        jf.add(cmb);

        btn1 = new JButton("Save");
        btn1.setBounds(150,340,110,35);
        btn1.setToolTipText("click to save room details");
        jf.add(btn1);
        btn1.addActionListener(this);

        jf.setTitle("Add New Room");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.WHITE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {

            try {
                con = db.getConnection();
                System.out.println("Connected to database.");
                pst = con.prepareStatement("insert into rooms (room_name,room_capacity,room_status,room_type)values(?,?,?,?)");
                pst.setString(1, txt1.getText());
                pst.setString(2, txt2.getText());
                pst.setString(3, txt3.getText());
                pst.setString(4, cmb.getSelectedItem().toString());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this,"Room added Successfully!!","Note!!!",JOptionPane.INFORMATION_MESSAGE);
                txt1.setText("");
                txt2.setText("");
                txt3.setText("");
                con.close();
            } catch (SQLException se) {
                System.out.println(se);
                JOptionPane.showMessageDialog(null, "SQL Error:" + se);
            }
        }
    }
    public static void main(String args[])
    {
        new AddRoom();
    }
}