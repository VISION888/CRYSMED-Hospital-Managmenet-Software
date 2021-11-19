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

public class RegistrationN extends JFrame implements ActionListener {


    public RegistrationN() {

        JLabel labelH = new JLabel();
        JLabel labelIDN = new JLabel();
        JLabel labelNameN = new JLabel();
        JLabel labelLastN = new JLabel();
        JLabel labelUserN = new JLabel();
        JLabel labelPassN = new JLabel();
        JLabel labelEmailN = new JLabel();
        JLabel labelPhoneN = new JLabel();
        JLabel labelStreetN = new JLabel();
        JLabel labelCityN = new JLabel();
        JLabel labelPostalN = new JLabel();
        JLabel labelDOBN= new JLabel();
        JLabel labeldateformat = new JLabel();
        JLabel labelGenderN = new JLabel();

        TextField textIDN = new TextField();
        TextField textNameN = new TextField();
        TextField textLastN = new TextField();
        TextField textUserN = new TextField();
        TextField textPassN = new TextField();
        TextField textEmailN = new TextField();
        TextField textStreetN = new TextField();
        TextField textCityN = new TextField();
        JFormattedTextField textDOBN;

        JComboBox comboGender = new JComboBox();

        // Have a field to format a date in yyyy/mm/dd format
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DateFormatter dateFormatter = new DateFormatter(dateFormat);
        textDOBN = new JFormattedTextField(dateFormatter);

        // Mask for phone spacing
        JFormattedTextField textPhoneN = null;
        try {
            MaskFormatter phonem = new MaskFormatter("### ### ####");
            textPhoneN = new JFormattedTextField(phonem);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Mask for phone spacing
        JFormattedTextField textPostalN = null;
        try {
            MaskFormatter postald = new MaskFormatter("####");
            textPostalN= new JFormattedTextField(postald);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //email lower case
        textEmailN.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int pos = textEmailN.getCaretPosition();
                textEmailN.setText(textEmailN.getText().toLowerCase());
                textEmailN.setCaretPosition(pos);
            }
        });

        ImageIcon imageTitle = new ImageIcon("nurse_icon.png");
        ImageIcon imageRegister = new ImageIcon("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Hospital Manageme (Intellij)\\Resources\\icon_register.png");
        ImageIcon imageClear = new ImageIcon("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Hospital Manageme (Intellij)\\Resources\\icon_clear.png");
        ImageIcon imageClose = new ImageIcon("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Hospital Manageme (Intellij)\\Resources\\icon_close.png");

        JButton buttonRegister = new JButton("Register", imageRegister);
        JButton buttonClear = new JButton("Clear", imageClear);
        JButton buttonClose = new JButton("Close", imageClose);

        labelH.setText("Nurse's Registration Form");
        labelIDN.setText("Nurse's ID: ");
        labelNameN.setText("First Name: ");
        labelLastN.setText("Last Name: ");
        labelUserN.setText("Username: ");
        labelPassN.setText("Password: ");
        labelEmailN.setText("Email: ");
        labelPhoneN.setText("Phone Number: ");
        labelStreetN.setText("Street Address: ");
        labelCityN.setText("City: ");
        labelPostalN.setText("Postal Code: ");
        labelDOBN.setText("Date-of-Birth: ");
        labeldateformat.setText("yyyy/mm/dd");
        labelGenderN.setText("Gender: ");


        labelH.setFont(new Font("Comic Sans", Font.ITALIC, 58));
        labelIDN.setFont(new Font("Arial", Font.BOLD, 22));
        labelNameN.setFont(new Font("Arial", Font.BOLD, 18));
        labelLastN.setFont(new Font("Arial", Font.BOLD, 18));
        labelUserN.setFont(new Font("Arial", Font.BOLD, 18));
        labelPassN.setFont(new Font("Arial", Font.BOLD, 18));
        labelEmailN.setFont(new Font("Arial", Font.BOLD, 18));
        labelPhoneN.setFont(new Font("Arial", Font.BOLD, 18));
        labelStreetN.setFont(new Font("Arial", Font.BOLD, 18));
        labelCityN.setFont(new Font("Arial", Font.BOLD, 18));
        labelPostalN.setFont(new Font("Arial", Font.BOLD, 18));
        labelDOBN.setFont(new Font("Arial", Font.BOLD, 18));
        labeldateformat.setFont(new Font("Arial", Font.BOLD, 14));
        labelGenderN.setFont(new Font("Arial", Font.BOLD, 18));

