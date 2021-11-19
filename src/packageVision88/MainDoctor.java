package packageVision88;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
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

public class MainDoctor extends JFrame implements ActionListener{


        JLabel labelH = new JLabel();
        JLabel labelPanel = new JLabel();
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
        JLabel labelDOBD= new JLabel();

        TextField textIDD = new TextField();
        TextField textNameD = new TextField();
        TextField textUserD = new TextField();
        TextField textPassD = new TextField();
        TextField textEmailD = new TextField();
        TextField textSpecialization = new TextField();
        TextField textStreetD = new TextField();
        TextField textCityD = new TextField();

        JFormattedTextField textDOBD;

    public MainDoctor() {

            ImageIcon imageTitle = new ImageIcon("Resources/patient_icon.png");
            ImageIcon imageDTitle = new ImageIcon("Resources/doctor_icon.png");
            ImageIcon imageRegister = new ImageIcon("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Hospital Manageme (Intellij)\\Resources\\icon_register.png");
            ImageIcon imageClose = new ImageIcon("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Hospital Manageme (Intellij)\\Resources\\icon_close.png");
            ImageIcon imageUpdate = new ImageIcon("Resources/icon_update.png");
            ImageIcon imageView = new ImageIcon("Resources/icon_view.png");
            ImageIcon imageDelete = new ImageIcon("Resources/icon_delete.png");
            ImageIcon imageDiagnosis = new ImageIcon("Resources/icon_diagnosis.png");

            Border border = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "NURSE'S DETAILS", TitledBorder.LEFT, TitledBorder.TOP);

            Border buttonBorder = BorderFactory.createEtchedBorder();

            JPanel panelD = new JPanel();
            panelD.setLayout(null);

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


            //--------------------- BUTTONS ------------------------
            JButton buttonApps = new JButton("Appointments", imageRegister);
            JButton buttonClose = new JButton("Close", imageClose);
            JButton buttonView = new JButton("View Details", imageView);
            JButton buttonUpdate = new JButton("Update", imageUpdate);
            JButton buttonDelete = new JButton("Delete", imageDelete);

            JButton buttonDiagnosis = new JButton("Symptoms / Diagnosis", imageDiagnosis);

            //---------------- TEXT ----------------------
            labelH.setText("Information / Registration Page");
            labelPanel.setText("Doctor's Details");
            labelH.setText("Doctor's Main Page");
            labelIDD.setText("Doctor's ID: ");
            labelNameD.setText("Fullname: ");
            labelUserD.setText("Username: ");
            labelPassD.setText("Password: ");
            labelEmailD.setText("Email: ");
            labelSpecialization.setText("Specialization: ");
            labelPhoneD.setText("Phone Number: ");
            labelStreetD.setText("Street Address: ");
            labelCityD.setText("City: ");
            labelPostalD.setText("Postal Code: ");
            labelDOBD.setText("Date-of-Birth: ");

            labelH.setFont(new Font("Fantasy", Font.ITALIC, 58));
            labelPanel.setFont(new Font("Comic Sans", Font.BOLD,48));

            labelH.setBounds(100,-40,1000,200);
            labelPanel.setBounds(150,10,600,100);

            //-------------------------- FONTS ----------------------------

            labelIDD.setFont(new Font("Arial", Font.BOLD, 16));     //Added
            labelNameD.setFont(new Font("Arial", Font.BOLD, 16));
            labelUserD.setFont(new Font("Arial", Font.BOLD, 16));
            labelPassD.setFont(new Font("Arial", Font.BOLD, 16));
            labelEmailD.setFont(new Font("Arial", Font.BOLD, 16));
            labelPhoneD.setFont(new Font("Arial", Font.BOLD, 16));
            labelStreetD.setFont(new Font("Arial", Font.BOLD, 16));
            labelCityD.setFont(new Font("Arial", Font.BOLD, 16));
            labelPostalD.setFont(new Font("Arial", Font.BOLD, 16));
            labelDOBD.setFont(new Font("Arial", Font.BOLD, 16));
            labelSpecialization.setFont(new Font("Arial", Font.BOLD, 16));

