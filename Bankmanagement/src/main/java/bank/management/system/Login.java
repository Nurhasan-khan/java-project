package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton signInButton;
    private JButton clearButton;
    private JButton signUpButton;
    private Login(){
        super("Bank Management System");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bankImg = new ImageIcon(i2);
        JLabel image1 = new JLabel(bankImg);
        image1.setBounds(350, 10, 100, 100);
        add(image1);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon cardImg = new ImageIcon(ii2);
        JLabel image2 = new JLabel(cardImg);
        image2.setBounds(650, 350, 100, 100);
        add(image2);

        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.black);
        label1.setFont(new Font("AvantGarde",Font.BOLD,38));
        label1.setBounds(230,125,450,40);
        add(label1);

        label2 = new JLabel("Card No: ");
        label2.setFont(new Font("Ralway",Font.BOLD,28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150,190,375,30);
        add(label2);

        textField = new JTextField(15);
        textField.setBounds(325,190,230,30);
        textField.setFont(new Font("Arial",Font.BOLD,14));
        add(textField);

        label3 = new JLabel("PIN: ");
        label3.setFont(new Font("Ralway",Font.BOLD,28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(150,250,375,30);
        add(label3);

        passwordField = new JPasswordField(15);
        passwordField.setBounds(325,250,230,30);
        passwordField.setFont(new Font("Arial",Font.BOLD,14));
        add(passwordField);

        signInButton = new JButton("SIGN IN");
        signInButton.setFont(new Font("Arial",Font.BOLD,14));
        signInButton.setForeground(Color.CYAN);
        signInButton.setBackground(Color.DARK_GRAY);
        signInButton.setBounds(300,300,100,30);
        signInButton.addActionListener(this);
        add(signInButton);

        clearButton = new JButton("CLEAR");
        clearButton.setFont(new Font("Arial",Font.BOLD,14));
        clearButton.setForeground(Color.CYAN);
        clearButton.setBackground(Color.DARK_GRAY);
        clearButton.setBounds(450,300,100,30);
        clearButton.addActionListener(this);
        add(clearButton);

        signUpButton = new JButton("SIGN UP");
        signUpButton.setFont(new Font("Arial",Font.BOLD,14));
        signUpButton.setForeground(Color.CYAN);
        signUpButton.setBackground(Color.DARK_GRAY);
        signUpButton.setBounds(300,350,250,30);
        signUpButton.addActionListener(this);
        add(signUpButton);


        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("backbg.png"));
        Image imageIcon2 = imageIcon1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon backBgImg = new ImageIcon(imageIcon2);
        JLabel image3 = new JLabel(backBgImg);
        image3.setBounds(0, 0, 850, 480);
        add(image3);

        setLayout(null);
        setSize(850, 480);
        setLocation(450, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent event){
        try{
            if(event.getSource() == signInButton){

            }else if (event.getSource() == clearButton){
                textField.setText("");
                passwordField.setText("");

            }else if (event.getSource() == signUpButton){


            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Login();

    }
}
