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

public class MainPatient extends JFrame implements ActionListener {


    public MainPatient() {
        
            ImageIcon imageTitle = new ImageIcon("Resources/patient_icon.png");
            ImageIcon imagePTitle = new ImageIcon("Resources/patient_icon.png");
            ImageIcon imageViewapp = new ImageIcon("Resources/icon_viewApp.png");
            ImageIcon imageClose = new ImageIcon("C:\\Users\\Conquela\\Desktop\\Richfield University\\3 Year\\Hospital Manageme (Intellij)\\Resources\\icon_close.png");
            ImageIcon imageUpdate = new ImageIcon("Resources/icon_update.png");
            ImageIcon imageView = new ImageIcon("Resources/icon_view.png");
            ImageIcon imageDelete = new ImageIcon("Resources/icon_delete.png");

            Border border = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "PATIENT'S DETAILS", TitledBorder.LEFT, TitledBorder.TOP);

            Border buttonBorder = BorderFactory.createEtchedBorder();

            JLabel labelP = new JLabel();
            JLabel labelPanel = new JLabel();

            JLabel labelIDP= new JLabel();
            JLabel labelNameP = new JLabel();
            JLabel labelLastP = new JLabel();
            JLabel labelUserP = new JLabel();
            JLabel labelPassP = new JLabel();
            JLabel labelEmailP = new JLabel();
            JLabel labelPhoneP = new JLabel();
            JLabel labelStreetP = new JLabel();
            JLabel  labelCityP = new JLabel();
            JLabel labelPostalP = new JLabel();
            JLabel labelDOBP= new JLabel();
            JLabel labelGenderP = new JLabel();

            TextField textIDP = new TextField();
            TextField textNameP = new TextField();
            TextField textLastP = new TextField();
            TextField textUserP = new TextField();
            TextField textPassP = new TextField();
            TextField textEmailP = new TextField();
            TextField textStreetP = new TextField();
            TextField textCityC = new TextField();
            JFormattedTextField textDOBP;

        // Have a field to format a date in yyyy/mm/dd format
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DateFormatter dateFormatter = new DateFormatter(dateFormat);
        textDOBP = new JFormattedTextField(dateFormatter);

