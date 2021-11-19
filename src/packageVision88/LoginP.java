package packageVision88;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginP extends JFrame implements ActionListener {

    public LoginP() {

        JLabel labelH = new JLabel();
        JLabel labelU = new JLabel();
        JLabel labelP = new JLabel();

        ImageIcon imageTitle = new ImageIcon("Resources/patient_icon.png");
        ImageIcon imageLogin = new ImageIcon("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Hospital Manageme (Intellij)\\Resources\\login_icon.png");
        ImageIcon imageClose = new ImageIcon("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Hospital Manageme (Intellij)\\Resources\\icon_close.png");

        JTextField textFieldUserp = new JTextField();
        JPasswordField passwordFieldp = new JPasswordField();

        JButton buttonLogin = new JButton("Login", imageLogin);
        JButton buttonClose = new JButton("Close", imageClose);

        labelH.setText("Patient's Login");
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

        textFieldUserp.setBounds(170,120,310,25);
        passwordFieldp.setBounds(170,160,310,25);

        textFieldUserp.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordFieldp.setFont(new Font("Arial", Font.PLAIN, 18));

        textFieldUserp.setFocusable(true);

        buttonLogin.setFont(new Font("Arial", Font.BOLD, 14));
        buttonClose.setFont(new Font("Arial", Font.BOLD, 14));

        buttonLogin.setBounds(170,200,130,55);
        buttonClose.setBounds(350,200,130,55);


        buttonLogin.addActionListener(this);
        buttonClose.addActionListener(this);

        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(new Color(255, 225, 214));


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
        frame.add(textFieldUserp);
        frame.add(passwordFieldp);
        frame.add(buttonLogin);
        frame.add(buttonClose);
        frame.setVisible(true);

        // Add an ActionListener to DOCTOR'S LOGIN JButton
        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String usernamep = textFieldUserp.getText();
                String passwordp = String.valueOf(passwordFieldp.getPassword());

                try {
                    //Open Connection
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection

                    String query = "SELECT * FROM patient_reg_table WHERE usernamep = ? and passwordp = ?";
                    PreparedStatement statement = connection.prepareStatement(query);

                    statement.setString(1, usernamep);
                    statement.setString(2, passwordp);

                    ResultSet rs = statement.executeQuery();

                    if(rs.next()) {

                        JOptionPane.showMessageDialog(null, "WELCOME TO CRYSMED");
                        frame.dispose();
                        new MainPatient();

                    } else {

                        JOptionPane.showMessageDialog(null, "Username / Password incorrect");
                        textFieldUserp.setText("");
                        passwordFieldp.setText("");
                    }


                    connection.close();

                } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                    System.err.println("System got an error");
                    System.err.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "System got an error" + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

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
