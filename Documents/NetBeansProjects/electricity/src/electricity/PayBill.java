package electricity;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class PayBill extends JFrame implements ActionListener{
    Choice cmonth;
    JButton pay,back;
    String meter;
PayBill(String meter){
    this.meter=meter;
    setLayout(null);
    setBounds(300,50,900,600);
    
    JLabel heading=new JLabel("Electricity Bill");
    heading.setBounds(120,5,400,30);
    heading.setFont(new Font("Tahoma",Font.PLAIN,24));
    add(heading);
    
    JLabel lblmeternumber=new JLabel("Meter Number");
    lblmeternumber.setBounds(35,80,200,20);
    add(lblmeternumber);
    
    JLabel meternumber=new JLabel("");
    meternumber.setBounds(300,80,200,20);
    add(meternumber);

    JLabel lblname=new JLabel("Name");
    lblname.setBounds(35,140,200,20);
    add(lblname);
    
    JLabel name=new JLabel("");
    name.setBounds(300,140,200,20);
    add(name);
    
    JLabel lblmonth=new JLabel("Month");
    lblmonth.setBounds(35,200,200,20);
    add(lblmonth);
    
    cmonth = new Choice();
    cmonth.setBounds(300,200,200,20);
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

 JLabel lblunits=new JLabel("Units");
    lblunits.setBounds(35,260,200,20);
    add(lblunits);
    
    JLabel units=new JLabel("");
    units.setBounds(300,260,200,20);
    add(units);

    JLabel lbltotal=new JLabel("Total");
    lbltotal.setBounds(35,320,200,20);
    add(lbltotal);
    
    JLabel total=new JLabel("");
    total.setBounds(300,320,200,20);
    add(total);

    JLabel lblstatus=new JLabel("Status");
    lblstatus.setBounds(35,380,200,20);
    add(lblstatus);
    
    JLabel status=new JLabel("");
    status.setBounds(300,380,200,20);
    status.setForeground(Color.red);
    add(status);
    
    try{
        conn c=new conn();
        ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+meter+"'");
        while(rs.next()){
            meternumber.setText(meter);
            name.setText(rs.getString("name"));
        }
        rs= c.s.executeQuery("select * from bills where meter_no = '"+meter+"'and month = '"+cmonth.getSelectedItem()+"'");
        while(rs.next()){
            units.setText(rs.getString("units"));
            total.setText(rs.getString("totalbill"));
            status.setText(rs.getString("status"));
        }
        
    }catch(Exception e){
        e.printStackTrace();
    }
    cmonth.addItemListener(new ItemListener(){
        @Override
        public void itemStateChanged(ItemEvent ae){
     try{
        conn c=new conn();
        ResultSet rs = c.s.executeQuery("select * from bills where meter_no = '"+meter+"'and month = '"+cmonth.getSelectedItem()+"'");
        
        while(rs.next()){
            units.setText(rs.getString("units"));
            total.setText(rs.getString("totalbill"));
            status.setText(rs.getString("status"));
        }
        
    }catch(Exception e){
        e.printStackTrace();
    }       
        }
    });
    
    pay=new JButton("Pay");
    pay.setBackground(Color.BLACK);
    pay.setForeground(Color.WHITE);
    pay.setBounds(100,460,100,25);
    pay.addActionListener(this);
    add(pay);
    
    back=new JButton("Back");
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.setBounds(230,460,100,25);
    back.addActionListener(this);
    add(back);
    
    getContentPane().setBackground(Color.WHITE);
    
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/bill.png"));
        Image i2=i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(400,120,600,300);
       add(image);
    
    
    
   setVisible(true);
 
}    

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==pay){
        try{
            conn c = new conn();
            c.s.executeUpdate("update bills set status='Paid' where meter_no='"+meter+"' and month ='"+cmonth.getSelectedItem()+"'");
        }catch(Exception e){
            e.printStackTrace();
        }            
        }else{
            setVisible(false);
        }
    }
    
public static void main(String[] args) {

        new PayBill("");}
}