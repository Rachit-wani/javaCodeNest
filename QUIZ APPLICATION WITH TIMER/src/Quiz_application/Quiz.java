package Quiz_application;

import Quiz_application.Score;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit ;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    public String[] getUserSelectedOptions() {
        String[] userSelectedOptions = new String[10];
        for (int i = 0; i < useranswers.length; i++) {
            userSelectedOptions[i] = useranswers[i][0];
        }
        return userSelectedOptions;
    }



    String name;

    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        qno = new JLabel();
        qno.setBounds(100, 50, 50, 30);
        qno.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 50, 900, 30);
        question.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        add(question);


        questions[0][0] = "Which is used to find and fix bugs in the Java programs?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "Which programming language is widely used for developing Android applications?";
        questions[1][1] = "Java";
        questions[1][2] = "Python";
        questions[1][3] = "C++";
        questions[1][4] = "Swift";

        questions[2][0] = "What is the primary function of a compiler?";
        questions[2][1] = "Translate source code into machine code";
        questions[2][2] = "Execute the program";
        questions[2][3] = "Debug the program";
        questions[2][4] = "Optimize program performance";

        questions[3][0] = "Which data structure uses a Last-In-First-Out (LIFO) approach?";
        questions[3][1] = "Queue";
        questions[3][2] = "Stack";
        questions[3][3] = "Linked list";
        questions[3][4] = "Tree";

        questions[4][0] = "What does HTML stand for?";
        questions[4][1] = "Hyper Text Markup Language";
        questions[4][2] = "High Tech Markup Language";
        questions[4][3] = "Home Tool Markup Language";
        questions[4][4] = "Hyperlink Text Markup Language";

        questions[5][0] = "What does SQL stand for in the context of databases?";
        questions[5][1] = "Structured Query Language";
        questions[5][2] = "Simple Query Language";
        questions[5][3] = "System Query Language";
        questions[5][4] = "Standard Query Language";

        questions[6][0] = "Which of the following is NOT a type of computer network?";
        questions[6][1] = "LAN (Local Area Network)";
        questions[6][2] = "WAN (Wide Area Network)";
        questions[6][3] = "VPN (Virtual Private Network)";
        questions[6][4] = "DTP (Desktop Publishing)";

        questions[7][0] = "What is the purpose of a firewall in computer networks?";
        questions[7][1] = "Prevent unauthorized access to a network";
        questions[7][2] = "Speed up data transmission";
        questions[7][3] = "Enhance data encryption";
        questions[7][4] = "Monitor network traffic";

        questions[8][0] = "What is the binary equivalent of the decimal number 25?";
        questions[8][1] = "11001";
        questions[8][2] = "10101";
        questions[8][3] = "11111";
        questions[8][4] = "10011";

        questions[9][0] = "Which data structure organizes data in a hierarchical format?";
        questions[9][1] = "Array";
        questions[9][2] = "Queue";
        questions[9][3] = "Tree";
        questions[9][4] = "Stack";


        answers[0][1] = "JDB";
        answers[1][1] = "Java";
        answers[2][1] = "Translate source code into machine code";
        answers[3][1] =  "Stack";
        answers[4][1] = "Hyper Text Markup Language";
        answers[5][1] = "Structured Query Language";
        answers[6][1] = "DTP (Desktop Publishing)";
        answers[7][1] = "Prevent unauthorized access to a network";
        answers[8][1] = "11001";
        answers[9][1] = "Tree";

        opt1 = new JRadioButton();
        opt1.setBounds(170, 120, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 160, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 200, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 240, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(180, 600, 200, 40);
        next.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        next.setBackground(new Color(64, 30, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);


        submit = new JButton("Submit");
        submit.setBounds(430, 600, 200, 40);
        submit.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        submit.setBackground(new Color(60, 30, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);

        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score,getUserSelectedOptions());

        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        if (timer > 0) {
            g.drawString(time, 1100, 110);
        } else {
            g.drawString("Times up!!", 1100, 110);
        }

        timer--; // 14

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score("User", 0,getUserSelectedOptions());

            } else { // next button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }

    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User");
    }
}