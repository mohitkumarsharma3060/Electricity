package electricity;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class meterInfo extends JFrame implements ActionListener {

    JButton next;
    JLabel email,days,lblmeter2;
    Choice meterlocation,lblphasecode,billtype,lblmetertype2;
    String meternumber;
    meterInfo(String meternumber){
        this.meternumber = meternumber;
        setSize(700,500);
        setLocation(400,200);
        JPanel p= new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        JLabel heading=new JLabel("Meter Information");
        heading.setBounds(140,10,200,25);
        heading.setFont(new Font("Tahoma",Font.PLAIN,24));
        p.add(heading);

        JLabel lblmeter =new JLabel("Meter no.");
        lblmeter.setBounds(100,80,100,20);
        p.add(lblmeter);
         lblmeter2 = new JLabel(meternumber);
        lblmeter2.setBounds(240,80,100,20);
        p.add(lblmeter2);

        JLabel lbllocation =new JLabel("MeterLocation");
        lbllocation.setBounds(100,120,100,20);
        p.add(lbllocation);
       meterlocation =new Choice();
       meterlocation.add("Outside");
       meterlocation.add("Inside");
        meterlocation.setBounds(240,120,100,20);
        p.add(meterlocation);

        JLabel lblmetertype =new JLabel("Meter Type");
        lblmetertype.setBounds(100,160,100,20);
        p.add(lblmetertype);
        lblmetertype2 =new Choice();
        lblmetertype2.add("Electric Meter");
        lblmetertype2.add("Solar Meter");
        lblmetertype2.add("Smart Meter");
        lblmetertype2.setBounds(240,160,100,20);
        p.add(lblmetertype2);

        JLabel lblphase =new JLabel("Phase Code");
        lblphase.setBounds(100,200,100,20);
        p.add(lblphase);
        lblphasecode =new Choice();
        lblphasecode.add("011");
        lblphasecode.add("022");
        lblphasecode.add("033");
        lblphasecode.add("044");
        lblphasecode.add("055");
        lblphasecode.add("066");
        lblphasecode.add("077");
        lblphasecode.add("088");
        lblphasecode.add("099");
        lblphasecode.setBounds(240,200,100,20);
        p.add(lblphasecode);


        JLabel lblbilltype =new JLabel("Bill Type");
        lblbilltype.setBounds(100,240,100,20);
        p.add(lblbilltype);
       billtype=new Choice();
        billtype.add("Normal");
        billtype.add("Industrial bill");
        billtype.add("Smart Meter");
        billtype.setBounds(240,240,100,20);
        p.add(billtype);

        JLabel lbldays =new JLabel("Days");
        lbldays.setBounds(100,280,100,20);
        p.add(lbldays);
         days =new JLabel("30 Days");
        days.setBounds(240,280,100,20);
        p.add(days);

        JLabel lblemail =new JLabel("Note");
        lblemail.setBounds(100,320,100,20);
        p.add(lblemail);
         email =new JLabel("By Default bill is calculated for 30 days only");
        email.setBounds(240,320,500,20);
        p.add(email);


        next = new JButton("Submit");
        next.setBounds(170,400,100,25);
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);

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
            String meter = meternumber;
            String location=meterlocation.getSelectedItem();
            String type =lblmetertype2.getSelectedItem();
            String code=lblphasecode.getSelectedItem();
            String billtypes=billtype.getSelectedItem();
            String days="30";

            String query="insert into meter_info values('"+meter+"','"+location+"','"+type+"','"+code+"','"+billtypes+"','"+days+"')";

            try{
                conn c=new conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Meter information added successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {

        new meterInfo("");
    }
}

