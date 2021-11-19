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

public class Doctor_App extends JFrame implements ActionListener {


    JTextField textFieldDoctor = new JTextField();

    // Have a field to format a date in yyyy/mm/dd format
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    DateFormatter dateFormatter = new DateFormatter(dateFormat);
    JFormattedTextField textFieldApp = new JFormattedTextField(dateFormatter);

    public Doctor_App() {

        ImageIcon imageTitle = new ImageIcon("Resources/doctor_icon.png");
        ImageIcon imageBack = new ImageIcon("Resources/icons_back.png");
        ImageIcon imageSearch = new ImageIcon("Resources/icon_search_24.png");
        ImageIcon imageExit = new ImageIcon("Resources/exit_icon.png");

        JButton buttonBack = new JButton("Go Back", imageBack);
        JButton buttonSearch = new JButton("View App", imageSearch);
        JButton buttonExit = new JButton("Exit", imageExit);

        Border borderPatient = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "DOCTORS APPOINTMENTS", TitledBorder.LEFT, TitledBorder.TOP);
        Border borderSearch = BorderFactory.createEtchedBorder();

        JPanel panelS = new JPanel();
        JPanel panelSS = new JPanel();
        panelS.setLayout(null);
        panelSS.setLayout(null);

        //Create and set up table

        final String[] columHeads = {"Patient ID", "First name", "Last Name", "App Date", "App Time", "Email", "Phone", "Date of Birth", "Gender"};
        Object[][] data = {{ "", "", "", "", "", "", "", "", ""}};

        JTable tablep = new JTable(data, columHeads) {
            public boolean isCellEditable(int data, int columHeads) {
                return false;
            }
        };


        tablep.setPreferredScrollableViewportSize(new Dimension(820, 60));
        tablep.setFillsViewportHeight(true);

        //SCROLLPANE

        JScrollPane jsp = new JScrollPane(tablep);
        jsp.setBounds(40, 200, 820, 300);
        panelS.add(jsp, BorderLayout.CENTER);

        JLabel labelH = new JLabel();
        JLabel labelSearch = new JLabel();
        JLabel labelDoctor = new JLabel();
        JLabel labelDateformat = new JLabel();

        labelH.setText("My daily appointments");                                    //Set Header Text
        labelSearch.setText("Today's Date: ");
        labelDoctor.setText("Doctor: ");
        labelDateformat.setText("yyyy / mm / dd");

        labelH.setFont(new Font("Comic Sans", Font.ITALIC, 58));                  //Header Font and Size
        labelSearch.setFont(new Font("Arial", Font.BOLD, 22));                  //Header Font and Size
        labelDoctor.setFont(new Font("Arial", Font.BOLD, 20));
        labelDateformat.setFont(new Font("Arial", Font.BOLD, 14));

        textFieldApp.setFont(new Font("Arial", Font.BOLD, 18));               //Search Patient ID text area Font and Size
        textFieldDoctor.setFont(new Font("Arial", Font.BOLD, 16));

        tablep.setFont(new Font("Arial", Font.PLAIN, 12));
        tablep.setFont(new Font("Arial", Font.PLAIN, 12));

        labelH.setBounds(100, -30, 1000, 200);                                //Set Header Bounds
        panelS.setBounds(50, 130, 900, 550);                                  //Set Panel Bounds
        panelSS.setBounds(200, 40, 600, 90);
        panelSS.setBorder(borderSearch);

        labelH.setIconTextGap(70);
        labelH.setIcon(imageTitle);

        labelSearch.setBounds(20, 30, 150, 25);
        labelDoctor.setBounds(40, 150,100,25);

        textFieldApp.setBounds(190, 25, 200, 30);
        labelDateformat.setBounds(240, 60,100,25);
        textFieldDoctor.setBounds(130,150,280,25);
        tablep.setBounds(20, 200, 820, 30);                                 //JTable

        buttonSearch.setBounds(420, 15, 150, 40);
        buttonBack.setBounds(980, 130, 200, 100);
        buttonExit.setBounds(980, 260, 200, 100);

        panelS.setBorder(borderPatient);

        buttonBack.setFont(new Font("Arial", Font.BOLD, 20));
        buttonSearch.setFont(new Font("Arial", Font.BOLD, 16));
        buttonExit.setFont(new Font("Arial", Font.BOLD, 16));

        textFieldApp.setFocusable(true);
        buttonSearch.setFocusable(false);
        buttonBack.setFocusable(false);
        buttonExit.setFocusable(false);

        buttonSearch.addActionListener(this);
        buttonBack.addActionListener(this);
        buttonExit.addActionListener(this);

        textFieldDoctor.setBackground(new Color(209, 234, 197));
        textFieldApp.setBackground(new Color(209, 234, 197));

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

        frame.getContentPane().setBackground(new Color(209, 234, 197));

        //Screen Position
        frame.setLocationRelativeTo(null);


        panelSS.add(labelSearch);
        panelSS.add(textFieldApp);                                                            //Inner Panel and components
        panelSS.add(labelDateformat);
        panelSS.add(buttonSearch);
        panelS.add(labelDoctor);
        panelS.add(textFieldDoctor);
        panelS.add(panelSS);
        frame.add(panelS);
        frame.add(buttonBack);
        frame.add(buttonExit);
        frame.add(labelH);
        frame.setVisible(true);


        // Add an ActionListener to SEARCH JButton
        buttonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String searchDate = textFieldApp.getText();
                String Doctor = textFieldDoctor.getText();

                if (searchDate.trim().isEmpty() && Doctor.trim().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Please enter Date and your Full Name Doctor!!!");
                    textFieldApp.setText("");


                } else {

                    try {

                        //Open Connection
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection

                        Statement stm = connection.createStatement();

                        String query = "SELECT patient_reg_table.id_p, patient_reg_table.fnamep, patient_reg_table.lnamep, patient_reg_table.emailp, patient_reg_table.phonep, patient_reg_table.dobp, patient_reg_table.genderp, patient_records_table.p_date, patient_records_table.p_time FROM patient_reg_table INNER JOIN patient_records_table ON patient_reg_table.id_p = patient_records_table.id_pr WHERE patient_records_table.p_date = '" + searchDate + "' AND patient_records_table.p_doctor = '" + Doctor + "'";

                        ResultSet rs = stm.executeQuery(query);

                        tablep.setModel(DbUtils.resultSetToTableModel(rs));

                        tablep.getColumn("id_p").setHeaderValue("Patient ID");
                        tablep.getColumn("fnamep").setHeaderValue("First Name");
                        tablep.getColumn("lnamep").setHeaderValue("Last Name");
                        tablep.getColumn("emailp").setHeaderValue("Email");
                        tablep.getColumn("phonep").setHeaderValue("Phone");
                        tablep.getColumn("dobp").setHeaderValue("Date-of-Birth");
                        tablep.getColumn("genderp").setHeaderValue("Gender");
                        tablep.getColumn("p_date").setHeaderValue("App Date");
                        tablep.getColumn("p_time").setHeaderValue("App Time");

                        tablep.repaint();
                        stm.close();
                        connection.close();


                    } catch (ClassNotFoundException | SQLException | HeadlessException e) {
                        System.err.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);

                    }
                }
            }
        });

        // Add an ActionListener to BACK JButton
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



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
