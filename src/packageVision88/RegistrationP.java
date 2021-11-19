package packageVision88;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RegistrationP extends JFrame implements ActionListener {

    JLabel labelH = new JLabel();
    JLabel labelIDP = new JLabel();
    JLabel labelNameP = new JLabel();
    JLabel labelLastP = new JLabel();
    JLabel labelUserP = new JLabel();
    JLabel labelPassP = new JLabel();
    JLabel labelEmailP = new JLabel();
    JLabel labelPhoneP = new JLabel();
    JLabel labelStreetP = new JLabel();
    JLabel labelCityP = new JLabel();
    JLabel labelPostalP = new JLabel();
    JLabel labelDOBP= new JLabel();
    JLabel labeldateformat = new JLabel();
    JLabel labelGenderP = new JLabel();

    TextField textIDP = new TextField();
    TextField textNameP = new TextField();
    TextField textLastP = new TextField();
    TextField textUserP = new TextField();
    TextField textPassP = new TextField();
    TextField textEmailP = new TextField();
    TextField textStreetP = new TextField();
    TextField textCityP = new TextField();
    JFormattedTextField textDOBP;

    public RegistrationP() {

        // Have a field to format a date in yyyy/mm/dd format
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DateFormatter dateFormatter = new DateFormatter(dateFormat);
        textDOBP = new JFormattedTextField(dateFormatter);

        // Mask for phone spacing
        JFormattedTextField textPhoneP = null;
        try {
            MaskFormatter phonem = new MaskFormatter("### ### ####");
            textPhoneP = new JFormattedTextField(phonem);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Mask for phone spacing
        JFormattedTextField textPostalP = null;
        try {
            MaskFormatter postalP = new MaskFormatter("####");
            textPostalP= new JFormattedTextField(postalP);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //email lower case
        textEmailP.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int pos = textEmailP.getCaretPosition();
                textEmailP.setText(textEmailP.getText().toLowerCase());
                textEmailP.setCaretPosition(pos);
            }
        });


        JComboBox comboGenderp = new JComboBox();

        ImageIcon imageTitle = new ImageIcon("patient_icon.png");
        ImageIcon imageRegister = new ImageIcon("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Hospital Manageme (Intellij)\\Resources\\icon_register.png");
        ImageIcon imageClear = new ImageIcon("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Hospital Manageme (Intellij)\\Resources\\icon_clear.png");
        ImageIcon imageClose = new ImageIcon("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Hospital Manageme (Intellij)\\Resources\\icon_close.png");

        JButton buttonRegister = new JButton("Register", imageRegister);
        JButton buttonClear = new JButton("Clear", imageClear);
        JButton buttonClose = new JButton("Close", imageClose);

        labelH.setText("Patient's Registration Form");
        labelIDP.setText("Patient's ID: ");
        labelNameP.setText("First Name: ");
        labelLastP.setText("Last Name: ");
        labelUserP.setText("Username: ");
        labelPassP.setText("Password: ");
        labelEmailP.setText("Email: ");
        labelPhoneP.setText("Phone Number: ");
        labelStreetP.setText("Street Address: ");
        labelCityP.setText("City: ");
        labelPostalP.setText("Postal Code: ");
        labelDOBP.setText("Date-of-Birth: ");
        labeldateformat.setText("yyyy/mm/dd");
        labelGenderP.setText("Gender: ");


        labelH.setFont(new Font("Comic Sans", Font.ITALIC, 58));
        labelIDP.setFont(new Font("Arial", Font.BOLD, 19));
        labelNameP.setFont(new Font("Arial", Font.BOLD, 18));
        labelLastP.setFont(new Font("Arial", Font.BOLD, 18));
        labelUserP.setFont(new Font("Arial", Font.BOLD, 18));
        labelPassP.setFont(new Font("Arial", Font.BOLD, 18));
        labelEmailP.setFont(new Font("Arial", Font.BOLD, 18));
        labelPhoneP.setFont(new Font("Arial", Font.BOLD, 18));
        labelStreetP.setFont(new Font("Arial", Font.BOLD, 18));
        labelCityP.setFont(new Font("Arial", Font.BOLD, 18));
        labelPostalP.setFont(new Font("Arial", Font.BOLD, 18));
        labelDOBP.setFont(new Font("Arial", Font.BOLD, 18));
        labeldateformat.setFont(new Font("Arial", Font.BOLD, 14));
        labelGenderP.setFont(new Font("Arial", Font.BOLD, 18));

        labelH.setBounds(120, -40, 1000, 200);

        labelIDP.setBounds(130, 83, 120, 200);
        labelNameP.setBounds(130, 142, 120, 200);
        labelLastP.setBounds(130, 202, 120, 200);
        labelUserP.setBounds(130, 262, 120, 200);
        labelPassP.setBounds(130, 322, 120, 200);
        labelEmailP.setBounds(130, 382, 120, 200);

        textIDP.setBounds(260, 170, 290, 25);
        textNameP.setBounds(260, 230, 290, 25);
        textLastP.setBounds(260, 290, 290, 25);
        textUserP.setBounds(260, 350, 290, 25);
        textPassP.setBounds(260, 410, 290, 25);
        textEmailP.setBounds(260, 470, 290, 25);

        textIDP.setFont(new Font("Arial", Font.PLAIN, 18));
        textNameP.setFont(new Font("Arial", Font.PLAIN, 16));
        textLastP.setFont(new Font("Arial", Font.PLAIN, 16));
        textUserP.setFont(new Font("Arial", Font.PLAIN, 16));
        textPassP.setFont(new Font("Arial", Font.PLAIN, 16));
        textEmailP.setFont(new Font("Arial", Font.PLAIN, 16));

        labelPhoneP.setBounds(620, 83, 150, 200);
        labelStreetP.setBounds(620, 142, 150, 200);
        labelCityP.setBounds(620, 202, 150, 200);
        labelPostalP.setBounds(620, 262, 150, 200);
        labelDOBP.setBounds(620, 322, 150, 200);
        labeldateformat.setBounds(920,410,100,25);
        labelGenderP.setBounds(620, 382, 150, 200);

        textPhoneP.setBounds(780, 170, 290, 25);
        textStreetP.setBounds(780, 230, 290, 25);
        textCityP.setBounds(780, 290, 290, 25);
        textPostalP.setBounds(780, 350, 290, 25);
        textDOBP.setBounds(780, 410, 130, 25);

        comboGenderp.addItem("");
        comboGenderp.addItem("Male");
        comboGenderp.addItem("Female");

        comboGenderp.setBounds(780, 470, 150, 25);

        textPhoneP.setFont(new Font("Arial", Font.PLAIN, 16));
        textStreetP.setFont(new Font("Arial", Font.PLAIN, 16));
        textCityP.setFont(new Font("Arial", Font.PLAIN, 16));
        textPostalP.setFont(new Font("Arial", Font.PLAIN, 16));
        textDOBP.setFont(new Font("Arial", Font.PLAIN, 16));

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
        frame.add(labelIDP);
        frame.add(labelNameP);
        frame.add(labelLastP);
        frame.add(labelUserP);
        frame.add(labelPassP);
        frame.add(labelEmailP);
        frame.add(labelPhoneP);
        frame.add(labelStreetP);
        frame.add(labelCityP);
        frame.add(labelPostalP);
        frame.add(labelDOBP);
        frame.add(labeldateformat);
        frame.add(labelGenderP);

        frame.add(textIDP);
        frame.add(textNameP);
        frame.add(textLastP);
        frame.add(textUserP);
        frame.add(textPassP);
        frame.add(textEmailP);

        frame.add(textPhoneP);
        frame.add(textStreetP);
        frame.add(textCityP);
        frame.add(textPostalP);
        frame.add(textDOBP);

        frame.add(comboGenderp);

        frame.add(buttonRegister);
        frame.add(buttonClear);
        frame.add(buttonClose);

        frame.setVisible(true);


        // Add an ActionListener to REGISTRATION JButton
        JFormattedTextField finalTextPhoneP = textPhoneP;
        JFormattedTextField finalTextPostalP = textPostalP;
        buttonRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String id_p = textIDP.getText();
                String usernamep = textUserP.getText();

                if (textIDP.getText().trim().isEmpty() || textIDP.getText().trim().equals("Enter Nurses ID") ||
                   (textIDP.getText().trim().equals("") || textIDP.getText().trim().equals("Enter First Name") ||
                   (textLastP.getText().trim().equals("")) || textLastP.getText().trim().equals("Enter Last Name") ||
                   (textUserP.getText().trim().equals("")) || textUserP.getText().trim().equals("Enter Username") ||
                   (textPassP.getText().trim().equals("") || textPassP.getText().trim().equals("Enter Password") ||
                   (textEmailP.getText().trim().equals("") || textEmailP.getText().trim().equals("Enter Email Address") ||
                   (finalTextPhoneP.getText().trim().equals("") || finalTextPhoneP.getText().trim().equals("Enter Phone Number") ||
                   (textStreetP.getText().trim().equals("") || textStreetP.getText().trim().equals("Enter Street") ||
                   (textCityP.getText().trim().equals("") || textCityP.getText().trim().equals("Enter City") ||
                   (finalTextPostalP.getText().trim().equals("") || finalTextPostalP.getText().trim().equals("Enter Postal code") ||
                   (textDOBP.getText().trim().equals("") || textDOBP.getText().trim().equals("Enter Date of Birth")))))))))) {

                    JOptionPane.showMessageDialog(null, "Please complete all fields", "ERROR", JOptionPane.ERROR_MESSAGE);

                } else if (comboGenderp.getSelectedItem().toString().equals("")) {

                    JOptionPane.showConfirmDialog(null, "Please choose Gender!", "Error", JOptionPane.ERROR_MESSAGE);

                } else {

                    try {

                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection
                        Statement stm = connection.createStatement();

                        String selectQuery = ("SELECT usernamep, passwordp FROM patient_reg_table WHERE id_p = '" + id_p + "' AND usernamep = '" + usernamep + "'");

                        ResultSet rs = stm.executeQuery(selectQuery);

                        if(rs.next()==true)

                        {
                            JOptionPane.showMessageDialog(null, "User already exists!", "ERROR", JOptionPane.DEFAULT_OPTION);

                        } else {

                        //Add records
                        String insertQuery = "INSERT INTO patient_reg_table(id_p, fnamep, lnamep, usernamep, passwordp, emailp, phonep, streetp, cityp, postalp, dobp, genderp)" +
                                "VALUES('" + textIDP.getText() + "', '" + textNameP.getText() + "', '" + textLastP.getText() + "', '" + textUserP.getText() + "', '" + textPassP.getText() + "', '" +
                                textEmailP.getText() + "', '" + finalTextPhoneP.getText() + "', '" + textStreetP.getText() + "', '" + textCityP.getText() + "', '" + finalTextPostalP.getText() + "', '" + textDOBP.getText() + "', '" + comboGenderp.getSelectedItem() + "')";

                            stm.executeUpdate(insertQuery);
                            connection.close();
                            JOptionPane.showMessageDialog(null, "New User add successfully", "SUCCESS", JOptionPane.DEFAULT_OPTION);
                            frame.dispose();
                            new MainNurse();
                        }

                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
                    }
                }
            }
        });

        // Add an ActionListener to CLOSE JButton
        JFormattedTextField finalTextPhoneP1 = textPhoneP;
        JFormattedTextField finalTextPostalP1 = textPostalP;
        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                textIDP.setText("");
                textNameP.setText(" ");
                textLastP.setText(" ");
                textUserP.setText(" ");
                textPassP.setText(" ");
                textEmailP.setText(" ");
                finalTextPhoneP1.setText(" ");
                textStreetP.setText(" ");
                textCityP.setText(" ");
                finalTextPostalP1.setText(" ");
                textDOBP.setText(" ");
                textIDP.setFocusable(true);

                comboGenderp.setSelectedIndex(0);
            }
        });

        // Add an ActionListener to CLOSE JButton
        buttonClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if (event.getSource() == buttonClose) {
                    frame.dispose();
                    new MainNurse();
                }
            }
        });
    }

       @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