            textIDD.setFont(new Font("Arial", Font.PLAIN, 16));
            textNameD.setFont(new Font("Arial", Font.PLAIN, 16));
            textUserD.setFont(new Font("Arial", Font.PLAIN, 16));
            textPassD.setFont(new Font("Arial", Font.PLAIN, 16));
            textEmailD.setFont(new Font("Arial", Font.PLAIN, 16));
            textSpecialization.setFont(new Font("Arial", Font.PLAIN, 16));
            textPhoneD.setFont(new Font("Arial", Font.PLAIN, 16));
            textStreetD.setFont(new Font("Arial", Font.PLAIN, 16));
            textCityD.setFont(new Font("Arial", Font.PLAIN,16));
            textPostalD.setFont(new Font("Arial", Font.PLAIN, 16));
            textDOBD.setFont(new Font("Arial", Font.PLAIN, 16));

            //---------------------- BOUNDS ---------------------------

            labelIDD.setBounds(20,120,95,200);      //Added
            labelNameD.setBounds(20,180,95,200);
            labelUserD.setBounds(20,240,95,200);
            labelPassD.setBounds(20,300,95,200);
            labelEmailD.setBounds(20,360,95,200);

            textIDD.setBounds(120,210,250,25);        //Added
            textNameD.setBounds(120,270,250,25);
            textUserD.setBounds(120,330,250,25);
            textPassD.setBounds(120,390,250,25);
            textEmailD.setBounds(120,450,250,25);

            labelSpecialization.setBounds(410,120,125,200);
            labelPhoneD.setBounds(410,180,125,200);
            labelStreetD.setBounds(410,240,125,200);
            labelCityD.setBounds(410,300,125,200);
            labelPostalD.setBounds(410,360,125,200);
            labelDOBD.setBounds(410,420,125,200);

            textSpecialization.setBounds(540,210,250,25);
            textPhoneD.setBounds(540,270,250,25);
            textStreetD.setBounds(540,330,250,25);
            textCityD.setBounds(540,390,250,25);
            textPostalD.setBounds(540,450,250,25);
            textDOBD.setBounds(540,510,150,25);

            labelH.setIconTextGap(70);
            labelH.setIcon(imageTitle);

            labelPanel.setIconTextGap(45);
            labelPanel.setIcon(imageDTitle);

            // --------------------- BUTTON FONT STYLING ------------------------
            buttonApps.setFont(new Font("Arial", Font.BOLD, 18));
            buttonClose.setFont(new Font("Arial", Font.BOLD, 20));
            buttonUpdate.setFont(new Font("Arial", Font.BOLD, 16));
            buttonView.setFont(new Font("Arial", Font.BOLD, 18));
            buttonDelete.setFont(new Font("Arial", Font.BOLD,18));
            buttonDiagnosis.setFont(new Font("Arial", Font.BOLD,18));

            // ---------------------- BUTTON BOUNDS ------------------------
            buttonApps.setBounds(950,125,260,60);       //x is right to left, y is is up to down
            buttonDiagnosis.setBounds(950, 220,260,60);
            buttonClose.setBounds(950,310,260,60);

            buttonUpdate.setBounds(600,120,170,50);
            buttonView.setBounds(330, 120, 170,50);
            buttonDelete.setBounds(60,120,170,50);

            //------------------------- INSETS --------------------
            buttonView.setMargin(new Insets(5,5,5,5));
            buttonUpdate.setMargin(new Insets(5,5,5,5));
            buttonDelete.setMargin(new Insets(5,5,5,5));

            buttonView.setBackground(new Color(145,184,219));
            buttonUpdate.setBackground(Color.GRAY);
            buttonDelete.setBackground(Color.GRAY);

            buttonUpdate.setForeground(Color.WHITE);
            buttonDelete.setForeground(Color.WHITE);

            //--------------- BUTTON'S EVENT ACTION LISTENERS ------------------
            buttonApps.addActionListener(this);

            buttonClose.addActionListener(this);
            buttonUpdate.addActionListener(this);
            buttonDelete.addActionListener(this);
            buttonDiagnosis.addActionListener(this);

            //----------------- BUTTON BORDER'S -------------------------
            buttonApps.setBorder(buttonBorder);
            buttonClose.setBorder(buttonBorder);
            buttonUpdate.setBorder(buttonBorder);
            buttonDelete.setBorder(buttonBorder);
            buttonDiagnosis.setBorder(buttonBorder);

