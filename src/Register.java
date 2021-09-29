import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register implements ActionListener {
    JFrame fr;
    JLabel lbl_heading, lbl_Username,lbl_Email,lbl_password;
    JTextField txt_Username,txt_Email;
    JPasswordField txt_password;
    JButton btn_Register;
    Font f1,f2;
    public Register() {
        fr = new JFrame("USER REGISTRATION PAGE");
        f1 = new Font("arial", Font.BOLD, 22);
        f2 = new Font("arial", Font.BOLD, 18);
        lbl_heading = new JLabel("USER REGISTRATION ");
        lbl_heading.setFont(f1);
        lbl_heading.setForeground(Color.red);
        lbl_heading.setBounds(80, 10, 250, 40);
        fr.add(lbl_heading);

        // Username
        lbl_Username = new JLabel("USERNAME:");
        lbl_Username.setFont(f1);
        lbl_Username.setForeground(Color.BLACK);
        lbl_Username.setBounds(20,50,150,40);
        fr.add(lbl_Username);



        // Email
        lbl_Email = new JLabel("EMAIL:");
        lbl_Email.setFont(f1);
        lbl_Email.setForeground(Color.BLACK);
        lbl_Email.setBounds(20,110,110,40);
        fr.add(lbl_Email);

        // New password
        lbl_password=new JLabel("PASSWORD:");
        lbl_password.setForeground(Color.BLACK);
        lbl_password.setFont(f1);
        lbl_password.setBounds(20,140,150,40);
        fr.add(lbl_password);





        txt_Username=new JTextField();
        txt_Username.setFont(f2);
        txt_Username.setBounds(170,50,220,30);
        fr.add(txt_Username);



        txt_Email=new JTextField();
        txt_Email.setFont(f2);
        txt_Email.setBounds(170,110,220,30);
        fr.add(txt_Email);

        txt_password=new JPasswordField();
        txt_password.setFont(f2);
        txt_password.setBounds(170,140,220,30);
        fr.add(txt_password);




        btn_Register=new JButton("REGISTER");
        btn_Register.setFont(f2);
        btn_Register.setBounds(180,210,130,40);
        btn_Register.addActionListener(this);
        fr.add(btn_Register);



        fr.setSize(500, 500);
        fr.setLayout(null);
        fr.setVisible(true);
    }
    public static void main(String[]args){

        new Register();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Username = txt_Username.getText();

        String email = txt_Email.getText();
        String pass = txt_password.getText();

        if (e.getSource()==btn_Register) {
            JdbcConnection jc = new JdbcConnection();
            String query = "insert into  Register_table(Username, email,password) values ('" + Username + "', '" + email + "','" + pass + "')";
            int ans = jc.insert(query);
            if (ans > 0) ;
            JOptionPane.showMessageDialog(fr, "Account created successfully");
            fr.dispose();
        }
        else{
            JOptionPane.showMessageDialog(fr,"Something Wrong");


        }
    }




}

