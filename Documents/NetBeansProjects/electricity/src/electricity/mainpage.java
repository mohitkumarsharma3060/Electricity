package electricity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class mainpage extends JFrame implements ActionListener {
    String atype,meter;
    mainpage(String atype,String meter) {
        this.atype=atype;
        this.meter=meter;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/elect1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        JMenuBar mb = new JMenuBar();

        setJMenuBar(mb);
        JMenu master = new JMenu("Master");
        master.setForeground(Color.blue);
       
        JMenuItem newcustomer = new JMenuItem("New Customer");
        newcustomer.setFont(new Font("monospace", Font.PLAIN, 12));
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("images/icon1.png"));
        Image i5 = i4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(i5));
        newcustomer.setMnemonic('N');
        newcustomer.addActionListener(this);
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        master.add(newcustomer);
        JMenuItem depositdetails = new JMenuItem("Deposit Details");
        depositdetails .setFont(new Font("monospace", Font.PLAIN, 12));
        ImageIcon i6= new ImageIcon(ClassLoader.getSystemResource("images/icon2.png"));
        Image i7 = i6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositdetails .setIcon(new ImageIcon(i7));
        depositdetails .setMnemonic('E');
        depositdetails.addActionListener(this);
        depositdetails .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        master.add(depositdetails);
        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospace", Font.PLAIN, 12));
        ImageIcon i8= new ImageIcon(ClassLoader.getSystemResource("images/icon3.png"));
        Image i9 = i8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(i9));
        customerdetails .setMnemonic('C');
        customerdetails.addActionListener(this);
        customerdetails .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        master.add(customerdetails);
        JMenuItem calculatebill = new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospace", Font.PLAIN, 12));
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("images/icon5.png"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(image3));
        calculatebill.setMnemonic('O');
        calculatebill.addActionListener(this);
        calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        master.add(calculatebill);

        JMenu info = new JMenu("Information");
        info.setForeground(Color.red);
      
        JMenuItem update = new JMenuItem("Update Information");
        update.setFont(new Font("monospace", Font.PLAIN, 12));
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("images/icon6.png"));
        Image image5 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        update.setIcon(new ImageIcon(image5));
        update.setMnemonic('U');
        update.addActionListener(this);
        update.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        info.add(update);
        JMenuItem view = new JMenuItem("View Information");
        view.setFont(new Font("monospace", Font.PLAIN, 12));
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("images/icon6.png"));
        Image image7 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        view.setIcon(new ImageIcon(image7));
        view.setMnemonic('V');
         view.addActionListener(this);
        view.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        info.add(view);

        JMenu user = new JMenu("User");
        user.setForeground(Color.blue);
       
        JMenuItem paybill= new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospace", Font.PLAIN, 12));
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("images/icon4.png"));
        Image image8 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(image8));
        paybill.setMnemonic('P');
        paybill.addActionListener(this);
        paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        user.add(paybill);
        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospace", Font.PLAIN, 12));
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("images/icon6.png"));
        Image image9 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(image9));
        billdetails.setMnemonic('B');
        billdetails.addActionListener(this);
        billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        user.add(billdetails);

        JMenu report = new JMenu("Report");
        report.setForeground(Color.red);
        
        JMenuItem generatebill= new JMenuItem("Generate Bill");
        generatebill.setFont(new Font("monospace", Font.PLAIN, 12));
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("images/icon4.png"));
        Image image10 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        generatebill.setIcon(new ImageIcon(image10));
        generatebill.setMnemonic('G');
        generatebill.addActionListener(this);
        generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        report.add(generatebill);

        JMenu utility = new JMenu(" utility");
        utility.setForeground(Color.blue);
       
        JMenuItem notepad= new JMenuItem("Notepad");
        notepad.setFont(new Font("monospace", Font.PLAIN, 12));
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("images/icon12.png"));
        Image image11 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image11));
        notepad.setMnemonic('M');
        notepad.addActionListener(this);
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        utility.add(notepad);
        

        JMenu mexit = new JMenu("Exit");
        mexit.setForeground(Color.red);
        
        JMenuItem exit= new JMenuItem("Exit");
        exit.setFont(new Font("monospace", Font.PLAIN, 12));
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("images/icon11.png"));
        Image image13 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        exit.setIcon(new ImageIcon(image13));
        exit.setMnemonic('E');
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        mexit.add(exit);
         if(atype.equals("Admin")){
         mb.add(master);
         }else{
         mb.add(info);
         mb.add(user);
         mb.add(report);
        }
         mb.add(utility);
         mb.add(mexit); 
        setLayout(new FlowLayout());
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String msg=ae.getActionCommand();
        if(msg.equals("New Customer")){
            new new_customer();
        } else if (msg.equals("Deposit Details")) {
           new DepositDetails();
        } else if (msg.equals("Calculate Bill")) {
            new calculatebill();
        }else if (msg.equals("Customer Details")) {
           new CustomerDetails();
        }else if(msg.equals("View Information")) {
           new Viewinformation(meter);
        }else if(msg.equals("Update Information")) {
           new Updateinformation(meter);
        }else if(msg.equals("Bill Details")) {
           new BillDetails(meter);
        }else if(msg.equals("Notepad")) {
           try{
               Runtime.getRuntime().exec("notepad.exe");
           }catch(Exception e){
                   e.printStackTrace();
                   }
           
        } else if(msg.equals("Exit")) {
           setVisible(false);
           }else if(msg.equals("Pay Bill")) {
            new PayBill(meter);
           }else if(msg.equals("Generate Bill")) {
            new GenerateBill(meter);
    
    }
    }
    
        public static void main(String[] args) {
             new mainpage("","");
    
}}
