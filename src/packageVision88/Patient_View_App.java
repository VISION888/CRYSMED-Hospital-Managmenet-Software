package packageVision88;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Patient_View_App extends JFrame implements ActionListener{


    JTextField textFieldSearch = new JTextField();                                      //ID view
    JTextField textFieldUsername = new JTextField();                                    //User view

    public Patient_View_App() {


        ImageIcon imageTitle = new ImageIcon("Resources/patient_icon.png");
        ImageIcon imageApp = new ImageIcon("Resources/icon_app.png");
        ImageIcon imageBack = new ImageIcon("Resources/icons_back.png");;
        ImageIcon imageExit = new ImageIcon("Resources/exit_icon.png");

        JButton buttonViewApp = new JButton("Appointments", imageApp);
        JButton buttonBack = new JButton("Go Back", imageBack);
        JButton buttonExit = new JButton("Exit", imageExit);

        Border borderPatient = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "PATIENT INFORMATION", TitledBorder.LEFT, TitledBorder.TOP);
        Border borderSymptoms = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "PATIENT SYMPTOMS", TitledBorder.LEFT, TitledBorder.TOP);
        Border borderSearch = BorderFactory.createEtchedBorder();
        Border borderEtched = BorderFactory.createRaisedBevelBorder();
        Border borderView = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        Border borderLine = BorderFactory.createLineBorder(Color.BLACK);

        JPanel panelS = new JPanel();
        JPanel panelSS = new JPanel();
        JPanel panelApp = new JPanel();
        panelS.setLayout(null);
        panelSS.setLayout(null);
        panelApp.setLayout(null);

        JTextArea areaSymp = new JTextArea();                                               //Initialize Text area
        panelS.add(areaSymp);                                                               //Add Component to panel

        JTextField Doctor = new JTextField();
        JFormattedTextField Date;
        JTextField Time = new JTextField();

        // Have a field to format a date in yyyy/mm/dd format
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DateFormatter dateFormatter = new DateFormatter(dateFormat);
        Date = new JFormattedTextField(dateFormatter);

        textFieldSearch.setBorder(borderLine);
        textFieldUsername.setBorder(borderLine);
        areaSymp.setBorder(borderView);
        Doctor.setBorder(borderView);
        Date.setBorder(borderView);
        Time.setBorder(borderView);

        JLabel labelSearch = new JLabel();
        JLabel labelUsername = new JLabel();

        JLabel labelDocter = new JLabel();
        JLabel labelDate = new JLabel();
        JLabel labelTime = new JLabel();

        buttonViewApp.setMargin(new Insets(0, 10, 0, 10));                    //Set button margin

        JLabel labelH = new JLabel();                                                        //Initialize Label

        labelH.setText("Patient Appointment");                                    //Set Header Text
        labelSearch.setText("Patient ID: ");
        labelUsername.setText("Patient Username: ");
        labelDocter.setText("Doctor: ");                                                  //Doctors label
        labelDate.setText("Appointment Date: ");                                         //App Date Label
        labelTime.setText("Appointment Time: ");                                        //App Time Label

        labelH.setFont(new Font("Comic Sans", Font.ITALIC, 58));                  //Header Font and Size
        labelSearch.setFont(new Font("Arial", Font.BOLD, 22));                  //Header Font and Size
        labelUsername.setFont(new Font("Arial", Font.BOLD, 22));                  //Header Font and Size
        labelDocter.setFont(new Font("Arial", Font.BOLD, 18));                    //Label Doctor
        labelDate.setFont(new Font("Arial", Font.BOLD, 18));                      //Label App Date
        labelTime.setFont(new Font("Arial", Font.BOLD, 18));                      //Label App time
        textFieldUsername.setFont(new Font("Arial", Font.BOLD, 20));
        areaSymp.setFont(new Font("Arial", Font.BOLD, 14));                      //Symptoms text area Font and Size
        textFieldSearch.setFont(new Font("Arial", Font.BOLD, 18));               //Search Patient ID text area Font and Size
        Doctor.setFont(new Font("Arial", Font.BOLD, 14));                       //Diagnoses text area Font and Size
        Date.setFont(new Font("Arial", Font.BOLD, 14));                         //App date text area Font and Size
        Time.setFont(new Font("Arial", Font.BOLD, 14));                         //App time text area Font and Size

        labelH.setBounds(60, -30, 1000, 200);                            //Set Header Bounds
        panelS.setBounds(50, 130, 780, 430);                             //Set Panel Bounds
        panelSS.setBounds(30, 50, 720, 60);
        panelApp.setBounds(30,240,460,160);

        labelSearch.setBounds(40, 70, 150, 25);
        labelUsername.setBounds(300,20, 200,25);

        areaSymp.setBounds(30, 140, 720, 80);                            //Set Text Area Bounds

        labelDocter.setBounds(15, 15, 250, 30);
        labelDate.setBounds(15, 60, 250, 30);                            //Label Date
        labelTime.setBounds(15, 110, 250, 30);                           //Label Time

        Doctor.setBounds(110,18,320,25);
        Date.setBounds(200, 63,225,25);
        Time.setBounds(200,113,225,25);

        textFieldSearch.setBounds(120, 15, 150, 30);
        textFieldUsername.setBounds(500,13,200, 30);

        panelS.setBorder(borderPatient);
        panelSS.setBorder(borderSearch);
        panelApp.setBorder(borderEtched);
        areaSymp.setBorder(borderSymptoms);

        labelH.setIconTextGap(30);
        labelH.setIcon(imageTitle);

        buttonViewApp.setFont(new Font("Arial", Font.BOLD, 16));
        buttonBack.setFont(new Font("Arial", Font.BOLD, 20));
        buttonExit.setFont(new Font("Arial", Font.BOLD, 16));

        buttonViewApp.setBounds(850, 130, 200, 100);
        buttonBack.setBounds(850, 290, 200, 100);
        buttonExit.setBounds(850, 455, 200, 100);

        buttonViewApp.setMargin(new Insets(5, 5, 5, 5));                    //Set button margin
        buttonBack.setMargin(new Insets(5, 5, 5, 5));                    //Set button margin
        buttonExit.setMargin(new Insets(5, 5, 5, 5));                    //Set button margin

        buttonViewApp.setFocusable(false);
        buttonBack.setFocusable(false);
        buttonExit.setFocusable(false);

        buttonViewApp.addActionListener(this);
        buttonBack.addActionListener(this);
        buttonExit.addActionListener(this);

        textFieldSearch.setEditable(false);
        textFieldUsername.setEditable(false);
        pApp();

        areaSymp.setEditable(false);
        Doctor.setEditable(false);
        Date.setEditable(false);
        Time.setEditable(false);

        JFrame frame = new JFrame();

        // Set the default close behavior to exit the application
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setDefaultLookAndFeelDecorated(true);
        frame.setTitle("Hospital Management Program");
        frame.setIconImage(new ImageIcon("Resources/icon_hs.png").getImage());
        frame.setLayout(null);

        // Set the x, y, width and height properties in one go
        frame.setSize(1100, 700);
        frame.setResizable(false);

        frame.getContentPane().setBackground(new Color(51, 80, 109));
        panelS.setBackground(new Color(119, 191, 206));
        labelH.setForeground(Color.white);

        //Screen Position
        frame.setLocationRelativeTo(null);

        panelApp.add(Doctor);                                                          //Add components to panel
        panelSS.add(labelSearch);
        panelSS.add(labelUsername);
        panelSS.add(textFieldSearch);                                                //Inner Panel and components
        panelSS.add(textFieldUsername);
        panelS.add(panelApp);
        panelS.add(labelSearch);
        panelApp.add(labelDocter);
        panelApp.add(labelDate);
        panelApp.add(labelTime);
        panelApp.add(Date);
        panelApp.add(Time);
        panelS.add(panelSS);
        frame.add(panelS);
        frame.add(buttonViewApp);
        frame.add(buttonBack);
        frame.add(buttonExit);
        frame.add(labelH);
        frame.setVisible(true);


        // Add an ActionListener to SEARCH JButton
        buttonViewApp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {


                try {

                    //Open Connection
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection

                    PreparedStatement stm = connection.prepareStatement("SELECT patient_reg_table.id_p, patient_reg_table.usernamep, patient_records_table.p_symptoms, patient_records_table.p_doctor, patient_records_table.p_date, patient_records_table.p_time FROM patient_reg_table INNER JOIN patient_records_table ON patient_reg_table.id_p = patient_records_table.id_pr WHERE patient_reg_table.id_p = ? AND patient_reg_table.usernamep =  ?");

                    stm.setString(1, textFieldSearch.getText());
                    stm.setString(2, textFieldUsername.getText());

                    ResultSet rs = stm.executeQuery();

                    if (rs.next()) {

                        String s1 = rs.getString("p_symptoms");
                        areaSymp.setText(s1);

                        String s2 = rs.getString("p_doctor");
                        Doctor.setText(s2);

                        String s3 = rs.getString("p_date");
                        Date.setText(s3);

                        String s4 = rs.getString("p_time");
                        Time.setText(s4);

                        textFieldSearch.setEditable(false);
                        textFieldSearch.setBackground(new Color(119, 191, 206));
                        textFieldSearch.setForeground(Color.WHITE);

                        textFieldUsername.setEditable(false);
                        textFieldUsername.setBackground(new Color(119, 191, 206));
                        textFieldUsername.setForeground(Color.WHITE);
                        textFieldUsername.setFocusable(false);

                        areaSymp.setEditable(false);
                        areaSymp.setBackground(Color.LIGHT_GRAY);

                        Doctor.setEditable(false);

                        Date.setEditable(false);

                        Time.setEditable(false);

                        connection.close();

                    } else if(textFieldSearch.getText().trim().isEmpty() && textFieldUsername.getText().trim().isEmpty()) {

                        JOptionPane.showMessageDialog(null, "Please enter your Patient ID and Username and press Appointment Button!", "ERROR", JOptionPane.DEFAULT_OPTION);

                    }

                    connection.close();

                } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                    System.err.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
            }
        });


        // Add an ActionListener to CLOSE JButton
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if (event.getSource() == buttonBack) {
                    frame.dispose();
                    new MainPatient();

                }
            }
        });

        // Add an ActionListener to the Exit JButton
        buttonExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                // Exit Button
                int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Select", JOptionPane.YES_NO_OPTION);

                if (exit == 0) System.exit(0);
            }
        });
    }

    public void pApp() {

        String id = textFieldSearch.getText();
        String user = textFieldUsername.getText();

        textFieldSearch.setEditable(true);
        textFieldUsername.setEditable(true);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection

            String sql = "SELECT  id_p, usernamep FROM patient_reg_table WHERE id_p = '"+ id +"' AND usernamep = '" + user + "' ";
            PreparedStatement stm = connection.prepareStatement(sql);


            ResultSet rs = stm.executeQuery();

            while(rs.next()) {

                String s1 = rs.getString("id_p");
                textFieldSearch.setText(s1);

                String s2 = rs.getString("usernamep");
                textFieldUsername.setText(s2);

            }

        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }

}
