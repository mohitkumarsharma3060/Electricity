package electricity;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class GenerateBill  extends JFrame implements ActionListener{
     Choice cmonth;
    JTextArea area;
     JButton bill;
     String meter;
GenerateBill(String meter){
    this.meter=meter;
    setSize(480,740);
    setLocation(550,0);
    setVisible(true);
    
    setLayout(new BorderLayout());
    
    JPanel panel=new JPanel();
    
    JLabel heading =new JLabel("Generate Bill");
    
    JLabel meternumber =new JLabel(meter);
    
     cmonth=new Choice();
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
    
     area =new JTextArea(50,50);
    area.setText("\n\n\t------------click on the---------------\n\t Generate Bill Button to get\n\t the bill of the selected month");
    area.setFont(new Font("Tahoma",Font.ITALIC,20));
    
    JScrollPane pane = new JScrollPane(area);
     
      bill=new JButton("Generate Bill");
    bill.addActionListener(this);
     panel.add(heading);
     panel.add(meternumber);
     panel.add(cmonth);
     add(panel,"North");
    add(pane,"Center");
    add(bill,"South"
    );
    setVisible(true);
}   
public void actionPerformed(ActionEvent ae){
    try{
        conn c =new conn();
        
        String month=cmonth.getSelectedItem();
        
        area.setText("\tRelaince Power Limited\nELECTRICITY BILL FOR THE MONTH OF\n\t "+month+",2022\n\n\n");
        
        ResultSet rs=c.s.executeQuery("select * from customer where meter_no='"+meter+"'");
        if(rs.next()){
            area.append("\n    Customer Name:"+rs.getString("name"));
            area.append("\n    Meter Number :"+rs.getString("meter_no"));
            area.append("\n    Address         :"+rs.getString("address"));
            area.append("\n    State            :"+rs.getString("state"));
            area.append("\n    City              :"+rs.getString("city"));
            area.append("\n    Email             :"+rs.getString("email"));
            area.append("\n    Phone no    :"+rs.getString("phone"));
            area.append("\n--------------------------------------------------------");
          
        }
            
         rs=c.s.executeQuery("select * from meter_info where meter_no='"+meter+"'");
        if(rs.next()){
            
            area.append("\n    Meter Location :"+rs.getString("meterlocation"));
            area.append("\n    Meter Number  :"+rs.getString("meter_no"));
            area.append("\n    Phase Code   :"+rs.getString("phase_code"));
            area.append("\n    Bill Type      :"+rs.getString("bill_type"));
            area.append("\n    Days         :"+rs.getString("days"));
             area.append("\n--------------------------------------------------------");
          
        }
           
         rs=c.s.executeQuery("select * from tax ");
        if(rs.next()){
           
            area.append("\n");
            area.append("\n    Cost Per Unit     :"+rs.getString("cost_per_unit"));
            area.append("\n    Meter Rent       :"+rs.getString("meter_rent"));
            area.append("\n    Service Charge     :"+rs.getString("service_charge"));
            area.append("\n    Service Tax       :"+rs.getString("service_tax"));
            area.append("\n    Swach Bharat Cess    :"+rs.getString("swach_bharat_cess"));
            area.append("\n    Fixed Tax           :"+rs.getString("fix_tax"));
        }
        rs=c.s.executeQuery("select * from bills where meter_no='"+meter+"'and month='"+month+"'");
        if(rs.next()){
           
            area.append("\n");
            area.append("\n    Month     :"+rs.getString("month"));
            area.append("\n    Units Consumed       :"+rs.getString("units"));
            area.append("\n    Total Charge     :"+rs.getString("totalbill"));
            area.append("\n--------------------------------------------------------");
            area.append("\n    Total Payable     :"+rs.getString("totalbill"));
            area.append("\n");
        }
    }catch(Exception e){
        e.printStackTrace();
    }
}
public static void main(String[] args) {

        new GenerateBill("");
    }

}
