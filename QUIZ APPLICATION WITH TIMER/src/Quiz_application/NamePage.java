package Quiz_application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class NamePage extends JFrame implements ActionListener {
    String name;
    JButton start, back;

    NamePage(String name)
    {
        getContentPane();
        this.name = name;
        setLayout(null);

        JLabel header1 = new JLabel("Learn Good");
        header1.setBounds(610, 50, 500, 80);
        header1.setFont(new Font("Times New Roman", Font.BOLD, 45));
        add(header1);

        JLabel header2 = new JLabel("Welcome "+name+" to Learn Good");
        header2.setBounds(480, 100, 500, 80);
        header2.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(header2);

        start = new JButton("Start");
        start.setBounds(550, 700, 130, 60);
        start.setForeground(Color.WHITE);
        start.setBackground(Color.BLUE);
        start.addActionListener(this);
        add(start);

        back  = new JButton("Back");
        back.setBounds(750, 700, 130, 60);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLUE);
        back.addActionListener(this);
        add(back);

        JLabel rules = new JLabel();
        rules.setFont(new Font("Times New Roman",Font.PLAIN,30));
        rules.setText(
                "<html>"+
                        "1. This quiz is based on your general Computer science related questions."+"<br><br>"+
                        "2. Here there are 10 questions."+"<br><br>"+
                        "3. You will have 15 seconds for each question."+"<br><br>"+
                        "4. Each question carries 10 marks that in total has 100 marks."+"<br><br>"+
                        "5. Please be sincere."+"<br><br>"+

                        "<html>"
        );
        rules.setBounds(210,100,1000,600);
        add(rules);

        setBounds(50, 0, 1440, 850);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== start){
            setVisible(false);
            new Quiz(name);
        }
        else if (e.getSource()== back){
            setVisible(false);
            new LoginPage();
        }

    }


    public static void main(String[] args) {
new NamePage("user");
    }
}
