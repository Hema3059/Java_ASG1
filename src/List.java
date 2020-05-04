import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class List extends JFrame implements ActionListener {
    JFrame jf = new JFrame();
    JLabel lbl1;
    DBS db = null;
    Connection con;
    Statement stm;
    ResultSet rst;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    JButton btnBack;

    public List() {

        jf.setLayout(null);
        db = new DBS();

        lbl1 = new JLabel("List Of Available Rooms");
        lbl1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lbl1.setForeground(Color.black);
        lbl1.setBounds(300, 30, 350, 25);
        jf.add(lbl1);

        scrlPane.setBounds(80, 80, 900, 400);
        jf.add(scrlPane);
        tabGrid.setFont(new Font("Times New Roman", 0, 15));

        model.addColumn("S_ID");
        model.addColumn("Room");
        model.addColumn("Start Date");
        model.addColumn("End Date");
        model.addColumn("Type");
        model.addColumn("Status");

        //btnBack = new JButton("Back");
        //btnBack.setBounds(350, 510, 160, 35);
        //btnBack.addActionListener(this);
        //jf.add(btnBack);

        int r = 0;
        try {
            con = db.getConnection();
            System.out.println("Connected to database.");
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rst = stm.executeQuery("SELECT `s_id`, `room`, `s_date`, `e_date`, `d_type` , `status`  FROM `room_scheduling`");
            while (rst.next()) {
                model.insertRow(r++, new Object[]{rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6)});
            }
            con.close();
        } catch (SQLException se) {
            System.out.println(se);
            JOptionPane.showMessageDialog(null, "SQL Error:" + se);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error:" + e);
        }

        jf.setTitle("List of Available Room");
        jf.setLocation(20, 20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.lightGray);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
        jf.setBounds(90, 90, 1100, 600);


    }

    public static void main(String args[]) {
        new List();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            new Menu();
            jf.dispose();
        }
    }
}