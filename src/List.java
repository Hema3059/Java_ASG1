import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class List extends JFrame
{
    JFrame jf = new JFrame();
    JLabel lbl1;
    DBS db = null;
    DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
    public  List()
    {

        jf.setLayout(null);
        db = new DBS();

        lbl1 = new JLabel("List Of Available Rooms");
        lbl1.setFont(new Font("Times New Roman",Font.BOLD,25));
        lbl1.setForeground(Color.black);
        lbl1.setBounds(300,30,350,25);
        jf.add(lbl1);

        scrlPane.setBounds(80,80,900,400);
        jf.add(scrlPane);
        tabGrid.setFont(new Font ("Times New Roman",0,15));

        model.addColumn("S_ID");
        model.addColumn("Room");
        model.addColumn("Date");
        model.addColumn("Type");
        model.addColumn("Status");

        jf.setTitle("List of Available Room");
        jf.setLocation(20,20);
        jf.setResizable(false);
        jf.getContentPane().setBackground(Color.white);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jf.setBounds(0,0,screenSize.width, screenSize.height-50);
        jf.setVisible(true);
    }
    public static void main(String args[])
    {
        new List();
    }
}