            // ---------------- BUTTON FOCUSABLE -----------------
            buttonApps.setFocusable(false);

            buttonClose.setFocusable(false);
            buttonView.setFocusable(false);
            buttonUpdate.setFocusable(false);
            buttonDelete.setFocusable(false);
            buttonDiagnosis.setFocusable(false);

            panelD.setBounds(110, 120,820,570); // Set Panel Bounds
            panelD.setBorder(border);

            JFrame frame = new JFrame();

            // Set the default close behavior to exit the application
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            frame.setDefaultLookAndFeelDecorated(true);
            frame.setTitle("Hospital Management Program");
            frame.setIconImage(new ImageIcon("Resources/icon_hs.png").getImage());
            frame.setLayout(null);

            // Set the x, y, width and height properties in one go
            frame.setSize(1250, 750);
            frame.setResizable(false);

            frame.getContentPane().setBackground(new Color(145,184,219));

            //Screen Position
            frame.setLocationRelativeTo(null);

            panelD.add(labelPanel);
            panelD.add(labelIDD);
            panelD.add(labelNameD);
            panelD.add(labelUserD);
            panelD.add(labelPassD);
            panelD.add(labelEmailD);
            panelD.add(labelSpecialization);
            panelD.add(labelPhoneD);
            panelD.add(labelStreetD);
            panelD.add(labelCityD);
            panelD.add(labelPostalD);
            panelD.add(labelDOBD);

            panelD.add(buttonUpdate);
            panelD.add(buttonView);
            panelD.add(buttonDelete);

            panelD.add(textIDD);
            panelD.add(textNameD);
            panelD.add(textUserD);
            panelD.add(textPassD);
            panelD.add(textEmailD);
            panelD.add(textSpecialization);
            panelD.add(textPhoneD);
            panelD.add(textStreetD);
            panelD.add(textCityD);
            panelD.add(textPostalD);
            panelD.add(textDOBD);

            frame.add(labelH);
            frame.add(panelD);

            frame.add(buttonApps);
            frame.add(buttonClose);
            frame.add(buttonDiagnosis);
            frame.setVisible(true);

