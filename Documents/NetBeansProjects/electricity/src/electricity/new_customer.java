package electricity;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class new_customer extends JFrame implements ActionListener {
    JTextField tfname,tfaddress,tfstate,tfcity,tfemail,tfphone;
    JButton next,cancel;
    JLabel lblmetern;
    new_customer(){
        setSize(700,500);
        setLocation(400,200);
        JPanel p= new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        JLabel heading=new JLabel("New Customer");
        heading.setBounds(180,10,200,25);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);
        JLabel lblname =new JLabel("Customer Name");
        lblname.setBounds(100,80,100,20);
        p.add(lblname);
        tfname = new JTextField();
        tfname.setBounds(240,80,200,20);
        p.add(tfname);
        JLabel lblmeter =new JLabel("Meter Number");
        lblmeter.setBounds(100,120,100,20);
        p.add(lblmeter);
         lblmetern =new JLabel("");
        lblmetern.setBounds(240,120,200,20);
        p.add(lblmetern);
       Random ran=new Random();
       long number =ran.nextLong() %1000000;
       lblmetern.setText("" + Math.abs(number));

        JLabel lbladdress =new JLabel("Customer Address");
        lbladdress.setBounds(100,160,100,20);
        p.add(lbladdress);
        tfaddress = new JTextField();
        tfaddress.setBounds(240,160,200,20);
        p.add(tfaddress);

        JLabel lblstate =new JLabel("State");
        lblstate.setBounds(100,200,100,20);
        p.add(lblstate);
        tfstate = new JTextField();
        tfstate.setBounds(240,200,200,20);
        p.add(tfstate);

        JLabel lblcity =new JLabel("City");
        lblcity.setBounds(100,240,100,20);
        p.add(lblcity);
        tfcity = new JTextField();
        tfcity.setBounds(240,240,200,20);
        p.add(tfcity);

        JLabel lblemail =new JLabel("Email");
        lblemail.setBounds(100,280,100,20);
        p.add(lblemail);
        tfemail = new JTextField();
        tfemail.setBounds(240,280,200,20);
        p.add(tfemail);

        JLabel lblphone =new JLabel("Mobile Number");
        lblphone.setBounds(100,320,100,20);
        p.add(lblphone);
        tfphone = new JTextField();
        tfphone.setBounds(240,320,200,20);
        p.add(tfphone);

        next = new JButton("Next");
        next.setBounds(120,390,100,25);
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(250,390,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        setLayout(new BorderLayout());
        add(p,"Center");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/hicon1.jpg"));
        Image i2=i1.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        add(image,"West");
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
         String name=tfname.getText();
            String meter=lblmetern.getText();
            String address =tfaddress.getText();
            String state=tfstate.getText();
            String city=tfcity.getText();
            String email=tfemail.getText();
            String phone=tfphone.getText();

            String query1="insert into customer values('"+name+"','"+meter+"','"+address+"','"+state+"','"+city+"','"+email+"','"+phone+"')";
            String query2="insert into logincus values('"+meter+"','','"+name+"','','')";

            try{
                conn c=new conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"customer details added successfully");
                setVisible(false);
               // new  meterInfo(meter);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {

        new new_customer();
    }
}
