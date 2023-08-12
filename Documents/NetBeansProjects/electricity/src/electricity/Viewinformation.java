package electricity;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class Viewinformation extends JFrame implements ActionListener{
    String meter;
Viewinformation(String meter){
    this.meter=meter;
    JButton cancel;
    setBounds(150,100,850,600);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    JLabel heading=new JLabel("View Customer Information");
    heading.setBounds(250,0,500,40);
    heading.setFont(new Font("Tahoma",Font.PLAIN,20));
     add(heading);
         
     JLabel lblname=new JLabel("Name");
    lblname.setBounds(70,80,100,20);
     add(lblname);
     
       JLabel name=new JLabel("");
    name.setBounds(250,80,100,20);
     add(name);
     
     JLabel lblmeternumber=new JLabel("Meter Number");
    lblmeternumber.setBounds(70,140,100,20);
     add(lblmeternumber);
     
       JLabel meternumber=new JLabel("");
    meternumber.setBounds(250,140,100,20);
     add(meternumber);
     
     JLabel lbladdress =new JLabel("Customer Address");
        lbladdress.setBounds(70,200,200,20);
        add(lbladdress);
         JLabel address =new JLabel("");
        address.setBounds(250,200,100,20);
        add(address);
        
        JLabel lblcity =new JLabel("City");
        lblcity.setBounds(70,260,200,20);
        add(lblcity);
         JLabel city =new JLabel("");
        city.setBounds(250,260,100,20);
        add(city);
        
         JLabel lblstate =new JLabel("State");
        lblstate.setBounds(450,80,200,20);
        add(lblstate);
         JLabel state =new JLabel("");
        state.setBounds(600,80,100,20);
        add(state);
        
        JLabel lblemail =new JLabel("Email");
        lblemail.setBounds(450,140,200,20);
        add(lblemail);
         JLabel email =new JLabel("");
        email.setBounds(600,140,100,20);
        add(email);
        
        JLabel lblphone =new JLabel("Mobile no");
        lblphone.setBounds(450,200,200,20);
        add(lblphone);
         JLabel phone =new JLabel("");
        phone.setBounds(600,200,100,20);
        add(phone);
        
        try{
            conn c=new conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no='"+meter+"'");
            while(rs.next()){
                name.setText(rs.getString("name"));
                address.setText(rs.getString("address"));
                city.setText(rs.getString("city"));
                state.setText(rs.getString("state"));
                email.setText(rs.getString("email"));
                phone.setText(rs.getString("phone"));
                meternumber.setText(rs.getString("meter_no"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
         cancel=new JButton("Cancel");
        cancel.setBounds(320,300,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);
        cancel.addActionListener(this);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/viewcustomer.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(20,310,600,300);
       add(image);
        
    setVisible(true);
}   
public void actionPerformed(ActionEvent ae){
    setVisible(false);
}
 public static void main(String[] args) {

        new Viewinformation("");
    }
}