        // Mask for phone spacing
        JFormattedTextField textPhoneP = null;
        try {
            MaskFormatter phonep = new MaskFormatter("### ### ####");
            textPhoneP = new JFormattedTextField(phonep);
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

            JComboBox comboGender = new JComboBox();
            
            JPanel panelP = new JPanel();
            panelP.setLayout(null);

            //--------------------- BUTTONS ------------------------
            JButton buttonViewApp = new JButton("View Appointments", imageViewapp);
            JButton buttonHistory = new JButton("View medical History", imageView);
            JButton buttonClose = new JButton("Close", imageClose);
            
            JButton buttonView = new JButton("View Details", imageView);
            JButton buttonUpdate = new JButton("Update", imageUpdate);
            JButton buttonDelete = new JButton("Delete", imageDelete);

            //---------------- TEXT ----------------------
            labelP.setText("Patient Main Page");
            labelPanel.setText("Patient Details");

            labelP.setText("Patient's Main Page");
            labelIDP.setText("Patient ID: ");
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
            labelGenderP.setText("Gender: ");

            labelP.setFont(new Font("Fantasy", Font.ITALIC, 58));
            labelPanel.setFont(new Font("Comic Sans", Font.BOLD,48));

            labelP.setBounds(100,-40,1000,200);
            labelPanel.setBounds(150,10,600,100);

            //-------------------------- FONTS ----------------------------

            labelIDP.setFont(new Font("Arial", Font.BOLD, 16));     //Added
            labelNameP.setFont(new Font("Arial", Font.BOLD, 16));
            labelLastP.setFont(new Font("Arial", Font.BOLD, 16));
            labelUserP.setFont(new Font("Arial", Font.BOLD, 16));
            labelPassP.setFont(new Font("Arial", Font.BOLD, 16));
            labelEmailP.setFont(new Font("Arial", Font.BOLD, 16));
            labelPhoneP.setFont(new Font("Arial", Font.BOLD, 16));
            labelStreetP.setFont(new Font("Arial", Font.BOLD, 16));
            labelCityP.setFont(new Font("Arial", Font.BOLD, 16));
            labelPostalP.setFont(new Font("Arial", Font.BOLD, 16));
            labelDOBP.setFont(new Font("Arial", Font.BOLD, 16));
            labelGenderP.setFont(new Font("Arial", Font.BOLD, 16));

            textIDP.setFont(new Font("Arial", Font.PLAIN, 16));
            textNameP.setFont(new Font("Arial", Font.PLAIN, 16));
            textLastP.setFont(new Font("Arial", Font.PLAIN,16));
            textUserP.setFont(new Font("Arial", Font.PLAIN, 16));
            textPassP.setFont(new Font("Arial", Font.PLAIN, 16));
            textEmailP.setFont(new Font("Arial", Font.PLAIN, 16));

            textPhoneP.setFont(new Font("Arial", Font.PLAIN, 16));
            textStreetP.setFont(new Font("Arial", Font.PLAIN, 16));
            textCityC.setFont(new Font("Arial", Font.PLAIN,16));
            textPostalP.setFont(new Font("Arial", Font.PLAIN, 16));
            textDOBP.setFont(new Font("Arial", Font.PLAIN, 16));

            //---------------------- BOUNDS ---------------------------

            labelIDP.setBounds(20,120,95,200);      //Added
            labelNameP.setBounds(20,180,95,200);
            labelLastP.setBounds(20,240,95,200);
            labelUserP.setBounds(20,300,95,200);
            labelPassP.setBounds(20,360,95,200);
            labelEmailP.setBounds(20,420,95,200);

            textIDP.setBounds(120,210,250,25);        //Added
            textNameP.setBounds(120,270,250,25);
            textLastP.setBounds(120,330,250,25);
            textUserP.setBounds(120,390,250,25);
            textPassP.setBounds(120,450,250,25);
            textEmailP.setBounds(120,510,250,25);

            labelPhoneP.setBounds(410,120,125,200);
            labelStreetP.setBounds(410,180,125,200);
            labelCityP.setBounds(410,240,125,200);
            labelPostalP.setBounds(410,300,125,200);
            labelDOBP.setBounds(410,360,125,200);
            labelGenderP.setBounds(410,420,125,200);

            textPhoneP.setBounds(540,210,250,25);
            textStreetP.setBounds(540,270,250,25);
            textCityC.setBounds(540,330,250,25);
            textPostalP.setBounds(540,390,250,25);
            textDOBP.setBounds(540,450,150,25);

            comboGender.setBounds(540,510,150,25);

            comboGender.addItem("");
            comboGender.addItem("Male");
            comboGender.addItem("Female");

            labelP.setIconTextGap(70);
            labelP.setIcon(imageTitle);

            labelPanel.setIconTextGap(45);
            labelPanel.setIcon(imagePTitle);

            // --------------------- BUTTON FONT STYLING ------------------------
            buttonViewApp.setFont(new Font("Arial", Font.BOLD, 18));
            buttonHistory.setFont(new Font("Arial", Font.BOLD, 16));
            buttonClose.setFont(new Font("Arial", Font.BOLD, 20));

            buttonUpdate.setFont(new Font("Arial", Font.BOLD, 16));
            buttonView.setFont(new Font("Arial", Font.BOLD, 18));
            buttonDelete.setFont(new Font("Arial", Font.BOLD,18));

            // ---------------------- BUTTON BOUNDS ------------------------
            buttonViewApp.setBounds(950,130,250,120);       //x is right to left, y is is up to down
            buttonHistory.setBounds(950,320,250,120);
            buttonClose.setBounds(950,510,250,120);

            buttonUpdate.setBounds(600,120,170,50);
            buttonView.setBounds(330, 120, 170,50);
            buttonDelete.setBounds(60,120,170,50);

            //------------------------- INSETS --------------------
            buttonHistory.setMargin(new Insets(5,5,5,5));
            buttonView.setMargin(new Insets(5,5,5,5));
            buttonUpdate.setMargin(new Insets(5,5,5,5));
            buttonDelete.setMargin(new Insets(5,5,5,5));

            buttonView.setBackground(new Color(255, 225, 214));
            buttonUpdate.setBackground(Color.GRAY);
            buttonDelete.setBackground(Color.GRAY);

            textUserP.setFocusable(true);
            textIDP.setFocusable(false);
            textUserP.setBackground(new Color(255, 225, 214));
            textPassP.setBackground(new Color(255, 225, 214));

            buttonUpdate.setForeground(Color.WHITE);
            buttonDelete.setForeground(Color.WHITE);

            //--------------- BUTTON'S EVENT ACTION LISTENERS ------------------
            buttonViewApp.addActionListener(this);
            buttonHistory.addActionListener(this);
            buttonClose.addActionListener(this);
            buttonUpdate.addActionListener(this);
            buttonDelete.addActionListener(this);

            //----------------- BUTTON BORDER'S -------------------------
            buttonViewApp.setBorder(buttonBorder);
            buttonHistory.setBorder(buttonBorder);
            buttonClose.setBorder(buttonBorder);
            buttonUpdate.setBorder(buttonBorder);
            buttonDelete.setBorder(buttonBorder);

            // ---------------- BUTTON FOCUSABLE -----------------
            buttonViewApp.setFocusable(false);
            buttonHistory.setFocusable(false);
            buttonClose.setFocusable(false);
            buttonView.setFocusable(false);
            buttonUpdate.setFocusable(false);
            buttonDelete.setFocusable(false);

            panelP.setBounds(110, 120,820,570); // Set Panel Bounds
            panelP.setBorder(border);

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

            frame.getContentPane().setBackground(new Color(255, 225, 214));

            //Screen Position
            frame.setLocationRelativeTo(null);

            panelP.add(labelPanel);
            panelP.add(labelIDP);
            panelP.add(labelNameP);
            panelP.add(labelLastP);
            panelP.add(labelUserP);
            panelP.add(labelPassP);
            panelP.add(labelEmailP);

            panelP.add(labelPhoneP);
            panelP.add(labelStreetP);
            panelP.add( labelCityP);
            panelP.add(labelPostalP);
            panelP.add(labelDOBP);
            panelP.add(labelGenderP);

            panelP.add(buttonUpdate);
            panelP.add(buttonView);
            panelP.add(buttonDelete);

            panelP.add(textIDP);
            panelP.add(textNameP);
            panelP.add(textLastP);
            panelP.add(textUserP);
            panelP.add(textPassP);
            panelP.add(textEmailP);

            panelP.add(textPhoneP);
            panelP.add(textStreetP);
            panelP.add(textCityC);
            panelP.add(textPostalP);
            panelP.add(textDOBP);
            panelP.add(comboGender);

            frame.add(labelP);
            frame.add(panelP);
            frame.add(buttonViewApp);
            frame.add(buttonHistory);
            frame.add(buttonClose);
            frame.setVisible(true);

            // Add an ActionListener to VIEW PATIENT DETAILS JButton
        JFormattedTextField finalTextPhoneP = textPhoneP;
        JFormattedTextField finalTextPostalP = textPostalP;

        buttonView.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {

                    String username = textUserP.getText();
                    String password = textPassP.getText();

                    textIDP.setFocusable(false);
                    textUserP.requestFocus();
                    textUserP.setBackground(new Color(255, 225, 214));
                    textPassP.setBackground(new Color(255, 225, 214));


                    try {

                        //Establish / Open Connection
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection

                        String query = "SELECT * FROM patient_reg_table WHERE usernamep = ? AND passwordp = ?";

                        PreparedStatement statement = connection.prepareStatement(query);

                        statement.setString(1, username);
                        statement.setString(2, password);

                        //Executing Query
                        ResultSet rs = statement.executeQuery();

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

                            textIDP.setText(s);
                            textNameP.setText(s1);
                            textLastP.setText(s2);
                            textUserP.setText(s3);
                            textPassP.setText(s4);
                            textEmailP.setText(s5);
                            finalTextPhoneP.setText(s6);
                            textStreetP.setText(s7);
                            textCityC.setText(s8);
                            finalTextPostalP.setText(s9);
                            textDOBP.setText(s10);
                            comboGender.setSelectedItem(s11);

                            textIDP.setEditable(false);
                            textUserP.setFocusable(false);
                            textUserP.setBackground(Color.WHITE);
                            textPassP.setBackground(Color.WHITE);

                            connection.close();

                        } else if(textUserP.getText().trim().isEmpty() && textPassP.getText().trim().isEmpty()) {

                            JOptionPane.showMessageDialog(null, "Please enter Username and Password");
                        } else {
                            JOptionPane.showMessageDialog(null, "User not Found / Register User");
                        }


                    } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                        System.err.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                    }
                }
            });


            // Add an ActionListener to UPDATE PATIENT DETAILS JButton
        JFormattedTextField finalTextPostalP1 = textPostalP;
        JFormattedTextField finalTextPhoneP1 = textPhoneP;

        buttonUpdate.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {

                    try {

                        String ID_P = textIDP.getText();
                        String FNAME = textNameP.getText();
                        String LNAME = textLastP.getText();
                        String USERNAME = textUserP.getText();
                        String PASSWORD = textPassP.getText();
                        String EMAIL = textEmailP.getText();
                        String PHONE = finalTextPhoneP1.getText();
                        String STREET = textStreetP.getText();
                        String CITY = textCityC.getText();
                        String POSTAL = finalTextPostalP1.getText();
                        String DOB = textDOBP.getText();
                        String GENDER = (String) comboGender.getSelectedItem();

                        //Establish / Open Connection
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection

                        String query = "UPDATE patient_reg_table SET " +
                                "fnamep ='" + FNAME + "', lnamep = '" + LNAME + "', usernamep = '" + USERNAME + "', passwordp = '" + PASSWORD + "', emailp = '"
                                + EMAIL + "', phonep = '" + PHONE + "', streetp = '" + STREET + "', cityp = '" + CITY + "', postalp = '" + POSTAL + "', dobp = '"
                                + DOB + "', genderp = '" + GENDER + "'" + " WHERE id_p= '" + ID_P + "'";

                        PreparedStatement statement = connection.prepareStatement(query);

                        statement.executeUpdate();
                        JOptionPane.showMessageDialog(null, "" + FNAME + " your data was successfully Updated!", "UPDATED!", JOptionPane.DEFAULT_OPTION);

                        textUserP.setBackground(Color.WHITE);
                        textPassP.setBackground(Color.WHITE);

                        connection.close();

                    } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                        System.err.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                    }
                }
            });

            // Add an ActionListener to DELETE USER JButton
        JFormattedTextField finalTextPhoneP2 = textPhoneP;
        JFormattedTextField finalTextPostalP2 = textPostalP;

        buttonDelete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {


                    try {

                        //Establish / Open Connection
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection

                        String query = "DELETE FROM patient_reg_table WHERE id_p = ? ";

                        PreparedStatement statement = connection.prepareStatement(query);

                        statement.setString(1,textIDP.getText());

                        statement.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Deleted Successfully");

                        textIDP.setText("");
                        textNameP.setText("");
                        textLastP.setText("");
                        textUserP.setText("");
                        textPassP.setText("");
                        textEmailP.setText("");
                        finalTextPhoneP2.setText("");
                        textStreetP.setText("");
                        textCityC.setText("");
                        finalTextPostalP2.setText("");
                        textDOBP.setText("");
                        comboGender.setSelectedItem(0);

                        connection.close();

                    } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                        System.err.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
                    }
                }
            });


            // Add an ActionListener to VIEW PATIENT APPOINTMENTS JButton
            buttonViewApp.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {

                    if(event.getSource() == buttonViewApp) {
                        frame.dispose();
                        new Patient_View_App();

                    }
                }
            });

            // Add an ActionListener to ACCESS PATIENT RECORDS JButton
            buttonHistory.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {

                    if(event.getSource() == buttonHistory) {
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
