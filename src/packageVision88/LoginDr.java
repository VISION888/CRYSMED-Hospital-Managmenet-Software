package packageVision88;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginDr extends JFrame implements ActionListener {

    public LoginDr() {
        JLabel labelH = new JLabel();
        JLabel labelU = new JLabel();
        JLabel labelP = new JLabel();

        ImageIcon imageTitle = new ImageIcon("Resources/doctor_icon.png");
        ImageIcon imageLogin = new ImageIcon("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Hospital Manageme (Intellij)\\Resources\\login_icon.png");
        ImageIcon imageRegister = new ImageIcon("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Hospital Manageme (Intellij)\\Resources\\icon_register.png");
        ImageIcon imageClose = new ImageIcon("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Hospital Manageme (Intellij)\\Resources\\icon_close.png");

        JTextField textFieldUser = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JButton buttonLogin = new JButton("Login", imageLogin);
        JButton buttonRegister = new JButton("Register", imageRegister);
        JButton buttonClose = new JButton("Close", imageClose);

        labelH.setText("Doctor's Login");
        labelU.setText("Username: ");
        labelP.setText("Password: ");

        labelH.setFont(new Font("Comic Sans", Font.ITALIC, 44));
        labelU.setFont(new Font("Arial", Font.BOLD, 18));
        labelP.setFont(new Font("Arial", Font.BOLD, 18));

        labelH.setBounds(40,-40,600,200);
        labelU.setBounds(60,30,120,200);
        labelP.setBounds(60,70,120,200);

        labelH.setIconTextGap(40);
        labelH.setIcon(imageTitle);

        textFieldUser.setBounds(170,120,310,25);
        passwordField.setBounds(170,160,310,25);

        textFieldUser.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18));

        textFieldUser.setFocusable(true);

        buttonLogin.setFont(new Font("Arial", Font.BOLD, 14));
        buttonRegister.setFont(new Font("Arial", Font.BOLD, 14));
        buttonClose.setFont(new Font("Arial", Font.BOLD, 14));

        buttonLogin.setBounds(100,220,130,55);
        buttonRegister.setBounds(250,220,130,55);
        buttonClose.setBounds(400,220,130,55);


        buttonLogin.addActionListener(this);
        buttonRegister.addActionListener(this);
        buttonClose.addActionListener(this);


        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(new Color(145,184,219));


        // Set the default close behavior to exit the application
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setDefaultLookAndFeelDecorated(true);
        frame.setTitle("Hospital Management Program");
        frame.setIconImage(new ImageIcon("Resources/icon_hs.png").getImage());
        frame.setLayout(null);

        // Set the x, y, width and height properties in one go
        frame.setSize(600, 330);
        frame.setResizable(false);

        //Screen Position
        frame.setLocationRelativeTo(null);

        frame.add(labelH);
        frame.add(labelU);
        frame.add(labelP);
        frame.add(textFieldUser);
        frame.add(passwordField);
        frame.add(buttonLogin);
        frame.add(buttonRegister);
        frame.add(buttonClose);
        frame.setVisible(true);

        // Add an ActionListener to DOCTOR'S LOGIN JButton
        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String username = textFieldUser.getText();
                String password = String.valueOf(passwordField.getPassword());

                try {
                    //Open Connection
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection

                    String query = "SELECT * FROM dr_reg_table WHERE usernamed = ? and passwordd = ?";
                    PreparedStatement statement = connection.prepareStatement(query);

                    statement.setString(1, username);
                    statement.setString(2, password);

                    ResultSet rs = statement.executeQuery();

                    if(rs.next()) {
                        JOptionPane.showMessageDialog(null, "WELCOME TO CRYSMED");
                        frame.dispose();
                        new MainDoctor();

                    } else {
                        JOptionPane.showMessageDialog(null, "Username / Password incorrect");

                        textFieldUser.setText("");
                        passwordField.setText("");

                        textFieldUser.requestFocus();


                    }

                    connection.close();

                    } catch (ClassNotFoundException | SQLException | HeadlessException e){
                        JOptionPane.showMessageDialog(null, "System got an error" + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
            }
        });

        // Add an ActionListener to REGISTER JButton
        buttonRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if(event.getSource() == buttonRegister) {
                    frame.dispose();
                    new RegisterD();
                }
            }
        });

        // Add an ActionListener to CLOSE JButton
        buttonClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if(event.getSource() == buttonClose) {
                    frame.dispose();
                    new StartUpPage();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
