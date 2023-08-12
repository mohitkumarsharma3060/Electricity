package electricity;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class CustomerDetails extends JFrame implements ActionListener{
    Choice meternumber,cmonth;
    JTable table;
    JButton search,print;
CustomerDetails(){
    super("Customer Details");
    setSize(1200,600);
    setLocation(150,120);
    
    table =new JTable();
    try{
        conn c =new conn();
        ResultSet rs=c.s.executeQuery("select * from customer");
        table.setModel(DbUtils.resultSetToTableModel(rs));


    }catch (Exception e){
        e.printStackTrace();
    }

    JScrollPane sp=new JScrollPane(table);
    add(sp);
    
    print =new JButton("Print");
    print.addActionListener(this);
    add(print,"South");
   
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
        new CustomerDetails();
    }

}
