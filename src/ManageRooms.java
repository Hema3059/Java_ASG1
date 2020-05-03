import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManageRooms extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6;
    JTextField txt1,txt2,txt3,txt4;
    JButton btn1,btn2;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JComboBox cmb;
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    DBS db = null;
    Connection con;
    Statement stm;
    ResultSet rst;
    ManageRooms(){
        jf = new JFrame();
        jf.setLayout(null);
        db = new DBS();

        lbl5=new JLabel("Manage Rooms Here");
        lbl5.setFont(new Font("Times New Roman",Font.BOLD,25));
        lbl5.setBounds(150,50,300,40);
        lbl5.setForeground(Color.black);
        jf.add(lbl5);

        lbl1 = new JLabel("Room id*");
        lbl1.setBounds(150,120,170,25);
        jf.add(lbl1);

        txt1=new JTextField(20);
        txt1.setBounds(320,120,250,25);
        txt1.setToolTipText("Enter Room id");
        jf.add(txt1);

        lbl2 = new JLabel("Room name*");
        lbl2.setBounds(150,160,170,25);
        jf.add(lbl2);

        txt2=new JTextField(20);
        txt2.setBounds(320,160,250,25);
        txt2.setToolTipText("Enter Room name");
        jf.add(txt2);

        lbl3 = new JLabel("Seating*");
        lbl3.setBounds(150,200,170,25);
        jf.add(lbl3);

        txt3=new JTextField(20);
        txt3.setBounds(320,200,250,25);
        txt3.setToolTipText("Enter Seating Capacity");
        jf.add(txt3);

        lbl4 = new JLabel("Room Status*");
        lbl4.setBounds(150,240,170,25);
        jf.add(lbl4);

        txt4=new JTextField(20);
        txt4.setBounds(320,240,250,25);
        txt4.setToolTipText("Availbility");
        jf.add(txt4);


        lbl6 = new JLabel("Type*");
        lbl6.setBounds(150,280,170,25);
        jf.add(lbl6);
        db = new DBS();
        cmb=new JComboBox();
        cmb.setBounds(320,280,250,25);
        cmb.setToolTipText("Enter Type");
        cmb.addItem("select");
        try {
            con=db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select roomtype_name from room_type");
            while (rs.next()) {
                String mrd = rs.getString("roomtype_name");
                cmb.addItem(mrd);
            }
            rs.close();

            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        jf.add(cmb);

        btn1 = new JButton("View");
        btn1.setBounds(280,330,110,35);
        btn1.setToolTipText("click to view all room details");
        btn1.addActionListener(this);
        jf.add(btn1);

        scrlPane.setBounds(120,400,900,340);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("Room_id");
        model.addColumn("Room_name");
        model.addColumn("Room_size");
        model.addColumn("Room_status");
        model.addColumn("Room_type");

        btn2 = new JButton("Delete");
        btn2.setBounds(450,330,110,35);
        btn2.setToolTipText("click to delete room details");
        btn2.addActionListener(this);
        jf.add(btn2);

        jf.setTitle("Room Management Page");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.white);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn1) {
            if (model.getRowCount() > 0) {
                for (int i = model.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }
            int r = 0;
            try {
                con = db.getConnection();
                System.out.println("Connected to database.");
                stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rst = stm.executeQuery("SELECT * from rooms");
                while (rst.next()) {
                    model.insertRow(r++, new Object[]{rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5)});
                }
                con.close();
            } catch (SQLException se) {
                System.out.println(se);
                JOptionPane.showMessageDialog(null, "SQL Error" + se);
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Error:" + e);
            }
        }
        else if(ae.getSource()==btn2) {
            try {
                con = db.getConnection();
                System.out.println("Connected to database.");
                stm=con.createStatement();
                String str1 = "delete from rooms where room_id="+txt1.getText()+" or room_name='"+txt2.getText()+"' ";
                stm.executeUpdate(str1);
                JOptionPane.showMessageDialog(null, "Record is deleted");
                txt1.setText("");
                txt2.setText("");
                txt3.setText("");
                txt4.setText("");
                cmb.setSelectedItem("select");
                con.close();
            } catch (SQLException se) {
                System.out.println(se);
                JOptionPane.showMessageDialog(null, "SQL Error:" + se);
            }
        }
    }


    public static void main(String args[])
    {
        new ManageRooms();
    }
}
