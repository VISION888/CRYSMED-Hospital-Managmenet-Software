package packageVision88;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RegisterD extends JFrame implements ActionListener {


    public RegisterD() {

        JLabel labelH = new JLabel();
        JLabel labelIDD = new JLabel();
        JLabel labelNameD = new JLabel();
        JLabel labelUserD = new JLabel();
        JLabel labelPassD = new JLabel();
        JLabel labelEmailD = new JLabel();
        JLabel labelSpecialization = new JLabel();
        JLabel labelPhoneD = new JLabel();
        JLabel labelStreetD = new JLabel();
        JLabel labelCityD = new JLabel();
        JLabel labelPostalD = new JLabel();
        JLabel labelDOBD = new JLabel();
        JLabel labeldate = new JLabel();

        TextField textIDD = new TextField();
        TextField textNameD = new TextField();
        TextField textUserD = new TextField();
        TextField textPassD = new TextField();
        TextField textEmailD = new TextField();
        TextField textSpecialization = new TextField();

        TextField textStreetD = new TextField();
        TextField textCityD = new TextField();

        JFormattedTextField textDOBD;

        // Have a field to format a date in yyyy/mm/dd format
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DateFormatter dateFormatter = new DateFormatter(dateFormat);
        textDOBD = new JFormattedTextField(dateFormatter);

        // Mask for phone spacing
        JFormattedTextField textPhoneD = null;
        try {
            MaskFormatter phonem = new MaskFormatter("### ### ####");
            textPhoneD = new JFormattedTextField(phonem);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Mask for phone spacing
        JFormattedTextField textPostalD = null;
        try {
            MaskFormatter postald = new MaskFormatter("####");
            textPostalD= new JFormattedTextField(postald);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        //email lower case
        textEmailD.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int pos = textEmailD.getCaretPosition();
                textEmailD.setText(textEmailD.getText().toLowerCase());
                textEmailD.setCaretPosition(pos);
            }
        });

        ImageIcon imageTitle = new ImageIcon("doctor_icon.png");
        ImageIcon imageRegister = new ImageIcon("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Hospital Manageme (Intellij)\\Resources\\icon_register.png");
        ImageIcon imageClear = new ImageIcon("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Hospital Manageme (Intellij)\\Resources\\icon_clear.png");
        ImageIcon imageClose = new ImageIcon("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Hospital Manageme (Intellij)\\Resources\\icon_close.png");


        JButton buttonRegister = new JButton("Register", imageRegister);
        JButton buttonClear = new JButton("Clear", imageClear);
        JButton buttonClose = new JButton("Close", imageClose);

        labelH.setText("Doctor's Registration Form");
        labelIDD.setText("Doctors ID: ");
        labelNameD.setText("Full Name: ");
        labelUserD.setText("Username: ");
        labelPassD.setText("Password: ");
        labelEmailD.setText("Email: ");
        labelSpecialization.setText("Specialization:");
        labelPhoneD.setText("Phone Number: ");
        labelStreetD.setText("Street Address: ");
        labelCityD.setText("City: ");
        labelPostalD.setText("Postal Code: ");
        labelDOBD.setText("Date-of-Birth: ");
        labeldate.setText("(yyyy/mm/dd)");

        labelH.setFont(new Font("Comic Sans", Font.ITALIC, 58));
        labelIDD.setFont(new Font("Arial", Font.BOLD, 20));
        labelNameD.setFont(new Font("Arial", Font.BOLD, 18));
        labelUserD.setFont(new Font("Arial", Font.BOLD, 18));
        labelPassD.setFont(new Font("Arial", Font.BOLD, 18));
        labelEmailD.setFont(new Font("Arial", Font.BOLD, 18));
        labelSpecialization.setFont(new Font("Arial", Font.BOLD, 18));
        labelPhoneD.setFont(new Font("Arial", Font.BOLD, 18));
        labelStreetD.setFont(new Font("Arial", Font.BOLD, 18));
        labelCityD.setFont(new Font("Arial", Font.BOLD, 18));
        labelPostalD.setFont(new Font("Arial", Font.BOLD, 18));
        labelDOBD.setFont(new Font("Arial", Font.BOLD, 18));
        labeldate.setFont(new Font("Arial", Font.BOLD, 16));

        textIDD.setFont(new Font("Arial", Font.PLAIN, 18));
        textNameD.setFont(new Font("Arial", Font.PLAIN, 16));
        textUserD.setFont(new Font("Arial", Font.PLAIN, 16));
        textPassD.setFont(new Font("Arial", Font.PLAIN, 16));
        textEmailD.setFont(new Font("Arial", Font.PLAIN, 16));

        textSpecialization.setFont(new Font("Arial", Font.BOLD, 16));
        textPhoneD.setFont(new Font("Arial", Font.PLAIN, 16));
        textStreetD.setFont(new Font("Arial", Font.PLAIN, 16));
        textCityD.setFont(new Font("Arial", Font.PLAIN, 16));
        textPostalD.setFont(new Font("Arial", Font.PLAIN, 16));
        textDOBD.setFont(new Font("Arial", Font.PLAIN, 16));

        labelH.setBounds(120, -40, 1000, 200);

        labelIDD.setBounds(130, 83, 120, 200);
        labelNameD.setBounds(130, 142, 120, 200);
        labelUserD.setBounds(130, 202, 120, 200);
        labelPassD.setBounds(130, 262, 120, 200);
        labelEmailD.setBounds(130, 322, 120, 200);
        labelSpecialization.setBounds(620, 83, 150, 200);
        labelPhoneD.setBounds(620, 142, 150, 200);
        labelStreetD.setBounds(620, 202, 150, 200);
        labelCityD.setBounds(620, 262, 150, 200);
        labelPostalD.setBounds(620, 322, 150, 200);
        labelDOBD.setBounds(620, 382, 150, 200);
        labeldate.setBounds(930, 435, 150, 100);

        textIDD.setBounds(260, 170, 290, 25);
        textNameD.setBounds(260, 230, 290, 25);
        textUserD.setBounds(260, 290, 290, 25);
        textPassD.setBounds(260, 350, 290, 25);
        textEmailD.setBounds(260, 410, 290, 25);
        textSpecialization.setBounds(780, 170, 290, 25);
        textPhoneD.setBounds(780, 230, 290, 25);
        textStreetD.setBounds(780, 290, 290, 25);
        textCityD.setBounds(780, 350, 290, 25);
        textPostalD.setBounds(780, 410, 290, 25);
        textDOBD.setBounds(780, 470, 130, 25);

        labelH.setIconTextGap(90);
        labelH.setIcon(imageTitle);

        buttonRegister.setFont(new Font("Arial", Font.BOLD, 16));
        buttonClear.setFont(new Font("Arial", Font.BOLD, 16));
        buttonClose.setFont(new Font("Arial", Font.BOLD, 16));

        buttonRegister.setBounds(300, 550, 160, 70);
        buttonClear.setBounds(600, 550, 160, 70);
        buttonClose.setBounds(900, 550, 160, 70);

        buttonClear.addActionListener(this);
        buttonRegister.addActionListener(this);
        buttonClose.addActionListener(this);

        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(new Color(145, 184, 219));


        // Set the default close behavior to exit the application
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setDefaultLookAndFeelDecorated(true);
        frame.setTitle("Hospital Management Program");
        frame.setIconImage(new ImageIcon("Resources/icon_hs.png").getImage());
        frame.setLayout(null);

        // Set the x, y, width and height properties in one go
        frame.setSize(1200, 700);
        frame.setResizable(false);

        //Screen Position
        frame.setLocationRelativeTo(null);

        frame.add(labelH);
        frame.add(labelIDD);
        frame.add(labelNameD);
        frame.add(labelUserD);
        frame.add(labelPassD);
        frame.add(labelEmailD);
        frame.add(labelSpecialization);
        frame.add(labelPhoneD);
        frame.add(labelStreetD);
        frame.add(labelCityD);
        frame.add(labelPostalD);
        frame.add(labelDOBD);
        frame.add(labeldate);
        frame.add(textIDD);
        frame.add(textNameD);
        frame.add(textUserD);
        frame.add(textPassD);
        frame.add(textEmailD);
        frame.add(textSpecialization);
        frame.add(textPhoneD);
        frame.add(textStreetD);
        frame.add(textCityD);
        frame.add(textPostalD);
        frame.add(textDOBD);

        frame.add(buttonRegister);
        frame.add(buttonClear);
        frame.add(buttonClose);
        frame.setVisible(true);

        // Add an ActionListener to Nurses LOGIN & REGISTRATION JButton
        // Initialize connection insert / save Data to mySQL
        JFormattedTextField finalTextDOBD = textDOBD;
        JFormattedTextField finalTextPhoneD = textPhoneD;
        JFormattedTextField finalTextPostalD = textPostalD;

        buttonRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String id_dr = textIDD.getText();
                String fullname = textNameD.getText();
                String username = textUserD.getText();
                String password = textPassD.getText();
                String email = textEmailD.getText();
                String Special = textSpecialization.getText();
                String phone = finalTextPhoneD.getText();
                String street = textStreetD.getText();
                String city = textCityD.getText();
                String postal = finalTextPostalD.getText();
                String dob = finalTextDOBD.getText();

                if (textIDD.getText().trim().isEmpty() || (textNameD.getText().trim().equals("") ||
                   (textUserD.getText().trim().equals("")) || (textPassD.getText().trim().equals("") ||
                   (textEmailD.getText().trim().equals("") || (finalTextPhoneD.getText().trim().equals("") ||
                   (textStreetD.getText().trim().equals("") || (textCityD.getText().trim().equals("") ||
                   (finalTextPostalD.getText().trim().equals("") || (finalTextDOBD.getText().trim().equals("")))))))))) {

                    JOptionPane.showMessageDialog(null, "Please complete all fields", "ERROR", JOptionPane.ERROR_MESSAGE);

                } else {

                    try {

                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection
                        Statement stm = connection.createStatement();

                        String selectQuery = ("SELECT id_dr, usernamed FROM dr_reg_table WHERE id_dr = '" + id_dr + "' AND usernamed = '" + username + "'");

                        ResultSet rs = stm.executeQuery(selectQuery);

                        if(rs.next()==true)

                        {
                            JOptionPane.showMessageDialog(null, "User already exists!", "ERROR", JOptionPane.DEFAULT_OPTION);

                        } else {

                        //Add records
                        String insertQuery = "INSERT INTO dr_reg_table(id_dr, fullname, usernamed, passwordd, emaild, specialist, phoned, streetd, cityd, postald, dobd)" +
                                "VALUES('" + textIDD.getText() + "', '" + textNameD.getText() + "', '" + textUserD.getText() + "', '" + textPassD.getText() + "', '" +
                                textEmailD.getText() + "', '" + textSpecialization.getText() + "', '" + finalTextPhoneD.getText() + "', '" + textStreetD.getText() + "', '" + textCityD.getText() + "', '" + finalTextPostalD.getText() + "', '" + finalTextDOBD.getText() + "')";


                            stm.executeUpdate(insertQuery);
                            JOptionPane.showMessageDialog(null, "New User add successfully", "SUCCESS", JOptionPane.DEFAULT_OPTION);
                            frame.dispose();
                            new LoginDr();
                        }
                            connection.close();
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
                    }
                }
            }
        });

        // Add an ActionListener to CLEAR JButton
        JFormattedTextField finalTextDOBD1 = textDOBD;
        JFormattedTextField finalTextPhoneD1 = textPhoneD;

        JFormattedTextField finalTextPostalD1 = textPostalD;
        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                textIDD.setText("");
                textNameD.setText("");
                textUserD.setText("");
                textPassD.setText("");
                textEmailD.setText("");
                textSpecialization.setText("");
                finalTextPhoneD1.setText("");
                textStreetD.setText("");
                textCityD.setText("");
                finalTextPostalD1.setText("");
                finalTextDOBD1.setText("");
                textIDD.setFocusable(true);
            }
        });


        // Add an ActionListener to CLOSE JButton
        buttonClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if (event.getSource() == buttonClose) {
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
