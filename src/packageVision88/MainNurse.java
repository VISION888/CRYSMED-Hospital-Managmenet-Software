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
import java.math.BigDecimal;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MainNurse extends JFrame implements ActionListener {

    JLabel labelH = new JLabel();
    JLabel labelPanel = new JLabel();

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


    public MainNurse() {

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


        ImageIcon imageTitle = new ImageIcon("patient_icon.png");
        ImageIcon imagePTitle = new ImageIcon("nurse_icon.png");
        ImageIcon imageRegister = new ImageIcon("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Hospital Manageme (Intellij)\\Resources\\icon_register.png");
        ImageIcon imageDiagnoses = new ImageIcon("icon_diag.png");
        ImageIcon imageAccess = new ImageIcon("icon_access.png");
        ImageIcon imageClose = new ImageIcon("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Hospital Manageme (Intellij)\\Resources\\icon_close.png");
        ImageIcon imageUpdate = new ImageIcon("icon_update.png");
        ImageIcon imageView = new ImageIcon("icon_view.png");
        ImageIcon imageDelete = new ImageIcon("icon_delete.png");
        ImageIcon imageDiagnosis = new ImageIcon("icon_diagnosis.png");

        Border border = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "NURSE'S DETAILS", TitledBorder.LEFT, TitledBorder.TOP);

        Border buttonBorder = BorderFactory.createEtchedBorder();

        JPanel panelN = new JPanel();
        panelN.setLayout(null);

        //--------------------- BUTTONS ------------------------
        JButton buttonReg = new JButton("Register Patient", imageRegister);
        JButton buttonViewDiagnoses = new JButton("View Diagnoses", imageDiagnoses);
        JButton buttonAccess = new JButton("Patient Records", imageAccess);
        JButton buttonClose = new JButton("Close", imageClose);

        JButton buttonView = new JButton("View Details", imageView);
        JButton buttonUpdate = new JButton("Update", imageUpdate);
        JButton buttonDelete = new JButton("Delete", imageDelete);
        JButton buttonDiagnosis = new JButton("Make Dr Appointment", imageDiagnosis);

        //---------------- TEXT ----------------------
        labelH.setText("Information / Registration Page");
        labelPanel.setText("Nurse's Details");

        labelH.setText("Nurse's Main Page");
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
        labelGenderN.setText("Gender: ");

        labelH.setFont(new Font("Fantasy", Font.ITALIC, 58));
        labelPanel.setFont(new Font("Comic Sans", Font.BOLD,48));

        labelH.setBounds(100,-40,1000,200);
        labelPanel.setBounds(150,10,600,100);

        //-------------------------- FONTS ----------------------------

        labelIDN.setFont(new Font("Arial", Font.BOLD, 16));     //Added
        labelNameN.setFont(new Font("Arial", Font.BOLD, 16));
        labelLastN.setFont(new Font("Arial", Font.BOLD, 16));
        labelUserN.setFont(new Font("Arial", Font.BOLD, 16));
        labelPassN.setFont(new Font("Arial", Font.BOLD, 16));
        labelEmailN.setFont(new Font("Arial", Font.BOLD, 16));
        labelPhoneN.setFont(new Font("Arial", Font.BOLD, 16));
        labelStreetN.setFont(new Font("Arial", Font.BOLD, 16));
        labelCityN.setFont(new Font("Arial", Font.BOLD, 16));
        labelPostalN.setFont(new Font("Arial", Font.BOLD, 16));
        labelDOBN.setFont(new Font("Arial", Font.BOLD, 16));
        labelGenderN.setFont(new Font("Arial", Font.BOLD, 16));

        textIDN.setFont(new Font("Arial", Font.PLAIN, 16));
        textNameN.setFont(new Font("Arial", Font.PLAIN, 16));
        textLastN.setFont(new Font("Arial", Font.PLAIN,16));
        textUserN.setFont(new Font("Arial", Font.PLAIN, 16));
        textPassN.setFont(new Font("Arial", Font.PLAIN, 16));
        textEmailN.setFont(new Font("Arial", Font.PLAIN, 16));

        textPhoneN.setFont(new Font("Arial", Font.PLAIN, 16));
        textStreetN.setFont(new Font("Arial", Font.PLAIN, 16));
        textCityN.setFont(new Font("Arial", Font.PLAIN,16));
        textPostalN.setFont(new Font("Arial", Font.PLAIN, 16));
        textDOBN.setFont(new Font("Arial", Font.PLAIN, 16));

        //---------------------- BOUNDS ---------------------------

        labelIDN.setBounds(20,120,95,200);      //Added
        labelNameN.setBounds(20,180,95,200);
        labelLastN.setBounds(20,240,95,200);
        labelUserN.setBounds(20,300,95,200);
        labelPassN.setBounds(20,360,95,200);
        labelEmailN.setBounds(20,420,95,200);

        textIDN.setBounds(120,210,250,25);        //Added
        textNameN.setBounds(120,270,250,25);
        textLastN.setBounds(120,330,250,25);
        textUserN.setBounds(120,390,250,25);
        textPassN.setBounds(120,450,250,25);
        textEmailN.setBounds(120,510,250,25);

        labelPhoneN.setBounds(410,120,125,200);
        labelStreetN.setBounds(410,180,125,200);
        labelCityN.setBounds(410,240,125,200);
        labelPostalN.setBounds(410,300,125,200);
        labelDOBN.setBounds(410,360,125,200);
        labelGenderN.setBounds(410,420,125,200);

        textPhoneN.setBounds(540,210,250,25);
        textStreetN.setBounds(540,270,250,25);
        textCityN.setBounds(540,330,250,25);
        textPostalN.setBounds(540,390,250,25);
        textDOBN.setBounds(540,450,150,25);

        comboGender.setBounds(540,510,150,25);

        comboGender.addItem("");
        comboGender.addItem("Male");
        comboGender.addItem("Female");

        labelH.setIconTextGap(70);
        labelH.setIcon(imageTitle);

        labelPanel.setIconTextGap(45);
        labelPanel.setIcon(imagePTitle);

        // --------------------- BUTTON FONT STYLING ------------------------
        buttonReg.setFont(new Font("Arial", Font.BOLD, 18));
        buttonViewDiagnoses.setFont(new Font("Arial", Font.BOLD, 16));
        buttonAccess.setFont(new Font("Arial", Font.BOLD, 16));
        buttonClose.setFont(new Font("Arial", Font.BOLD, 20));
        buttonUpdate.setFont(new Font("Arial", Font.BOLD, 16));
        buttonView.setFont(new Font("Arial", Font.BOLD, 18));
        buttonDelete.setFont(new Font("Arial", Font.BOLD,18));
        buttonDiagnosis.setFont(new Font("Arial", Font.BOLD,18));

        // ---------------------- BUTTON BOUNDS ------------------------
        buttonReg.setBounds(950,125,260,60);       //x is right to left, y is is up to down
        buttonDiagnosis.setBounds(950, 220,260,60);
        buttonViewDiagnoses.setBounds(950,320,260,60);
        buttonAccess.setBounds(950, 420,260,60);
        buttonClose.setBounds(950,520,260,60);

        buttonUpdate.setBounds(600,120,170,50);
        buttonView.setBounds(330, 120, 170,50);
        buttonDelete.setBounds(60,120,170,50);

        //------------------------- INSETS --------------------
        buttonViewDiagnoses.setMargin(new Insets(5,5,5,5));
        buttonAccess.setMargin(new Insets(5,5,5,5));
        buttonView.setMargin(new Insets(5,5,5,5));
        buttonUpdate.setMargin(new Insets(5,5,5,5));
        buttonDelete.setMargin(new Insets(5,5,5,5));

        buttonView.setBackground(new Color(209,234,197));
        buttonUpdate.setBackground(Color.GRAY);
        buttonDelete.setBackground(Color.GRAY);

        buttonUpdate.setForeground(Color.WHITE);
        buttonDelete.setForeground(Color.WHITE);

        //--------------- BUTTON'S EVENT ACTION LISTENERS ------------------
        buttonReg.addActionListener(this);
        buttonViewDiagnoses.addActionListener(this);
        buttonAccess.addActionListener(this);
        buttonClose.addActionListener(this);
        buttonUpdate.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonDiagnosis.addActionListener(this);

        //----------------- BUTTON BORDER'S -------------------------
        buttonReg.setBorder(buttonBorder);
        buttonViewDiagnoses.setBorder(buttonBorder);
        buttonAccess.setBorder(buttonBorder);
        buttonClose.setBorder(buttonBorder);
        buttonUpdate.setBorder(buttonBorder);
        buttonDelete.setBorder(buttonBorder);
        buttonDiagnosis.setBorder(buttonBorder);

        // ---------------- BUTTON FOCUSABLE -----------------
        buttonReg.setFocusable(false);
        buttonViewDiagnoses.setFocusable(false);
        buttonAccess.setFocusable(false);
        buttonClose.setFocusable(false);
        buttonView.setFocusable(false);
        buttonUpdate.setFocusable(false);
        buttonDelete.setFocusable(false);
        buttonDiagnosis.setFocusable(false);

        panelN.setBounds(110, 120,820,570); // Set Panel Bounds
        panelN.setBorder(border);

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

        frame.getContentPane().setBackground(new Color(209,234,197));

        //Screen Position
        frame.setLocationRelativeTo(null);

        panelN.add(labelPanel);
        panelN.add(labelIDN);
        panelN.add(labelNameN);
        panelN.add(labelLastN);
        panelN.add(labelUserN);
        panelN.add(labelPassN);
        panelN.add(labelEmailN);

        panelN.add(labelPhoneN);
        panelN.add(labelStreetN);
        panelN.add(labelCityN);
        panelN.add(labelPostalN);
        panelN.add(labelDOBN);
        panelN.add(labelGenderN);

        panelN.add(buttonUpdate);
        panelN.add(buttonView);
        panelN.add(buttonDelete);

        panelN.add(textIDN);
        panelN.add(textNameN);
        panelN.add(textLastN);
        panelN.add(textUserN);
        panelN.add(textPassN);
        panelN.add(textEmailN);

        panelN.add(textPhoneN);
        panelN.add(textStreetN);
        panelN.add(textCityN);
        panelN.add(textPostalN);
        panelN.add(textDOBN);
        panelN.add(comboGender);

        frame.add(labelH);
        frame.add(panelN);
        frame.add(buttonReg);
        frame.add(buttonViewDiagnoses);
        frame.add(buttonAccess);
        frame.add(buttonClose);
        frame.add(buttonDiagnosis);
        frame.setVisible(true);

        // Add an ActionListener to VIEW NURSES DETAILS JButton
        JFormattedTextField finalTextPhoneN = textPhoneN;
        JFormattedTextField finalTextPostalN = textPostalN;

        buttonView.addActionListener(new ActionListener() {
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
                String dob = textDOBN.getText();
                String gender = (String) comboGender.getSelectedItem();

                textIDN.requestFocus();
                textIDN.setBackground(new Color(209,234,197));
                textUserN.setBackground(new Color(209,234,197));

                try {

                    //Establish / Open Connection
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection

                    String query = "SELECT * FROM nurses_reg_table WHERE id_n_reg = ? AND username = ?";

                    PreparedStatement statement = connection.prepareStatement(query);

                    statement.setString(1, id_nurse);
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
                        String s11 = rs.getString(12);

                        // Set records into textfield

                        textIDN.setText(s);
                        textNameN.setText(s1);
                        textLastN.setText(s2);
                        textUserN.setText(s3);
                        textPassN.setText(s4);
                        textEmailN.setText(s5);
                        finalTextPhoneN.setText(s6);
                        textStreetN.setText(s7);
                        textCityN.setText(s8);
                        finalTextPostalN.setText(s9);
                        textDOBN.setText(s10);
                        comboGender.setSelectedItem(s11);
                        
                        textIDN.setEditable(false);
                        textIDN.setFocusable(false);
                        textIDN.setBackground(Color.WHITE);
                        textUserN.setBackground(Color.WHITE);

                        connection.close();

                    } else if(textIDN.getText().trim().isEmpty() && textUserN.getText().trim().isEmpty()) {

                        JOptionPane.showMessageDialog(null, "Please enter Nurse's ID and Username");
                    } else {
                        JOptionPane.showMessageDialog(null, "ID not Found / Register User");

                    }

                    connection.close();

                } catch (ClassNotFoundException | SQLException | HeadlessException e) {

                    System.err.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
            }
        });


        // Add an ActionListener to UPDATE NURSE'S DETAILS JButton
        JFormattedTextField finalTextPhoneN1 = textPhoneN;
        JFormattedTextField finalTextPostalN2 = textPostalN;
        JFormattedTextField finalTextPhoneN3 = textPhoneN;
        buttonUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                try {

                    String ID_NURSE = textIDN.getText();
                    String FNAME = textNameN.getText();
                    String LNAME = textLastN.getText();
                    String USERNAME = textUserN.getText();
                    String PASSWORD = textPassN.getText();
                    String EMAIL = textEmailN.getText();
                    String PHONE = finalTextPhoneN1.getText();
                    String STREET = textStreetN.getText();
                    String CITY = textCityN.getText();
                    String POSTAL = finalTextPostalN2.getText();
                    String DOB = textDOBN.getText();
                    String GENDER = (String) comboGender.getSelectedItem();


                    //Establish / Open Connection
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection

                    String query = "UPDATE nurses_reg_table SET " +
                            "fname ='" + FNAME + "', lname = '" + LNAME + "', username = '" + USERNAME + "', password= '" + PASSWORD + "', email = '"
                            + EMAIL + "', phone = '" + PHONE + "', street = '" + STREET + "', city = '" + CITY + "', postal = '" + POSTAL + "', dob = '"
                            + DOB + "', gender = '" + GENDER + "'" + " WHERE id_n_reg= '" + ID_NURSE + "'";

                    PreparedStatement statement = connection.prepareStatement(query);

                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "" + FNAME + " your data was successfully Updated!", "UPDATED!", JOptionPane.DEFAULT_OPTION);

                    textIDN.setBackground(Color.WHITE);
                    textUserN.setBackground(Color.WHITE);

                    connection.close();

                } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                    System.err.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
            }
        });

        // Add an ActionListener to DELETE USER JButton
        JFormattedTextField finalTextPhoneN2 = textPhoneN;
        JFormattedTextField finalTextPostalN1 = textPostalN;
        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {


                try {

                    //Establish / Open Connection
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection

                    String query = "DELETE FROM nurses_reg_table WHERE id_n_reg = ? ";

                    PreparedStatement statement = connection.prepareStatement(query);

                    statement.setString(1,textIDN.getText());

                    statement.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Deleted Successfully");

                    textIDN.setText("");
                    textNameN.setText("");
                    textLastN.setText("");
                    textUserN.setText("");
                    textPassN.setText("");
                    textEmailN.setText("");
                    finalTextPhoneN2.setText("");
                    textStreetN.setText("");
                    textCityN.setText("");
                    finalTextPostalN1.setText("");
                    textDOBN.setText("");
                    comboGender.setSelectedItem(0);

                    connection.close();

                } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                    System.err.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "System got an error" + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
            }
        });



        // Add an ActionListener to REGISTER NEW PATIENT JButton
        buttonReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if(event.getSource() == buttonReg) {
                    frame.dispose();
                    new RegistrationP();

                }
            }
        });

        // Add an ActionListener to ACCESS PATIENT RECORDS / DIAGNOSIS JButton
        buttonDiagnosis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if(event.getSource() == buttonDiagnosis) {
                    frame.dispose();
                    new Nurse_make_app();

                }
            }
        });


        // Add an ActionListener to ACCESS PATIENT HISTORY JButton
        buttonViewDiagnoses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if(event.getSource() == buttonViewDiagnoses) {
                    frame.dispose();
                    new Nurse_view_diagnoses();

                }
            }
        });

        // Add an ActionListener to ACCESS PATIENT RECORDS JButton
        buttonAccess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if(event.getSource() == buttonAccess) {
                    frame.dispose();
                    new Nurse_patient_records();

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