        labelH.setBounds(120,-40,1000,200);

        labelIDN.setBounds(130,83,120,200);
        labelNameN.setBounds(130,142,120,200);
        labelLastN.setBounds(130,202,120,200);
        labelUserN.setBounds(130,262,120,200);
        labelPassN.setBounds(130,322,120,200);
        labelEmailN.setBounds(130,382,120,200);

        textIDN.setBounds(260,170,290,25);
        textNameN.setBounds(260,230,290,25);
        textLastN.setBounds(260,290,290,25);
        textUserN.setBounds(260,350,290,25);
        textPassN.setBounds(260,410,290,25);
        textEmailN.setBounds(260,470,290,25);

        textIDN.setFont(new Font("Arial", Font.PLAIN, 18));
        textNameN.setFont(new Font("Arial", Font.PLAIN, 16));
        textLastN.setFont(new Font("Arial", Font.PLAIN,16));
        textUserN.setFont(new Font("Arial", Font.PLAIN, 16));
        textPassN.setFont(new Font("Arial", Font.PLAIN, 16));
        textEmailN.setFont(new Font("Arial", Font.PLAIN, 16));

        labelPhoneN.setBounds(620,83,150,200);
        labelStreetN.setBounds(620,142,150,200);
        labelCityN.setBounds(620,202,150,200);
        labelPostalN.setBounds(620,262,150,200);
        labelDOBN.setBounds(620,322,150,200);
        labeldateformat.setBounds(920,410,100,25);
        labelGenderN.setBounds(620,382,150,200);

        textPhoneN.setBounds(780,170,290,25);
        textStreetN.setBounds(780,230,290,25);
        textCityN.setBounds(780,290,290,25);
        textPostalN.setBounds(780,350,290,25);
        textDOBN.setBounds(780,410,130,25);

        comboGender.addItem("");
        comboGender.addItem("Male");
        comboGender.addItem("Female");

        comboGender.setBounds(780,470,150,25);

        textPhoneN.setFont(new Font("Arial", Font.PLAIN, 16));
        textStreetN.setFont(new Font("Arial", Font.PLAIN, 16));
        textCityN.setFont(new Font("Arial", Font.PLAIN,16));
        textPostalN.setFont(new Font("Arial", Font.PLAIN, 16));
        textDOBN.setFont(new Font("Arial", Font.PLAIN, 16));

        labelH.setIconTextGap(90);
        labelH.setIcon(imageTitle);

        buttonRegister.setFont(new Font("Arial", Font.BOLD, 16));
        buttonClear.setFont(new Font("Arial", Font.BOLD, 16));
        buttonClose.setFont(new Font("Arial", Font.BOLD, 16));

        buttonRegister.setBounds(300,550,160,70);
        buttonClear.setBounds(600,550,160,70);
        buttonClose.setBounds(900,550,160,70);

        buttonClear.addActionListener(this);
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
        frame.setSize(1200, 700);
        frame.setResizable(false);

        //Screen Position
        frame.setLocationRelativeTo(null);

        frame.add(labelH);
        frame.add(labelIDN);
        frame.add(labelNameN);
        frame.add(labelLastN);
        frame.add(labelUserN);
        frame.add(labelPassN);
        frame.add(labelEmailN);
        frame.add(labelPhoneN);
        frame.add(labelStreetN);
        frame.add(labelCityN);
        frame.add(labelPostalN);
        frame.add(labelDOBN);
        frame.add(labeldateformat);
        frame.add(labelGenderN);
        frame.add(textIDN);
        frame.add(textNameN);
        frame.add(textLastN);
        frame.add(textUserN);
        frame.add(textPassN);
        frame.add(textEmailN);
        frame.add(textPhoneN);
        frame.add(textStreetN);
        frame.add(textCityN);
        frame.add(textPostalN);
        frame.add(textDOBN);
        frame.add(comboGender);
        frame.add(buttonRegister);
        frame.add(buttonClear);
        frame.add(buttonClose);
        frame.setVisible(true);

