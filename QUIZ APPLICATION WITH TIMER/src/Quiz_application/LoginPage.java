package Quiz_application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame implements ActionListener {
    JButton enter, exit;
    JTextField ename;

    LoginPage() {
        setLayout(null);

        JLabel header = new JLabel("Learn Good");
        header.setBounds(400, 2, 500, 80);
        header.setFont(new Font("Times New Roman", Font.BOLD, 35));
        add(header);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Quiz_application/icons/quiz.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(280, 00, 400, 350);
        add(image);

        JLabel name1 = new JLabel("Enter your name");
        name1.setBounds(420, 300, 150, 50);
        name1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(name1);

         ename = new JTextField();
        ename.setBounds(375, 360, 200, 30);
        add(ename);

        enter = new JButton("Enter"); // Use the instance variable directly
        enter.setBounds(360, 410, 100, 30);
        enter.addActionListener(this);
        add(enter);

        exit = new JButton("Exit"); // Use the instance variable directly
        exit.setBounds(480, 410, 100, 30);
        exit.addActionListener(this);
        add(exit);

        setSize(1000, 500);
        setLocation(150, 120);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enter) {

            String name = ename.getText();
            setVisible(false);
            new NamePage(name);

        } else if (e.getSource() == exit) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
