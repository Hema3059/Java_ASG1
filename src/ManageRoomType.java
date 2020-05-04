import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ManageRoomType extends JFrame implements ActionListener
{
    JFrame jf;
    JLabel lbl1,lbl2,lbl3;
    JTextField txt1,txt2;
    JButton btn1,btn2;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    Connection con;
    DBS db =null;
    PreparedStatement pst;
    ResultSet rst;
    Statement stmt;
    ManageRoomType()
    {
        jf = new JFrame();
        jf.setLayout(null);
        db = new DBS();

        lbl3=new JLabel("Manage Room Type ");
        lbl3.setFont(new Font("Times New Roman",Font.BOLD,25));
        lbl3.setBounds(340,50,300,40);
        lbl3.setForeground(Color.black);
        jf.add(lbl3);


        lbl1= new JLabel("Room Type id *");
        lbl1.setBounds(240,120,130,25);
        jf.add(lbl1);

        txt1=new JTextField(20);
        txt1.setBounds(400,120,200,25);
        txt1.setToolTipText("Enter Room Type id");
        jf.add(txt1);

        lbl2 = new JLabel("Room Type Name*");
        lbl2.setBounds(240,160,170,25);
        jf.add(lbl2);

        txt2 = new JTextField(20);
        txt2.setBounds(400,160,200,25);
        txt2.setToolTipText("Enter Room Type Name");
        jf.add(txt2);

        btn1 = new JButton("View");
        btn1.setBounds(330,230,110,35);
        jf.add(btn1);
        btn1.addActionListener(this);

        btn2 = new JButton("Delete");
        btn2.setBounds(500,230,110,35);
        jf.add(btn2);
        btn2.addActionListener(this);

        scrlPane.setBounds(150,380,600,300);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("RoomType_ID");
        model.addColumn("RoomType_NAME");

        jf.setTitle("Room type management page");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.lightGray);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
        jf.setBounds(50,100, 1000, 1200);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn1) {


            if (model.getRowCount() > 0) {
                for (int i = model.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }
            int r = 0;
            try {
                con = db.getConnection();
                System.out.println("Connected to database.");
                stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rst = stmt.executeQuery("SELECT * from room_type");
                while (rst.next()) {
                    model.insertRow(r++, new Object[]{rst.getString(1), rst.getString(2)});
                }
                con.close();
            } catch (SQLException se) {
                System.out.println(se);
                JOptionPane.showMessageDialog(null, "SQL Error" + se);
            }
        }
        else if  (e.getSource()==btn2)
        {
            try {
                con = db.getConnection();
                System.out.println("Connected to database.");
                pst = con.prepareStatement("delete from room_type where roomtype_id='" + txt1.getText() + "' or roomtype_name='" + txt2.getText() + "'");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record is deleted.");
                txt1.setText("");
                txt2.setText("");
                con.close();
            } catch (SQLException se) {
                System.out.println(se);
                JOptionPane.showMessageDialog(null, "SQL Error:" + se);
            }
        }
    }
    public static void main(String args[])
    {
        new ManageRoomType ();
    }
}
