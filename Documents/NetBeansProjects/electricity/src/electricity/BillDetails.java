package electricity;
import java.awt.Color;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class BillDetails extends JFrame{
BillDetails(String meter){
    setSize(700,650);
    setLocation(300,50);
     getContentPane().setBackground(Color.white);
     JTable table = new JTable();
     try{
         conn c=new conn();
         String query = "select * from bills where meter_no='"+meter+"'";
         ResultSet rs =c.s.executeQuery(query);
         table.setModel(DbUtils.resultSetToTableModel(rs));
         
     }catch(Exception e){
         e.printStackTrace();
     }
     
     JScrollPane sp=new JScrollPane(table);
     sp.setBounds(0, 0, 700, 650);
    add(sp);
     
    setVisible(true);
}   
 public static void main(String[] args) {
             new BillDetails("");
}}
