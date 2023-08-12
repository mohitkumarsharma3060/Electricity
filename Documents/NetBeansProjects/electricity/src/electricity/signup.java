package electricity;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;


public class signup extends JFrame implements ActionListener {
    JButton create,back;
    Choice accountType;
    JTextField meter,username1,name1,pwd1;

    signup(){
        setBounds(450,150,700,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel panel=new JLabel();
        panel.setBounds(30,30,650,300);
        panel.setBorder(new TitledBorder(new LineBorder( new Color(173,40,90),2),"Create-Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(172,216,230)));
        panel.setBackground(Color.WHITE);
        panel.setForeground(new Color(34,139,34));
        add(panel);
        JLabel heading=new JLabel("Create-Account As");
        heading.setBounds(100,50,140,20);
        heading.setForeground(Color.gray);
        heading.setFont(new Font("aerial",Font.BOLD,14));
        panel.add(heading);
        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260,50,150,20);
        panel.add(accountType);
        
       
        
        JLabel meterno=new JLabel("Meter Number");
        meterno.setBounds(100,90,140,20);
        meterno.setForeground(Color.gray);
        meterno.setFont(new Font("aerial",Font.BOLD,14));
        meterno.setVisible(false);
        panel.add(meterno);
        meter=new JTextField();
        meter.setBounds(260,90,150,20);
        meter.setVisible(false);
        panel.add(meter);
        
        JLabel username=new JLabel("Enter Username");
        username.setBounds(100,130,140,20);
        username.setForeground(Color.gray);
        username.setFont(new Font("aerial",Font.BOLD,14));
        panel.add(username);
        username1=new JTextField();
        username1.setBounds(260,130,150,20);
        panel.add(username1);
        JLabel name=new JLabel("Enter Name");
        name.setBounds(100,170,140,20);
        name.setForeground(Color.gray);
        name.setFont(new Font("aerial",Font.BOLD,14));
        panel.add(name);
        name1=new JTextField();
        name1.setBounds(260,170,150,20);
        panel.add(name1);
       
        meter.addFocusListener(new FocusListener(){
           
            public void focusGained(FocusEvent fe){}
           
            public void focusLost(FocusEvent fe){
            try{
                conn c=new conn();
                ResultSet rs = c.s.executeQuery("select * from logincus where smeter = '"+meter.getText()+"'");
                while(rs.next()){
                    name1.setText(rs.getString("sname"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            }
        });
        
        JLabel pwd=new JLabel("Enter Password");
        pwd.setBounds(100,210,140,20);
        pwd.setForeground(Color.gray);
        pwd.setFont(new Font("aerial",Font.BOLD,14));
        panel.add(pwd);
        pwd1=new JTextField();
        pwd1.setBounds(260,210,150,20);
        panel.add(pwd1);
        
        accountType.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ae){
            String user = accountType.getSelectedItem();
            if(user.equals("Customer")){
                meterno.setVisible(true);
                meter.setVisible(true);
            }else{
                meterno.setVisible(false);
                meter.setVisible(false);
                name1.setEditable(true);
            }
        }
        });
        create=new JButton("Create");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setBounds(140,260,120,25);
        create.addActionListener(this);
        panel.add(create);
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300,260,120,25);
        back.addActionListener(this);
        panel.add(back);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/signupImage.png"));
        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(415,20,250,250);
        panel.add(image);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==create){
            String atype = accountType.getSelectedItem();
            String susername = username1.getText();
            String sname = name1.getText();
            String spassword = pwd1.getText();
            String smeter=meter.getText();
            try{
                conn c=new conn();
                String query=null;
                if (atype.equals("Admin")){
                    query="insert into login1 values(  '"+susername+"' ,'"+spassword+"' ,'"+atype+"','"+sname+"')";
                     
                }else{
                   query ="update logincus set susername='"+ susername+"',spassword='"+spassword+"',atype ='"+atype+"' where smeter='"+smeter+"'";    
                       }
                  c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Account Created Successfully");
                setVisible(false);
                new login();
            }catch(Exception ae){

                ae.printStackTrace();        }
        } else if (e.getSource()==back) {
            setVisible(false);
            new login();

        }
    }


    public static void main(String[] args) {
        new signup();
}
}
