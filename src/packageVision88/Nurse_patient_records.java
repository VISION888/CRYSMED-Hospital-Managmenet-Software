package packageVision88;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Nurse_patient_records extends JFrame implements ActionListener {

   int flag = 0;

    JTextField textFieldSearch = new JTextField();
    JTextField textFieldName = new JTextField();
    JLabel label = new JLabel("Patient does not exist!");

    //PATIENT MEDICAL RECORDS TABLES

    final String[] columnHeads = {"ID", "DOCTOR", "DIAGNOSES", "DATE", "TIME", "MEDICATION"};
    Object[][] rowdata = {{"", "", "", "", "", ""}};

    JTable tableMedicalHistory = new JTable(rowdata, columnHeads) {
        public boolean isCellEditable(int rowdata, int columnHeads) {
            return false;
        }
    };

    public Nurse_patient_records() {

        ImageIcon imageTitle = new ImageIcon("Resources/patient_icon.png");
        ImageIcon imageBack = new ImageIcon("Resources/icons_back.png");
        ImageIcon imageSearch = new ImageIcon("Resources/icon_search_24.png");
        ImageIcon imageExit = new ImageIcon("Resources/icons8-exit-24.png");
        ImageIcon imageRefresh = new ImageIcon("Resources/icon_refresh.png");

        JButton buttonRefresh = new JButton("Refresh", imageRefresh);
        JButton buttonSearch = new JButton("Search", imageSearch);
        JButton buttonBack = new JButton("Back", imageBack);
        JButton buttonExit = new JButton("Exit", imageExit);

        Border borderPatient = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "PATIENT RECORDS", TitledBorder.LEFT, TitledBorder.TOP);
        Border borderSearch = BorderFactory.createEtchedBorder();

        JPanel panelS = new JPanel();
        JPanel panelSS = new JPanel();
        panelS.setLayout(null);
        panelSS.setLayout(null);


        // PATIENT DETAILS TABLE
        final String[] columHeads = {"ID", "First name", "Last Name", "Username", "Password", "Email", "Phone", "Street", "City", "Postal", "Date of Birth", "Gender"};
        Object[][] data = {{"", "", "", "", "", "", "", "", "", "","",""}};

        JTable tablep = new JTable(data, columHeads) {
            public boolean isCellEditable(int data, int columHeads) {
                return false;
            }
        };



        //SCROLLPANE

        JScrollPane jsp = new JScrollPane(tablep);
        jsp.setBounds(20, 180, 950, 80);
        panelS.add(jsp, BorderLayout.CENTER);

        tablep.setPreferredScrollableViewportSize(new Dimension(800, 50));
        tablep.setFillsViewportHeight(true);

        //SCROLLPANE MEDICAL HISTORY

        JScrollPane jspmedical = new JScrollPane(tableMedicalHistory);
        jspmedical.setBounds(20, 320, 950, 200);
        panelS.add(jspmedical, BorderLayout.CENTER);

        tableMedicalHistory.setPreferredScrollableViewportSize(new Dimension(860, 80));
        tableMedicalHistory.setFillsViewportHeight(true);

        JLabel labelSearch = new JLabel();
        JLabel labelH = new JLabel();                                                        //Initialize Label
        JLabel labelMedical = new JLabel();
        JLabel labelName = new JLabel();

        labelH.setText("View Patient medical records" );                                    //Set Header Text
        labelSearch.setText("Patient ID: ");
        labelMedical.setText("MEDICAL RECORDS:");
        labelName.setText("PATIENT NAME: ");

        labelH.setFont(new Font("Comic Sans", Font.ITALIC, 58));                  //Header Font and Size
        labelSearch.setFont(new Font("Arial", Font.BOLD, 22));                  //Header Font and Size
        label.setFont(new Font("Arial", Font.BOLD, 20));
        labelName.setFont(new Font("Arial", Font.BOLD, 20));
        labelMedical.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.red);
        textFieldSearch.setFont(new Font("Arial", Font.BOLD, 18));               //Search Patient ID text area Font and Size
        textFieldName.setFont(new Font("Arial", Font.BOLD, 16));

        tablep.setFont(new Font("Arial", Font.PLAIN, 12));
        tablep.setFont(new Font("Arial", Font.PLAIN, 12));

        labelH.setBounds(100, -30, 1000, 200);                                //Set Header Bounds
        panelS.setBounds(50, 130, 1000, 550);                                  //Set Panel Bounds
        panelSS.setBounds(180, 20, 580, 60);
        label.setBounds(480, 120, 250, 30);
        labelName.setBounds(20,120,200,30);
        labelMedical.setBounds(20, 280, 200, 30);
        panelSS.setBorder(borderSearch);

        labelSearch.setBounds(210, 37, 150, 25);

        textFieldSearch.setBounds(150, 13, 200, 30);
        textFieldName.setBounds(190,120,240,30);
                                   //JTable

        panelS.setBorder(borderPatient);

        labelH.setIconTextGap(70);
        labelH.setIcon(imageTitle);

        buttonSearch.setFont(new Font("Arial", Font.BOLD, 16));
        buttonRefresh.setFont(new Font("Arial", Font.BOLD, 16));
        buttonBack.setFont(new Font("Arial", Font.BOLD, 20));
        buttonExit.setFont(new Font("Arial", Font.BOLD, 16));

        buttonSearch.setBounds(380, 10, 120, 40);
        buttonRefresh.setBounds(800, 30,150,40);
        buttonBack.setBounds(1080, 130, 150, 80);
        buttonExit.setBounds(1080, 230, 150, 80);

        buttonRefresh.setFocusable(false);
        buttonBack.setFocusable(false);
        buttonExit.setFocusable(false);

        buttonSearch.addActionListener(this);
        buttonRefresh.addActionListener(this);
        buttonBack.addActionListener(this);
        buttonExit.addActionListener(this);

        label.setVisible(false);


        JFrame frame = new JFrame();

        // Set the default close behavior to exit the application
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setDefaultLookAndFeelDecorated(true);
        frame.setTitle("Hospital Management Program");
        frame.setIconImage(new ImageIcon("Resources/icon_hs.png").getImage());
        frame.setLayout(null);

        // Set the x, y, width and height properties in one go
        frame.setSize(1280, 750);
        frame.setResizable(false);

        frame.getContentPane().setBackground(new Color(209, 234, 197));

        //Screen Position
        frame.setLocationRelativeTo(null);

        panelSS.add(labelSearch);
        panelSS.add(textFieldSearch);                                                            //Inner Panel and components
        panelSS.add(buttonSearch);
        panelS.add(labelSearch);
        panelS.add(buttonRefresh);
        panelS.add(panelSS);
        panelS.add(label);
        panelS.add(labelName);
        panelS.add(textFieldName);
        panelS.add(labelMedical);
        frame.add(panelS);
        frame.add(buttonBack);
        frame.add(buttonExit);
        frame.add(labelH);
        frame.setVisible(true);

        // Add an ActionListener to SEARCH JButton
        buttonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String id_record = textFieldSearch.getText();
                String name = textFieldName.getText();

                if (id_record.trim().isEmpty() && name.trim().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Please enter Patient ID and Name!");

                } else {

                    try {

                        //Open Connection
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection

                        Statement stm = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                        String query = "SELECT id_p, fnamep, lnamep, usernamep, passwordp, emailp, phonep, streetp, cityp, postalp, dobp, genderp FROM patient_reg_table WHERE id_p = '" + id_record + "' AND fnamep = '" + name + "'";

                        ResultSet rs = stm.executeQuery(query);

                        tablep.setModel(DbUtils.resultSetToTableModel(rs));

                        tablep.getColumn("id_p").setHeaderValue("ID");
                        tablep.getColumn("fnamep").setHeaderValue("First Name");
                        tablep.getColumn("lnamep").setHeaderValue("Last Name");
                        tablep.getColumn("usernamep").setHeaderValue("Username");
                        tablep.getColumn("passwordp").setHeaderValue("Password");
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
                            medicalRecords();
                            textFieldSearch.setEditable(false);
                            textFieldSearch.setBackground(Color.LIGHT_GRAY);

                            flag = 1;
                            stm.close();
                            connection.close();
                        }

                    } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                        System.err.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                    }
                }
            }
        });

        //Add an ActionListener to refresh JButton
        buttonRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == buttonRefresh) {

                    frame.dispose();
                    new Nurse_patient_records();
                    textFieldSearch.setEditable(false);

                }
            }
        });

        // Add an ActionListener to CLOSE JButton
        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if (event.getSource() == buttonBack) {
                    frame.dispose();
                    new MainNurse();

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

    private void medicalRecords() {

        String id_record = textFieldSearch.getText();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection
            Statement stm = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String query = "SELECT id_pr, p_symptoms, p_doctor, p_diagnoses, p_date, p_time, p_medication FROM patient_records_table WHERE id_pr = '" + id_record + "'";

            ResultSet rs = stm.executeQuery(query);

            tableMedicalHistory.setModel(DbUtils.resultSetToTableModel(rs));

            tableMedicalHistory.getColumn("id_pr").setHeaderValue("ID");
            tableMedicalHistory.getColumn("p_symptoms").setHeaderValue("Symptoms");
            tableMedicalHistory.getColumn("p_doctor").setHeaderValue("Doctor");
            tableMedicalHistory.getColumn("p_diagnoses").setHeaderValue("Diagnoses");
            tableMedicalHistory.getColumn("p_date").setHeaderValue("Date");
            tableMedicalHistory.getColumn("p_time").setHeaderValue("Time");
            tableMedicalHistory.getColumn("p_medication").setHeaderValue("Medication");

            tableMedicalHistory.repaint();

            stm.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

        }
    }

    public void ptName() {


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection

            String sql = "SELECT id_p, fnamep FROM patient_reg_table";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while(rs.next()) {

                String s1 = rs.getString("id_p");
                textFieldSearch.setText(s1);

                String s2 = rs.getString("fnamep");
                textFieldName.setText(s2);

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

