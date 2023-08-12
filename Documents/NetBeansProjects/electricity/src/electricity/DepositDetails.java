package electricity;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class DepositDetails extends JFrame implements ActionListener{
    Choice meternumber,cmonth;
    JTable table;
    JButton search,print;
DepositDetails(){
    super("Deposit Details");
    setSize(800,600);
    setLocation(300,100);
    setLayout(null);
    getContentPane().setBackground(Color.white);
    JLabel lblmeternumber=new JLabel("Search By Meter Number");
    lblmeternumber.setBounds(20,20,180,20);
    add(lblmeternumber);
    meternumber=new Choice();
    meternumber.setBounds(200,20,150,20);
    add(meternumber);
    try{
        conn c = new conn();
        ResultSet rs =c.s.executeQuery("select * from customer");
        while (rs.next()){
            meternumber.add(rs.getString("meter_no"));
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    JLabel lblmonth=new JLabel("Search By Month");
    lblmonth.setBounds(400,20,100,20);
    add(lblmonth);
    cmonth=new Choice();
    cmonth.setBounds(520,20,150,20);
    cmonth.add("January");
    cmonth.add("February");
    cmonth.add("March");
    cmonth.add("April");
    cmonth.add("May");
    cmonth.add("June");
    cmonth.add("July");
    cmonth.add("August");
    cmonth.add("September");
    cmonth.add("October");
    cmonth.add("November");
    cmonth.add("December");
    add(cmonth);

    table =new JTable();
    try{
        conn c =new conn();
        ResultSet rs=c.s.executeQuery("select * from bills");
        table.setModel(DbUtils.resultSetToTableModel(rs));


    }catch (Exception e){
        e.printStackTrace();
    }

    JScrollPane sp=new JScrollPane(table);
    sp.setBounds(0,100,800,600);
    add(sp);
    search =new JButton("Search");
    search.setBounds(120,70,80,20);
    search.addActionListener(this);
    add(search);
    
    print =new JButton("Print");
    print.setBounds(20,70,80,20);
    print.addActionListener(this);

    add(print);
   
    setVisible(true);
}
@Override
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==search){
        String query = "select * from bills where meter_no = '"+meternumber.getSelectedItem()+"' and month = '"+cmonth+"'";
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery(query);
        table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
    }else{
        try{
            table.print();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    }
    public static void main(String[] args) {
        new DepositDetails();
    }

}
