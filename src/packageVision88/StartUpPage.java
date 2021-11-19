package packageVision88;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StartUpPage extends JFrame implements ActionListener {

    public StartUpPage() {

        ImageIcon image1 = new ImageIcon("Resources/nurse_icon.png");
        ImageIcon image2 = new ImageIcon("Resources/patient_icon.png");
        ImageIcon image3 = new ImageIcon("Resources/doctor_icon.png");
        ImageIcon image4 = new ImageIcon("Resources/exit_icon.png");

        JLabel label = new JLabel();            //Creates Heading
        JLabel labelW = new JLabel();           // Welcome page
        JLabel label1 = new JLabel();           //Creates Nurses Sign in Image and Label
        JLabel label2 = new JLabel();           //Creates Patients Sign in Image and Label
        JLabel label3 = new JLabel();           //Creates Doctor Sign in Image and Label
        JLabel label4 = new JLabel();           //Creates Exit Sign in Image and Label

        label.setText("HOSPITAL MANAGEMENT SYSTEM");
        label.setFont(new Font("Arial", Font.BOLD, 53));
        label.setBounds(150,20,900,200);

        labelW.setText("Welcome to CrysMed Login Page");
        labelW.setFont(new Font("Arial", Font.ITALIC, 40));
        labelW.setBounds(270,90,900,200);

        label1.setText("Nurse's Login");
        label2.setText("Patients Login");
        label3.setText("Doctors Login");
        label4.setText("Exit Here");

        label1.setBounds(200,260,750,200);   //Nurse
        label2.setBounds(400,260,750,200);  //Patient
        label3.setBounds(600,260,750,200); // Doctor
        label4.setBounds(820,260,750,200); // Exit

        label1.setFont(new Font("Arial", Font.BOLD, 22));
        label2.setFont(new Font("Arial", Font.BOLD, 22));
        label3.setFont(new Font("Arial", Font.BOLD, 22));
        label4.setFont(new Font("Arial", Font.BOLD, 22));

        label1.setIcon(image1); //Nurses
        label2.setIcon(image2); //Patient
        label3.setIcon(image3); //Doctor
        label4.setIcon(image4); //Exit

        label1.setHorizontalTextPosition(JLabel.CENTER); // Set ext Left, Right or Center of Image Icon
        label1.setVerticalTextPosition(JLabel.TOP); // Will set text top, center or bottom of Image Icon

        label2.setHorizontalTextPosition(JLabel.CENTER); // Set ext Left, Right or Center of Image Icon
        label2.setVerticalTextPosition(JLabel.TOP); // Will set text top, center or bottom of Image Icon

        label3.setHorizontalTextPosition(JLabel.CENTER); // Set ext Left, Right or Center of Image Icon
        label3.setVerticalTextPosition(JLabel.TOP); // Will set text top, center or bottom of Image Icon

        label4.setHorizontalTextPosition(JLabel.CENTER); // Set ext Left, Right or Center of Image Icon
        label4.setVerticalTextPosition(JLabel.TOP); // Will set text top, center or bottom of Image Icon

        label1.setIconTextGap(13);
        label2.setIconTextGap(13);
        label3.setIconTextGap(13);
        label4.setIconTextGap(13);

        JButton button1 = new JButton();    //Nurse button
        JButton button2 = new JButton();    //Patient button
        JButton button3 = new JButton();    //Docters button;
        JButton button4 = new JButton();    //Exit Button

        button1.setText("Nurse's Login");
        button2.setText("Patient's Login");
        button3.setText("Doctor's Login");
        button4.setText("Exit Here");

        button1.setBounds(200,470,150,60);
        button2.setBounds(400,470,150,60);
        button3.setBounds(600,470,150,60);
        button4.setBounds(800,470,150,60);

        button1.setFont(new Font("Comic Sans", Font.BOLD, 16));
        button2.setFont(new Font("Comic Sans", Font.BOLD, 16));
        button3.setFont(new Font("Comic Sans", Font.BOLD, 16));
        button4.setFont(new Font("Comic Sans", Font.BOLD, 16));

        button1.setBorder(BorderFactory.createEtchedBorder());
        button2.setBorder(BorderFactory.createEtchedBorder());
        button3.setBorder(BorderFactory.createEtchedBorder());
        button4.setBorder(BorderFactory.createEtchedBorder());

        button1.setBackground(new Color(145,184,219));
        button2.setBackground(new Color(145,184,219));
        button3.setBackground(new Color(145,184,219));
        button4.setBackground(new Color(35,172,196));

        button4.setForeground(Color.white);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

        JFrame frame = new JFrame();

        // Set the default close behavior to exit the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setDefaultLookAndFeelDecorated(true);
        frame.setTitle("Hospital Management Program");
        frame.setIconImage(new ImageIcon("Resources/icon_hs.png").getImage());
        frame.setLayout(null);

        // Set the x, y, width and height properties in one go
        frame.setSize(1200, 750);
        frame.setResizable(false);

        frame.getContentPane().setBackground(new Color(202, 242, 241));

        //Screen Position
        frame.setLocationRelativeTo(null);

        frame.add(label);
        frame.add(labelW);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);

        frame.setVisible(true);

        // Add an ActionListener to NURSES LOGIN JButton
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if(event.getSource() == button1) {
                    frame.dispose();
                    new LoginN();
                }
            }
        });


        // Add an ActionListener to PATIENT LOGIN JButton
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if(event.getSource() == button2) {
                    frame.dispose();
                    new LoginP();
                }

            }
        });


        // Add an ActionListener to DOCTOR'S LOGIN JButton
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if(event.getSource() == button3) {
                    frame.dispose();
                    new LoginDr();
                }

            }
        });


        // Add an ActionListener to the Exit JButton
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                // Exit Button
                int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","Select", JOptionPane.YES_NO_OPTION);

                if(exit == 0)System.exit(0);

            }
        });

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
