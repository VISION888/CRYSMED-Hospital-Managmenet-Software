package packageVision88;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Doctor_diagnoses extends JFrame implements ActionListener {

    int flag = 0;
    JFrame frame = new JFrame();
    JTextArea areaSymp = new JTextArea();                                               //Initialize Text area
    JTextField textFieldDoctor = new JTextField();
    JTextField textFieldTime = new JTextField();
    JTextField textFieldDiagnoses = new JTextField();
    JTextField textFieldSearch = new JTextField();
    JTextField textFieldMeds = new JTextField();                                        //Text mEDS

    // Have a field to format a date in yyyy/mm/dd format
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    DateFormatter dateFormatter = new DateFormatter(dateFormat);
    JFormattedTextField textFieldDate = new JFormattedTextField(dateFormatter);

    public Doctor_diagnoses() {

        ImageIcon imageTitle = new ImageIcon("Resources/patient_icon.png");
        ImageIcon imageApp = new ImageIcon("Resources/icon_app.png");
        ImageIcon imageBack = new ImageIcon("Resources/icons_back.png");
        ImageIcon imageSearch = new ImageIcon("Resources/icon_search_24.png");
        ImageIcon imageExit = new ImageIcon("Resources/exit_icon.png");
        ImageIcon imageRefresh = new ImageIcon("Resources/icon_refresh.png");

        JButton buttonSave = new JButton("Save Information", imageApp);
        JButton buttonBack = new JButton("Go Back", imageBack);
        JButton buttonSearch = new JButton("Search", imageSearch);
        JButton buttonExit = new JButton("Exit", imageExit);
        JButton buttonRefresh = new JButton("Next Patient", imageRefresh);

        Border borderPatient = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "PATIENT INFORMATION", TitledBorder.LEFT, TitledBorder.TOP);
        Border borderSymptoms = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "PATIENT SYMPTOMS", TitledBorder.LEFT, TitledBorder.TOP);
        Border borderSearch = BorderFactory.createEtchedBorder();
        JLabel label = new JLabel("Patient does not exist!");

        JPanel panelS = new JPanel();
        JPanel panelSS = new JPanel();
        panelS.setLayout(null);
        panelSS.setLayout(null);

        panelS.add(areaSymp);                                                               //Add Component to panel

        final String[] columHeads = {"ID", "First name", "Last Name", "Email", "Phone", "Street", "City", "Postal", "Date of Birth", "Gender"};
        Object[][] data = {{"", "", "", "", "", "", "", "", "", ""}};

        JTable tablep = new JTable(data, columHeads) {
            public boolean isCellEditable(int data, int columHeads) {
                return false;
            }
        };

        tablep.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        tablep.setPreferredScrollableViewportSize(new Dimension(820, 60));
        tablep.setFillsViewportHeight(true);

        //SCROLLPANE

        JScrollPane jsp = new JScrollPane(tablep);
        jsp.setBounds(20, 130, 820, 60);
        panelS.add(jsp, BorderLayout.CENTER);


        JLabel labelSearch = new JLabel();
        JLabel labelDiagnoses = new JLabel();
        JLabel labelDocter = new JLabel();
        JLabel labelDate = new JLabel();
        JLabel labelTime = new JLabel();
        JLabel labelMeds = new JLabel();

        buttonSave.setMargin(new Insets(0, 10, 0, 10));                    //Set button margin

        JLabel labelH = new JLabel();                                                        //Initialize Label

        labelH.setText("Patient medical diagnoses");                                    //Set Header Text
        labelSearch.setText("Patient ID: ");
        labelDiagnoses.setText("Patient Diagnoses: ");                                      //Diagnoses Label
        labelDocter.setText("Doctor: ");                                                  //Doctors label
        labelDate.setText("Appointment Date: ");                                         //App Date Label
        labelTime.setText("Appointment Time: ");                                        //App Time Label
        labelMeds.setText("Medication: ");                                             //Medication Label

        labelH.setFont(new Font("Comic Sans", Font.ITALIC, 58));                  //Header Font and Size
        labelSearch.setFont(new Font("Arial", Font.BOLD, 22));                  //Header Font and Size
        labelDiagnoses.setFont(new Font("Arial", Font.BOLD, 18));                  //Label Diagnoses
        labelDocter.setFont(new Font("Arial", Font.BOLD, 22));                    //Label Doctor
        labelDate.setFont(new Font("Arial", Font.BOLD, 18));                      //Label App Date
        labelTime.setFont(new Font("Arial", Font.BOLD, 18));                      //Label App time
        labelMeds.setFont(new Font("Arial", Font.BOLD, 22));                      //Label Medication
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.red);
        areaSymp.setFont(new Font("Arial", Font.PLAIN, 16));                      //Symptoms text area Font and Size
        textFieldSearch.setFont(new Font("Arial", Font.BOLD, 18));               //Search Patient ID text area Font and Size
        textFieldDiagnoses.setFont(new Font("Arial", Font.PLAIN, 14));            //Diagnoses text area Font and Size
        textFieldDoctor.setFont(new Font("Arial", Font.PLAIN, 14));
        textFieldDate.setFont(new Font("Arial", Font.PLAIN, 14));                 //App date text area Font and Size
        textFieldTime.setFont(new Font("Arial", Font.PLAIN, 14));                 //App time text area Font and Size
        textFieldMeds.setFont(new Font("Arial", Font.PLAIN, 14));                 //Medication text area Font and Size

        tablep.setFont(new Font("Arial", Font.PLAIN, 12));
        tablep.setFont(new Font("Arial", Font.PLAIN, 12));

        labelH.setBounds(100, -30, 1000, 200);                                //Set Header Bounds
        panelS.setBounds(50, 130, 900, 550);                                  //Set Panel Bounds
        panelSS.setBounds(200, 20, 500, 60);
        label.setBounds(350, 85, 250, 30);
        panelSS.setBorder(borderSearch);

        labelSearch.setBounds(210, 37, 150, 25);

        areaSymp.setBounds(20, 200, 820, 80);                                 //Set Text Area Bounds
        labelDocter.setBounds(20, 300, 250, 30);
        labelDiagnoses.setBounds(20, 360, 250, 30);                          // Label Diagnoses
        labelDate.setBounds(20, 430, 250, 30);                              //Label Date
        labelTime.setBounds(400, 430, 250, 30);                              //Label Time
        labelMeds.setBounds(20, 500, 250, 30);                              //Label Medication

        textFieldSearch.setBounds(130, 13, 200, 30);
        tablep.setBounds(20, 130, 820, 30);                                 //JTable

        textFieldDoctor.setBounds(200, 300, 300, 25);
        textFieldDiagnoses.setBounds(200, 360, 560, 25);
        textFieldDate.setBounds(200, 430, 180, 25);
        textFieldTime.setBounds(580, 430, 180, 25);
        textFieldMeds.setBounds(200, 500, 560, 25);

        panelS.setBorder(borderPatient);
        areaSymp.setBorder(borderSymptoms);

        labelH.setIconTextGap(70);
        labelH.setIcon(imageTitle);

        buttonSave.setFont(new Font("Arial", Font.BOLD, 16));
        buttonBack.setFont(new Font("Arial", Font.BOLD, 20));
        buttonSearch.setFont(new Font("Arial", Font.BOLD, 16));
        buttonRefresh.setFont(new Font("Arial", Font.BOLD,16));
        buttonExit.setFont(new Font("Arial", Font.BOLD, 16));

        buttonSearch.setBounds(360, 10, 120, 40);
        buttonRefresh.setBounds(720,30,150,40);
        buttonSave.setBounds(980, 130, 230, 120);
        buttonBack.setBounds(980, 300, 230, 120);
        buttonExit.setBounds(980, 480, 230, 120);

        buttonSave.setFocusable(false);
        buttonBack.setFocusable(false);
        buttonExit.setFocusable(false);
        buttonRefresh.setFocusable(false);

        buttonSearch.addActionListener(this);
        buttonRefresh.addActionListener(this);
        buttonSave.addActionListener(this);
        buttonBack.addActionListener(this);
        buttonExit.addActionListener(this);

        label.setVisible(false);

        // Set the default close behavior to exit the application
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setDefaultLookAndFeelDecorated(true);
        frame.setTitle("Hospital Management Program");
        frame.setIconImage(new ImageIcon("Resources/icon_hs.png").getImage());
        frame.setLayout(null);

        // Set the x, y, width and height properties in one go
        frame.setSize(1250, 750);
        frame.setResizable(false);

        frame.getContentPane().setBackground(new Color(209, 234, 197));

        //Screen Position
        frame.setLocationRelativeTo(null);

        panelS.add(textFieldDiagnoses);                                                          //Add components to panel
        panelSS.add(labelSearch);
        panelSS.add(textFieldSearch);                                                            //Inner Panel and components
        panelSS.add(buttonSearch);
        panelS.add(labelSearch);
        panelS.add(buttonRefresh);
        panelS.add(labelDiagnoses);
        panelS.add(textFieldDiagnoses);
        panelS.add(labelDocter);
        panelS.add(labelDate);
        panelS.add(labelTime);
        panelS.add(labelMeds);
        panelS.add(textFieldDate);
        panelS.add(textFieldTime);
        panelS.add(textFieldMeds);
        panelS.add(textFieldDoctor);
        panelS.add(panelSS);
        panelS.add(label);
        frame.add(panelS);
        frame.add(buttonSave);
        frame.add(buttonBack);
        frame.add(buttonExit);
        frame.add(labelH);
        frame.setVisible(true);

        // Add an ActionListener to SEARCH JButton
        buttonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String id_record = textFieldSearch.getText();

                try {

                    //Open Connection
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection

                    Statement stm = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                    String query = "SELECT id_p, fnamep, lnamep, emailp, phonep, streetp, cityp, postalp, dobp, genderp FROM patient_reg_table WHERE id_p = '" + id_record + "'";

                    ResultSet rs = stm.executeQuery(query);

                    tablep.setModel(DbUtils.resultSetToTableModel(rs));

                    tablep.getColumn("id_p").setHeaderValue("ID");
                    tablep.getColumn("fnamep").setHeaderValue("First Name");
                    tablep.getColumn("lnamep").setHeaderValue("Last Name");
                    tablep.getColumn("emailp").setHeaderValue("Email");
                    tablep.getColumn("phonep").setHeaderValue("Phone");
                    tablep.getColumn("streetp").setHeaderValue("Street");
                    tablep.getColumn("cityp").setHeaderValue("City");
                    tablep.getColumn("postalp").setHeaderValue("Postal");
                    tablep.getColumn("dobp").setHeaderValue("Date-of-Birth");
                    tablep.getColumn("genderp").setHeaderValue("Gender");

                    tablep.repaint();

                    if (!rs.first()) {
                        label.setVisible(true);


                    } else {

                        label.setVisible(false);
                        JtextFieldMethod();
                        textFieldSearch.setEditable(false);
                        textFieldSearch.setBackground(Color.LIGHT_GRAY);

                        flag = 1;

                    }
                    connection.close();

                } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                    System.err.println(e.getMessage());
                    JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                }
            }
        });


        // Add an ActionListener to SAVE JButton
        buttonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if (flag == 1) {

                    String id_record = textFieldSearch.getText();
                    String p_symptoms = areaSymp.getText();
                    String p_diagnoses = textFieldDiagnoses.getText();
                    String p_medication = textFieldMeds.getText();

                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection

                        Statement stm = connection.createStatement();

                        //Add records
                        String query = "UPDATE patient_records_table SET " + " p_symptoms = '" + p_symptoms + "', p_diagnoses= '" + p_diagnoses + "'," +
                                "  p_medication = '" + p_medication + "' WHERE id_pr ='" + id_record + "'";

                        stm.executeUpdate(query);

                        JOptionPane.showMessageDialog(null, "Diagnoses Updated ", "SUCCESS", JOptionPane.DEFAULT_OPTION);

                        connection.close();

                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                    }
                }
            }
        });

        //Add an ActionListener to refresh JButton
        buttonRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == buttonRefresh) {
                    frame.dispose();
                    new Doctor_diagnoses();

                }
            }
        });

            // Add an ActionListener to CLOSE JButton
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if (event.getSource() == buttonBack) {
                    frame.dispose();
                    new MainDoctor();

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

    private void JtextFieldMethod() {

            String id_record = textFieldSearch.getText();


            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection

                String sql = "SELECT id_pr, p_symptoms, p_doctor, p_date, p_time FROM patient_records_table  WHERE id_pr = '" + id_record + "'";
                PreparedStatement stm = connection.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();

                while (rs.next()) {

                    String s1 = rs.getString("p_symptoms");
                    areaSymp.setText(s1);

                    String s2 = rs.getString("p_doctor");
                    textFieldDoctor.setText(s2);

                    String s3 = rs.getString("p_date");
                    textFieldDate.setText(s3);

                    String s4 = rs.getString("p_time");
                    textFieldTime.setText(s4);

                    textFieldDoctor.setEditable(false);
                    textFieldDate.setEditable(false);
                    textFieldTime.setEditable(false);

                    textFieldDoctor.setBackground(Color.LIGHT_GRAY);
                    textFieldDate.setBackground(Color.LIGHT_GRAY);
                    textFieldTime.setBackground(Color.LIGHT_GRAY);
                }

                connection.close();

            } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                System.err.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

            }

        }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
