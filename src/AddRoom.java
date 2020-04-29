import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddRoom extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel lbl1,lbl2,lbl3,lbl4,lbl5;
    JTextField txt1,txt2,txt3,txt4;
    JComboBox cmb;
    DB db = null;
    Connection con;
    AddRoom()
    {
        jf = new JFrame();
        jf.setLayout(null);

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

        lbl4 = new JLabel("Date*");
        lbl4.setBounds(150,280,170,25);
        jf.add(lbl4);

        txt4=new JTextField(20);
        txt4.setBounds(320,280,250,25);
        txt4.setToolTipText("Date");
        jf.add(txt4);

        lbl5 = new JLabel("Type*");
        //l3.setFont(f);
        lbl5.setBounds(150,360,170,25);
        jf.add(lbl5);

        cmb=new JComboBox();
        cmb.setBounds(320,360,250,25);
        cmb.setToolTipText("Enter Type");
        cmb.addItem("select");
        try {
            con=db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select roomtype from typemaster");
            while (rs.next()) {
                String mrd = rs.getString("roomtype");
                cmb.addItem(mrd);
            }

            rs.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        jf.setTitle("Add New Room");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.white);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String args[])
    {
        new AddRoom();
    }
}