package electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

public class calculatebill extends JFrame implements ActionListener {
    JTextField tfunits;
    JButton next,cancel;
    JLabel lblmetern ,tfname,tfaddress;
    Choice meterno,cmonth;
    calculatebill(){
        setSize(700,500);
        setLocation(400,200);
        JPanel p= new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        add(p);
        JLabel heading=new JLabel("Calculate  Electricity Bill");
        heading.setBounds(130,10,200,25);
        heading.setFont(new Font("Tahoma",Font.PLAIN,19));
        p.add(heading);
        JLabel lblname =new JLabel("Meter no");
        lblname.setBounds(100,80,100,20);
        p.add(lblname);
        meterno = new Choice();
        try{
            conn c =new conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while (rs.next()){
                meterno.add(rs.getString("meter_no"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        meterno.setBounds(240,80,200,20);
        p.add(meterno);
        JLabel lblmeter =new JLabel("Name");
        lblmeter.setBounds(100,120,100,20);
        p.add(lblmeter);
        lblmetern =new JLabel();
        lblmetern.setBounds(240,120,200,20);
        p.add(lblmetern);

        JLabel lbladdress =new JLabel("Customer Address");
        lbladdress.setBounds(100,160,100,20);
        p.add(lbladdress);
        tfaddress = new JLabel();
        tfaddress.setBounds(240,160,200,20);
        p.add(tfaddress);

        try{
            conn c =new conn();
            ResultSet rs=c.s.executeQuery("select * from customer where meter_no='"+meterno.getSelectedItem()+"'");
            while (rs.next()){
                lblmetern.setText(rs.getString("name"));
                tfaddress.setText(rs.getString("address"));
            }
        }catch (Exception ae){
            ae.printStackTrace();
        }

        meterno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    conn c =new conn();
                    ResultSet rs=c.s.executeQuery("select * from customer where meter_no='"+meterno.getSelectedItem()+"'");
                    while (rs.next()){
                        lblmetern.setText(rs.getString("name"));
                        tfaddress.setText(rs.getString("address"));
                    }
                }catch (Exception ae){
                    ae.printStackTrace();
                }


            }
        });

        JLabel lblunits =new JLabel("Units Consume");
        lblunits.setBounds(100,200,100,20);
        p.add(lblunits);
        tfunits = new JTextField();
        tfunits.setBounds(240,200,200,20);
        p.add(tfunits);

        JLabel lblcity =new JLabel("Month");
        lblcity.setBounds(100,240,100,20);
        p.add(lblcity);
        cmonth = new Choice();
        cmonth.setBounds(240,240,200,20);
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
        p.add(cmonth);
        next = new JButton("Submit");
        next.setBounds(150,330,100,25);
        next.setBackground(Color.black);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(280,330,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        setLayout(new BorderLayout());
        add(p,"Center");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/hicon2.jpg"));
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
            String meter_no= meterno.getSelectedItem();
            String units=tfunits.getText();
            String month =cmonth.getSelectedItem();

            int totalbill=0;

            String query="select * from tax";
            int unit_consumed = Integer.parseInt(units);

            try{
                conn c=new conn();
               ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                   totalbill += unit_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                   totalbill += Integer.parseInt(rs.getString("meter_rent"));
                    totalbill += Integer.parseInt(rs.getString("service_charge"));
                    totalbill += Integer.parseInt(rs.getString("service_tax"));
                    totalbill += Integer.parseInt(rs.getString("swach_bharat_cess"));
                    totalbill += Integer.parseInt(rs.getString("fix_tax"));

                }
            }catch (Exception e){
                e.printStackTrace();
            }


            String query1="insert into bills values('"+meter_no+"','"+month+"','"+units+"','"+totalbill+"','Not_Paid')";
            try{
                conn c =new conn();
                c.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null,"Customer Bill Updated Successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {

        new calculatebill();
    }
}
