import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Login implements ActionListener {
    JFrame fr;
    JLabel lbl_heading,lbl_username,lbl_password;
    JTextField txt_username;
    JPasswordField txt_password;
    JButton btn_login,btn_cancel,btn_reg;
    Font fon1,fon2;

    public Login(){
        fr=new JFrame("Login Page");
        fr.getContentPane().setBackground(Color.orange);

        // font
        fon1=new Font("arial",Font.BOLD,24);
        fon2=new Font("arial",Font.BOLD,18);

        //heading
        lbl_heading=new JLabel("Login Credentials");
        lbl_heading.setForeground(Color.red);
        lbl_heading.setFont(fon1);
        lbl_heading.setBounds(150,10,250,30);
        fr.add(lbl_heading);

        // label
        lbl_username=new JLabel("Username:");
        lbl_username.setForeground(Color.blue);
        lbl_username.setFont(fon2);
        lbl_username.setBounds(50,50,100,40);
        fr.add(lbl_username);

        // Textfield
        txt_username=new JTextField();
        txt_username.setFont(fon2);
        txt_username.setBounds(155,50,220,40);
        fr.add(txt_username);

        //label for password
        lbl_password=new JLabel("Password:");
        lbl_password.setForeground(Color.blue);
        lbl_password.setFont(fon2);
        lbl_password.setBounds(50,100,100,40);
        fr.add(lbl_password);

        // JPasswordfield
        txt_password=new JPasswordField();
        txt_password.setFont(fon2);
        txt_password.setBounds(155,100,220,40);
        fr.add(txt_password);

        //button
        btn_login=new JButton("Login");
        btn_login.setFont(fon2);
        btn_login.setBounds(150,150,90,40);
        btn_login.addActionListener(this);
        fr.add(btn_login);


        btn_cancel=new JButton("Cancel");
        btn_cancel.setFont(fon2);
        btn_cancel.setBounds(250,150,120,40);
        fr.add(btn_cancel);


        btn_reg=new JButton("Sign_up");
        btn_reg.setForeground(Color.red);
        btn_reg.setBounds(190,220,100,30);
        btn_reg.addActionListener(this);
        fr.add(btn_reg);
        fr.setSize(500,500);
        fr.setLayout(null);
        fr.setVisible(true);
    }
    public static void main(String[] args){

        new Login();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_reg){
            new Register();
        }
        if (e.getSource()==btn_login){
            String Username = txt_username.getText();
            String password = txt_password.getText();
            try {
                String query = "select * from register_table where Username = '"+Username+"'and password = '"+password+"'";
                JdbcConnection jc = new JdbcConnection();
                ResultSet rs = jc.select(query);
                if(rs.next()){
                    JOptionPane.showMessageDialog(fr,"login successful");


                    fr.dispose();
                     new GameFrame();
                }

                else{
                    JOptionPane.showMessageDialog(fr,"Invalid username and password");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}