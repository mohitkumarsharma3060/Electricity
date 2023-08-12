package electricity;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
public class Updateinformation extends JFrame implements ActionListener{
JLabel name;
JTextField tfstate,tfaddress,tfcity,tfphone,tfemail;
 JButton cancel,update;
 String meter;
    Updateinformation(String meter){
    this.meter=meter;
    
    setBounds(230,120,1050,450);
    getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     
     JLabel heading=new JLabel("Update Customer Information");
    heading.setBounds(300,0,400,30);
    heading.setFont(new Font("Tahoma",Font.PLAIN,20));
     add(heading);
         
     JLabel lblname=new JLabel("Name");
    lblname.setBounds(30,70,100,20);
     add(lblname);
     
     name=new JLabel("");
    name.setBounds(230,70,200,70);
    add(name);
     
    JLabel lblmeternumber=new JLabel("Meter Number");
    lblmeternumber.setBounds(30,110,100,20);
    add(lblmeternumber);
     
    JLabel meternumber=new JLabel("");
    meternumber.setBounds(230,110,200,20);
    add(meternumber);
     
    JLabel lbladdress =new JLabel("Customer Address");
    lbladdress.setBounds(30,150,100,20);
    add(lbladdress);
    tfaddress =new JTextField();
    tfaddress.setBounds(230,150,200,20);
    add(tfaddress);
        
    JLabel lblcity =new JLabel("City");
    lblcity.setBounds(30,190,100,20);
    add(lblcity);
    tfcity =new JTextField();
    tfcity.setBounds(230,190,200,20);
    add(tfcity);
        
    JLabel lblstate =new JLabel("State");
    lblstate.setBounds(30,230,100,20);
    add(lblstate);
    tfstate =new JTextField("");
        tfstate.setBounds(230,230,200,20);
        add(tfstate);
        
        JLabel lblemail =new JLabel("Email");
        lblemail.setBounds(30,270,100,20);
        add(lblemail);
         tfemail =new JTextField();
        tfemail.setBounds(230,270,200,20);
        add(tfemail);
        
        JLabel lblphone =new JLabel("Mobile no");
        lblphone.setBounds(30,310,100,20);
        add(lblphone);
        tfphone =new JTextField();
        tfphone.setBounds(230,310,200,20);
        add(tfphone);
        
        update=new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(70,360,100,25);
       update.addActionListener(this);
        add(update);
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(230,360,100,25);
        update.addActionListener(this);
        add(cancel);
       
        try{
            conn c=new conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no='"+meter+"'");
            while(rs.next()){
                name.setText(rs.getString("name"));
                tfaddress.setText(rs.getString("address"));
                tfcity.setText(rs.getString("city"));
                tfstate.setText(rs.getString("state"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("phone"));
                meternumber.setText(rs.getString("meter_no"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/update.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(550,50,400,300);
       add(image);
        
    setVisible(true);
}   
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==update){
        String address  = tfaddress.getText();
        String city  = tfcity.getText();
        String state  = tfstate.getText();
        String email  = tfemail.getText();
        String phone  = tfphone.getText();
        
        try{
            conn c=new conn();
            c.s.executeUpdate("update customer set address = '"+address+"',city = '"+city+"',state = '"+state+"',email = '"+email+"',phone = '"+phone+"' where meter_no='"+meter+"'");
           JOptionPane.showMessageDialog(null,"User Information Updated Successfully");
           setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }else{
        setVisible(false);
    }
}   
  public static void main(String[] args) {

        new Updateinformation("");
    }
}