        // Add an ActionListener to Nurses LOGIN & REGISTRATION JButton
        // Initialize connection insert / save Data to mySQL
        JFormattedTextField finalTextPhoneN = textPhoneN;
        JFormattedTextField finalTextPostalN = textPostalN;
        JFormattedTextField finalTextDOBN = textDOBN;
        buttonRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String id_nurse = textIDN.getText();
                String fname = textNameN.getText();
                String lname = textLastN.getText();
                String username = textUserN.getText();
                String password = textPassN.getText();
                String email = textEmailN.getText();
                String phone = finalTextPhoneN.getText();
                String street = textStreetN.getText();
                String city = textCityN.getText();
                String postal = finalTextPostalN.getText();
                String dob = finalTextDOBN.getText();
                String gender = (String) comboGender.getSelectedItem();


                if (textIDN.getText().trim().isEmpty() || textIDN.getText().trim().equals("Enter Nurses ID") ||
                   (textIDN.getText().trim().equals("") || textIDN.getText().trim().equals("Enter First Name") ||
                   (textLastN.getText().trim().equals("")) || textLastN.getText().trim().equals("Enter Last Name") ||
                   (textUserN.getText().trim().equals("")) || textUserN.getText().trim().equals("Enter Username") ||
                   (textPassN.getText().trim().equals("") || textPassN.getText().trim().equals("Enter Password") ||
                   (textEmailN.getText().trim().equals("") || textEmailN.getText().trim().equals("Enter Email Address") ||
                   (finalTextPhoneN.getText().trim().equals("") || finalTextPhoneN.getText().trim().equals("Enter Phone Number") ||
                   (textStreetN.getText().trim().equals("") || textStreetN.getText().trim().equals("Enter Street Address") ||
                   (textCityN.getText().trim().equals("") || textCityN.getText().trim().equals("Enter City") ||
                    (finalTextPostalN.getText().trim().equals("") || finalTextPostalN.getText().trim().equals("Enter Postal code") ||
                   (finalTextDOBN.getText().trim().equals("") || finalTextDOBN.getText().trim().equals("Enter Date of Birth")))))))))) {

                    JOptionPane.showMessageDialog(null, "Please complete all fields", "ERROR", JOptionPane.ERROR_MESSAGE);

                } else if (comboGender.getSelectedItem().toString().equals("")) {

                             JOptionPane.showConfirmDialog(null, "Please choose Gender!", "Error", JOptionPane.ERROR_MESSAGE);

                } else  {

                                // Check if user already registered

                        try {


                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection
                            Statement stm = connection.createStatement();

                            String selectQuery = ("SELECT id_n_reg, username FROM nurses_reg_table WHERE id_n_reg = '" + id_nurse + "' AND username = '" + username + "'");

                            ResultSet rs = stm.executeQuery(selectQuery);

                            if(rs.next()==true)

                            {
                                JOptionPane.showMessageDialog(null, "User already exists!", "ERROR", JOptionPane.DEFAULT_OPTION);

                            } else {
                                //Add records

                            String insertQuery = "INSERT INTO nurses_reg_table(id_n_reg, fname, lname, username, password, email, phone, street, city, postal, dob, gender)" +
                                    "VALUES('" + textIDN.getText() + "', '" + textNameN.getText() + "', '" + textLastN.getText() + "', '" + textUserN.getText() + "', '" + textPassN.getText() + "', '" +
                                    textEmailN.getText() + "', '" + finalTextPhoneN.getText() + "', '" + textStreetN.getText() + "', '" + textCityN.getText() + "', '" + finalTextPostalN.getText() + "', '" + finalTextDOBN.getText() + "', '" + comboGender.getSelectedItem() + "')";

                                stm.executeUpdate(insertQuery);
                                connection.close();
                                JOptionPane.showMessageDialog(null, "New User add successfully", "SUCCESS", JOptionPane.DEFAULT_OPTION);
                                frame.dispose();
                                new LoginN();
                            }

                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                            JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
                  }
                }
            }
        });

        // Add an ActionListener to CLEAR JButton
        JFormattedTextField finalTextPhoneN1 = textPhoneN;
        JFormattedTextField finalTextPostalN1 = textPostalN;
        JFormattedTextField finalTextDOBN1 = textDOBN;
        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                textIDN.setText("");
                textNameN.setText(" ");
                textLastN.setText(" ");
                textUserN.setText(" ");
                textPassN.setText(" ");
                textEmailN.setText(" ");
                finalTextPhoneN1.setText(" ");
                textStreetN.setText(" ");
                textCityN.setText(" ");
                finalTextPostalN1.setText(" ");
                finalTextDOBN1.setText(" ");
                textIDN.setFocusable(true);
                comboGender.setSelectedIndex(0);

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
