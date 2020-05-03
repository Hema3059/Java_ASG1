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
    JLabel lbl1,lbl2,lbl3;
    JComboBox cmb1,cmb2;
    JButton btn1,btn2;
    DBS db = null;
    Connection con;
    PreparedStatement pst;
    JDatePickerImpl datePk;
    SqlDateModel datemdl;
    ManageScheduling()
    {
        jf = new JFrame();
        jf.setLayout(null);
        db = new DBS();

        lbl1=new JLabel("Room Scheduling");
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

        lbl3= new JLabel("Enter Day Type*");
        lbl3.setBounds(150,200,210,25);
        jf.add(lbl3);

        cmb2= new JComboBox();
        cmb2.setBounds(320,200,200,25);
        cmb2.setToolTipText("Choose Type");
        cmb2.addItem("Select Day Type");
        cmb2.addItem("Holiday");
        cmb2.addItem("Weekend");
        cmb2.addItem("TermTime");
        jf.add(cmb2);

        btn1 = new JButton("Schedule");
        btn1.setBounds(150,250,110,35);
        btn1.setToolTipText("click to schedule");
        jf.add(btn1);
        btn1.addActionListener(this);

        btn2= new JButton("All");
        btn2.setBounds(450,320,110,35);
        btn2.setToolTipText("click to view all  details");
        jf.add(btn2);
        btn2.addActionListener(this);

        jf.setTitle("Add Schedule");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.white);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }


    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==btn1)
        {
            if((cmb1.getSelectedItem().toString().equals("Select Room")) || (cmb2.getSelectedItem().toString().equals("Select Day Type")) || datePk.getModel().getValue()=="")
            {
                JOptionPane.showMessageDialog(this,"* Detail are Missing !","Warning!!!",JOptionPane.WARNING_MESSAGE);
            }

            else
            {
                try
                {
                    con=db.getConnection();
                    System.out.println("Connected to database.");

                    pst=con.prepareStatement("insert into room_scheduling (room,s_date,d_type) values(?,?,?)");
                    pst.setString(1,cmb1.getSelectedItem().toString());
                    pst.setDate(2, (java.sql.Date) datePk.getModel().getValue());
                    pst.setString(3,cmb1.getSelectedItem().toString());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this,"Room Scheduled Successfully!!","Note!!!",JOptionPane.INFORMATION_MESSAGE);
                    con.close();
                }
                catch(SQLException se)
                {
                    System.out.println(se);
                    JOptionPane.showMessageDialog(null,"SQL Error:"+se);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null,"Error:"+e);
                }
            }
        }

    }
    public static void main(String args[])
    {
        new ManageScheduling();
    }
}