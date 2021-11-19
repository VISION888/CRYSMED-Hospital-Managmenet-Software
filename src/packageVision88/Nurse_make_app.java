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

public class Nurse_make_app extends JFrame implements ActionListener {

    int flag = 0;

    JComboBox comboDoctor = new JComboBox();
    JComboBox comboTime = new JComboBox();

    public Nurse_make_app() {

        ImageIcon imageTitle = new ImageIcon("patient_icon.png");
        ImageIcon imageApp = new ImageIcon("icon_app.png");
        ImageIcon imageBack = new ImageIcon("icons_back.png");
        ImageIcon imageSearch = new ImageIcon("icon_search_24.png");
        ImageIcon imageExit = new ImageIcon("exit_icon.png");

        JButton buttonSave = new JButton("Save Information", imageApp);
        JButton buttonExit = new JButton("Exit", imageExit);
        JButton buttonBack = new JButton("Go Back", imageBack);
        JButton buttonSearch = new JButton("Search", imageSearch);

        Border borderPatient = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "PATIENT INFORMATION", TitledBorder.LEFT, TitledBorder.TOP);
        Border borderSymptoms = BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "PATIENT SYMPTOMS", TitledBorder.LEFT, TitledBorder.TOP);
        Border borderSearch = BorderFactory.createEtchedBorder();
        JLabel label = new JLabel("Patient does not exist!");

        JPanel panelS = new JPanel();
        JPanel panelSS = new JPanel();
        panelS.setLayout(null);
        panelSS.setLayout(null);

        JTextArea areaSymp = new JTextArea();                                               //Initialize Text area
        panelS.add(areaSymp);                                                               //Add Component to panel

        JTextField textFieldSearch = new JTextField();
        JFormattedTextField textFieldDate;                                                  //TextField Date

        // Have a field to format a date in yyyy/mm/dd format
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DateFormatter dateFormatter = new DateFormatter(dateFormat);
        textFieldDate = new JFormattedTextField(dateFormatter);

        final String[] columHeads = {"ID", "First name", "Last Name", "Email", "Phone", "Street", "City", "Postal", "Date of Birth", "Gender"};
        Object[][] data = {{"", "", "", "", "", "", "", "", "", ""}};

        JTable tablep = new JTable(data, columHeads) {
            public boolean isCellEditable(int data, int columHeads) {
                return false;
            }
        };

        tablep.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablep.setPreferredScrollableViewportSize(new Dimension(820, 60));
        tablep.setFillsViewportHeight(true);

            //SCROLLPANE
            JScrollPane jsp = new JScrollPane(tablep);
            jsp.setBounds(20, 130, 820, 60);
            panelS.add(jsp, BorderLayout.CENTER);

            JLabel labelSearch = new JLabel();
            JLabel labelDocter = new JLabel();
            JLabel labelDate = new JLabel();
            JLabel labelDateFormat = new JLabel();
            JLabel labelTime = new JLabel();

            buttonSave.setMargin(new Insets(0, 10, 0, 10));            //Set button margin

            JLabel labelH = new JLabel();                                                           //Initialize Label

            labelH.setText("Make Patient Appointments");                                        //Set Header Text
            labelSearch.setText("Patient ID: ");
            labelDocter.setText("Doctor: ");                                                    //Doctors label
            labelDate.setText("Appointment Date: ");                                             //App Date Label
            labelDateFormat.setText("yyyy/mm/dd");                                              //Date format
            labelTime.setText("Appointment Time: ");                                            //App Time Label

            labelH.setFont(new Font("Comic Sans", Font.ITALIC, 58));                  //Header Font and Size
            labelSearch.setFont(new Font("Arial", Font.BOLD, 22));                      //Header Font and Size
            labelDocter.setFont(new Font("Arial", Font.BOLD, 22));                    //Label Doctor
            labelDate.setFont(new Font("Arial", Font.BOLD, 18));                      //Label App Date
            labelDateFormat.setFont(new Font("Arial", Font.BOLD, 14));
            labelTime.setFont(new Font("Arial", Font.BOLD, 18));                      //Label App time
            label.setFont(new Font("Arial", Font.BOLD, 20));
            label.setForeground(Color.red);
            areaSymp.setFont(new Font("Arial", Font.PLAIN, 16));                      //Symptoms text area Font and Size
            textFieldSearch.setFont(new Font("Arial", Font.BOLD, 18));               //Search Patient ID text area Font and Size
            textFieldDate.setFont(new Font("Arial", Font.PLAIN, 14));                 //App date text area Font and Size
            comboTime.setFont(new Font("Arial", Font.PLAIN, 14));                     //App time text area Font and Size

            tablep.setFont(new Font("Arial", Font.PLAIN, 12));
            tablep.setFont(new Font("Arial", Font.PLAIN, 12));

            labelH.setBounds(100, -30, 1000, 200);                                //Set Header Bounds
            panelS.setBounds(50, 130, 900, 480);                                  //Set Panel Bounds
            panelSS.setBounds(200, 20, 500, 60);
            label.setBounds(350, 85, 250, 30);
            panelSS.setBorder(borderSearch);

            labelSearch.setBounds(210, 37, 150, 25);

            areaSymp.setBounds(20, 200, 820, 80);                                 //Set Text Area Bounds
            labelDocter.setBounds(20, 300, 250, 30);
            labelDate.setBounds(20, 360, 250, 30);                              //Label Date
            labelDateFormat.setBounds(230,390, 100,25);                          //Label Date format
            labelTime.setBounds(400, 360, 250, 30);                              //Label Time

            textFieldSearch.setBounds(130, 13, 200, 30);
            tablep.setBounds(20, 130, 820, 30);                                 //JTable

            comboDoctor.setBounds(200, 300, 300, 25);
            textFieldDate.setBounds(200, 360, 180, 25);
            comboTime.setBounds(580, 360, 180, 25);

            panelS.setBorder(borderPatient);
            areaSymp.setBorder(borderSymptoms);

            labelH.setIconTextGap(70);
            labelH.setIcon(imageTitle);

            comboTime.addItem("");
            comboTime.addItem("09:00");
            comboTime.addItem("09:30");
            comboTime.addItem("10:00");
            comboTime.addItem("10:30");
            comboTime.addItem("11:00");
            comboTime.addItem("11:30");
            comboTime.addItem("12:00");
            comboTime.addItem("12:30");

            comboTime.addItem("14:00");
            comboTime.addItem("14:30");
            comboTime.addItem("15:00");
            comboTime.addItem("15:30");
            comboTime.addItem("16:00");
            comboTime.addItem("16:30");

            buttonSave.setFont(new Font("Arial", Font.BOLD, 16));
            buttonBack.setFont(new Font("Arial", Font.BOLD, 20));
            buttonSearch.setFont(new Font("Arial", Font.BOLD, 16));
            buttonExit.setFont(new Font("Arial", Font.BOLD, 16));

            buttonSearch.setBounds(360, 10, 120, 40);
            buttonSave.setBounds(980, 130, 230, 120);
            buttonBack.setBounds(980, 300, 230, 120);
            buttonExit.setBounds(980, 480, 230, 120);

            buttonSave.setFocusable(false);
            buttonBack.setFocusable(false);
            buttonExit.setFocusable(false);

            buttonSearch.addActionListener(this);
            buttonSave.addActionListener(this);
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
            frame.setSize(1250, 750);
            frame.setResizable(false);

            frame.getContentPane().setBackground(new Color(209, 234, 197));

            //Screen Position
            frame.setLocationRelativeTo(null);

            panelSS.add(labelSearch);
            panelSS.add(textFieldSearch);                                                            //Inner Panel and components
            panelSS.add(buttonSearch);
            panelS.add(labelSearch);

            panelS.add(labelDocter);
            panelS.add(labelDate);
            panelS.add(labelDateFormat);
            panelS.add(labelTime);
            panelS.add(textFieldDate);
            panelS.add(comboTime);
            panelS.add(comboDoctor);
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
                        tablep.getColumn("emailp").setHeaderValue("    Email    ");
                        tablep.getColumn("phonep").setHeaderValue("Phone");
                        tablep.getColumn("streetp").setHeaderValue("    Street    ");
                        tablep.getColumn("cityp").setHeaderValue("City");
                        tablep.getColumn("postalp").setHeaderValue("Postal");
                        tablep.getColumn("dobp").setHeaderValue("Date-of-Birth");
                        tablep.getColumn("genderp").setHeaderValue("Gender");

                        tablep.repaint();

                        if (!rs.first()) {
                            label.setVisible(true);

                        } else {
                            JComboBox();
                            label.setVisible(false);
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
                        String p_doctor = (String) comboDoctor.getSelectedItem();
                        String p_date = textFieldDate.getText();
                        String p_time = (String) comboTime.getSelectedItem();

                        if (comboTime.getSelectedItem().toString().equals("")) {

                            JOptionPane.showConfirmDialog(null, "Please choose Time of Appointment!", "Error", JOptionPane.DEFAULT_OPTION);

                        } else if (comboDoctor.getSelectedItem().toString().equals("")) {

                            JOptionPane.showConfirmDialog(null, "Please choose Doctor of Appointment!", "Error", JOptionPane.DEFAULT_OPTION);

                        } else if (textFieldDate.getText().trim().isEmpty()) {

                            JOptionPane.showConfirmDialog(null, "Please enter Date of Appointment!", "Error", JOptionPane.DEFAULT_OPTION);

                        }

                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection
                            Statement stm = connection.createStatement();

                            String selectQuery = ("SELECT p_doctor, p_time FROM patient_records_table WHERE p_doctor = '" + p_doctor + "' AND p_time = '" + p_time + "'");

                            ResultSet rs = stm.executeQuery(selectQuery);

                            if(rs.next()==true)

                            {
                                JOptionPane.showMessageDialog(null, "No appointment available chooses another Doctor or time!", "ERROR", JOptionPane.DEFAULT_OPTION);

                            } else {

                            //Add records
                            String saveQuery = "INSERT INTO patient_records_table(id_pr, p_symptoms, p_doctor, p_date, p_time)" +
                                    "VALUES('" + id_record +  "',  '" + p_symptoms +  "', '" + p_doctor +  "', '" + p_date +  "', '" + p_time +  "')";

                                stm.executeUpdate(saveQuery);
                                JOptionPane.showMessageDialog(null, "New Appointment made successfully", "SUCCESS", JOptionPane.DEFAULT_OPTION);
                                frame.dispose();
                                new Nurse_make_app();
                            }
                            stm.close();
                            connection.close();

                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                            JOptionPane.showMessageDialog(null, "System got an error: " + e.getMessage(), "ERROR", JOptionPane.DEFAULT_OPTION);
                        }

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

        private void JComboBox() {

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmdatabase", "root", "root"); //Creates a Connection

                String sql = "SELECT fullname FROM dr_reg_table";
                PreparedStatement stm = connection.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();

                while(rs.next()) {

                    String name = rs.getString("fullname");
                    comboDoctor.addItem(name);
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
