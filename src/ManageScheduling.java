import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.SqlDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Properties;

public class ManageScheduling extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel lbl1,lbl2;
    JComboBox cmb1;
    DBS db = null;
    Connection con;
    JDatePickerImpl datePk;
    SqlDateModel datemdl;
    ManageScheduling()
    {
        jf = new JFrame();
        jf.setLayout(null);
        db = new DBS();

        lbl1=new JLabel("Scheduling Room");
        lbl1.setFont(new Font("Times New Roman",Font.BOLD,25));
        lbl1.setBounds(150,50,300,40);
        lbl1.setForeground(Color.black);
        jf.add(lbl1);

        lbl2 = new JLabel("Select Room *");
        lbl2.setBounds(150,120,130,25);
        jf.add(lbl2);

        cmb1=new JComboBox();
        cmb1.setBounds(320,120,200,25);
        cmb1.setToolTipText("Select Room");
        jf.add(cmb1);
        cmb1.addItem("Select Room");

        try {
            con=db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select room_name from rooms");
            while (rs.next()) {
                String round = rs.getString("room_name");
                cmb1.addItem(round);
            }
            rs.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        lbl2= new JLabel("Select Date *");
        lbl2.setBounds(150,160,170,25);
        jf.add(lbl2);

        datemdl = new SqlDateModel();
        Properties p = new Properties();
        p.put("text.today", "today");
        p.put("text.month", "month");
        p.put("text.year", "year");
        JDatePanelImpl datePanel = new JDatePanelImpl(datemdl, p);
        datePk = new JDatePickerImpl(datePanel, new DatelblFormatter());
        datemdl.setSelected(true);
        datePk.setBounds(320,160,200,25);datePk.setToolTipText("Select Date");
        jf.add(datePk);

        jf.setTitle("Add Schedule Type");
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
        new ManageScheduling();
    }
}