            // Add an ActionListener to VIEW NURSES DETAILS JButton
        JFormattedTextField finalTextPhoneD = textPhoneD;
        JFormattedTextField finalTextPostalD = textPostalD;
        buttonView.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {

                    String id_doctor = textIDD.getText();
                    String fname = textNameD.getText();
                    String username = textUserD.getText();
                    String password = textPassD.getText();
                    String email = textEmailD.getText();
                    String specialization = textSpecialization.getText();
                    String phone = finalTextPhoneD.getText();
                    String street = textStreetD.getText();
                    String city = textCityD.getText();
                    String postal = finalTextPostalD.getText();
                    String dob = textDOBD.getText();

                    textIDD.requestFocus();
                    textIDD.setBackground(new Color(145,184,219));
                    textUserD.setBackground(new Color(145,184,219));

                    try {

                        //Establish / Open Connection
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection

                        String query = "SELECT * FROM dr_reg_table WHERE id_dr = ? AND usernamed = ?";

                        PreparedStatement statement = connection.prepareStatement(query);

                        statement.setString(1, id_doctor);
                        statement.setString(2, username);

                        //Executing Query
                        ResultSet rs = statement.executeQuery();

                        // JOptionPane.showMessageDialog(null, "Enter Nurse's ID to view details");

                        if (rs.next()) {

                            String s = rs.getString(1);
                            String s1 = rs.getString(2);
                            String s2 = rs.getString(3);
                            String s3 = rs.getString(4);
                            String s4 = rs.getString(5);
                            String s5 = rs.getString(6);
                            String s6 = rs.getString(7);
                            String s7 = rs.getString(8);
                            String s8 = rs.getString(9);
                            String s9 = rs.getString(10);
                            String s10 = rs.getString(11);


                            // Set records into textfield

                            textIDD.setText(s);
                            textNameD.setText(s1);
                            textUserD.setText(s2);
                            textPassD.setText(s3);
                            textEmailD.setText(s4);
                            textSpecialization.setText(s5);
                            finalTextPhoneD.setText(s6);
                            textStreetD.setText(s7);
                            textCityD.setText(s8);
                            finalTextPostalD.setText(s9);
                            textDOBD.setText(s10);

                            textIDD.setEditable(false);
                            textIDD.setFocusable(false);
                            textIDD.setBackground(Color.WHITE);
                            textUserD.setFocusable(false);
                            textUserD.setBackground(Color.WHITE);

                            connection.close();

                        } else if(textIDD.getText().trim().isEmpty() && textUserD.getText().trim().isEmpty()) {

                            JOptionPane.showMessageDialog(null, "Please enter Doctors ID and Username");
                        } else {
                            JOptionPane.showMessageDialog(null, "ID not Found / Register User");

                        }


                    } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                        System.err.println("System got an error");
                        System.err.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "System got an error" + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                    }
                }
            });


            // Add an ActionListener to UPDATE NURSE'S DETAILS JButton
        JFormattedTextField finalTextPhoneD1 = textPhoneD;
        JFormattedTextField finalTextPostalD1 = textPostalD;

        buttonUpdate.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {

                    try {

                        String ID_D = textIDD.getText();
                        String FNAME = textNameD.getText();
                        String USERNAME = textUserD.getText();
                        String PASSWORD = textPassD.getText();
                        String EMAIL = textEmailD.getText();
                        String SPECIAL = textSpecialization.getText();
                        String PHONE = finalTextPhoneD1.getText();
                        String STREET = textStreetD.getText();
                        String CITY = textCityD.getText();
                        String POSTAL = finalTextPostalD1.getText();
                        String DOB = textDOBD.getText();

                        //Establish / Open Connection
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection

                        String query = "UPDATE dr_reg_table SET " +
                                "fullname ='" + FNAME + "', usernamed = '" + USERNAME + "', passwordd = '" + PASSWORD + "', emaild = '"
                                + EMAIL + "', specialist = '" + SPECIAL + "', phoned = '" + PHONE + "', streetd = '" + STREET + "', cityd = '" + CITY + "', postald = '" + POSTAL + "', dobd = '"
                                + DOB + "'" + " WHERE id_dr = '" + ID_D + "'";

                        PreparedStatement statement = connection.prepareStatement(query);

                        statement.executeUpdate();
                        JOptionPane.showMessageDialog(null, "" + FNAME + " your data was successfully Updated!", "UPDATED!", JOptionPane.DEFAULT_OPTION);

                        textIDD.setBackground(Color.WHITE);
                        textUserD.setBackground(Color.WHITE);

                        connection.close();

                    } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                        System.err.println("System got an error");
                        System.err.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "System got an error" + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                    }
                }
            });

            // Add an ActionListener to DELETE USER JButton
        JFormattedTextField finalTextPhoneD2 = textPhoneD;
        JFormattedTextField finalTextPostalD2 = textPostalD;

        buttonDelete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {


                    try {

                        //Establish / Open Connection
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection

                        String query = "DELETE FROM doctor_reg_table WHERE id_dr = ? ";

                        PreparedStatement statement = connection.prepareStatement(query);

                        statement.setString(1,textIDD.getText());

                        statement.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Deleted Successfully");

                        textIDD.setText("");
                        textNameD.setText("");
                        textUserD.setText("");
                        textPassD.setText("");
                        textEmailD.setText("");
                        textSpecialization.setText("");
                        finalTextPhoneD2.setText("");
                        textStreetD.setText("");
                        textCityD.setText("");
                        finalTextPostalD2.setText("");
                        textDOBD.setText("");


                    } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                        System.err.println("System got an error");
                        System.err.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "System got an error" + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                    }
                }
            });


            // Add an ActionListener to REGISTER NEW PATIENT JButton
            buttonApps.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {

                    if(event.getSource() == buttonApps) {
                        frame.dispose();
                        new Doctor_App();

                    }
                }
            });

            // Add an ActionListener to ACCESS PATIENT RECORDS / DIAGNOSIS JButton
            buttonDiagnosis.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {

                    if(event.getSource() == buttonDiagnosis) {
                        frame.dispose();
                        new Doctor_diagnoses();
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
