package electricity;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class login extends JFrame implements ActionListener {
JTextField username,pwd;JButton log,cancel,signup;
Choice login;private String meter;login(){
      super("login page");setLayout(null);
      getContentPane().setBackground(Color.white);
      JLabel lblusername=new JLabel("Username");
      setLayout(null);
      lblusername.setBounds(280,20,100,20);
      add(lblusername);
      username= new JTextField();
      username.setBounds(380,20,150,20);
      add(username);JLabel lblpassword=new JLabel("Enter Password ");
      lblpassword.setBounds(280,60,100,20);add(lblpassword);
      pwd= new JTextField();pwd.setBounds(380,60,150,20);add(pwd);
        JLabel lbllogin=new JLabel("Login in as:");
        lbllogin.setBounds(280,100,100,20);
        add(lbllogin);login =new Choice();login.add("Admin");
        login.add("Customer");login.setBounds(380,100,150,20);
        add(login);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/login.png"));
        Image i2=i1.getImage().getScaledInstance(14,14,Image.SCALE_DEFAULT);
        log=new JButton("Login",new ImageIcon(i2));
        log.setBounds(310,160,100,20);add(log);
        log.addActionListener(this);
        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("images/cancel.jpg"));
        Image i4=i3.getImage().getScaledInstance(14,14,Image.SCALE_DEFAULT);
        cancel=new JButton("Cancel",new ImageIcon(i4));
        cancel.setBounds(430,160,100,20);add(cancel);
        cancel.addActionListener(this);
        ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("images/signup.png"));
        Image i6=i5.getImage().getScaledInstance(18,18,Image.SCALE_DEFAULT);
        signup=new JButton("Signup",new ImageIcon(i6));
        signup.setBounds(370,200,100,20);add(signup);
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("images/second.jpg"));
        Image i8=i7.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel image=new JLabel(i9);
        image.setBounds(0,0,250,250); add(image);
        signup.addActionListener(this);
        setSize(640,300);
        setLocation(400,200);setVisible(true);}
@Override public void actionPerformed(ActionEvent e) {
        if(e.getSource()==log){ String susername=username.getText();
        String spassword=pwd.getText();String atype=login.getSelectedItem();
        try{
            conn c=new conn();
            String query=null;
        if(atype.equals("Admin")){
        query="select * from login1 where susername='"+ susername+"' and spassword='"+spassword+"' and atype ='"+atype+"'";
        c.s.executeQuery(query); ResultSet rs=c.s.executeQuery(query);
        if(rs.next()){String name = rs.getString("sname");
         setVisible(false); new mainpage(atype,name);
     }else{ JOptionPane.showMessageDialog(null,"invalid login");      
    }}else{
            query ="select * from logincus where susername='"+ susername+"' and spassword='"+spassword+"' and atype ='"+atype+"'";
    c.s.executeQuery(query);ResultSet rs=c.s.executeQuery(query);
    if(rs.next())
    {String meter = rs.getString("smeter");
    setVisible(false);new mainpage(atype,meter);
   }else{JOptionPane.showMessageDialog(null,"invalid login");
    }}}catch (Exception we)
    {we.printStackTrace();}
        }else if(e.getSource()==cancel){setVisible(false);
        } else if (e.getSource()==signup) {setVisible(false);
//new signup();
        }
}
public static void main(String[] args) {
        new login();}}
