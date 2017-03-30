import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Piotrek on 2017-03-26.
 */
public class Aplikacja implements ActionListener {
    String userPesel;

    JFrame okno;
    JTextField peselField;
    JTextField dateField;
    JTextField sexField;
    JButton button;


    public Aplikacja () {
        this.okno = new JFrame();
        okno.setSize(300, 300);
        okno.setLayout(new BoxLayout(okno.getContentPane(), BoxLayout.Y_AXIS));

        JLabel peselLabel = new JLabel("Wpisz PESEL:");
        this.peselField = new JTextField();
        JLabel dateLabel = new JLabel("Data urodzenia:");
        this.dateField = new JTextField();
        JLabel sexLabel = new JLabel("Płeć:");
        this.sexField = new JTextField();
        peselField.setPreferredSize(new Dimension(200, 40));
        dateField.setPreferredSize(new Dimension(200, 40));
        sexField.setPreferredSize(new Dimension(200, 40));
        this.button = new JButton("Sprawdź");

        okno.add(peselLabel);
        okno.add(peselField);
        okno.add(button);
        okno.add(dateLabel);
        okno.add(dateField);
        okno.add(sexLabel);
        okno.add(sexField);

        okno.setVisible(true);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.userPesel = this.peselField.getText();
        this.printInformation();
    }

    void getPeselNumber() {
        this.button.addActionListener(this::actionPerformed);
    }

    void printInformation() {
        if (Pesel.isPeselValid(userPesel)){
            this.peselField.setBackground(Color.green);
            this.dateField.setText(Pesel.getBirthDate(this.userPesel));
            this.sexField.setText(Pesel.getSex(this.userPesel));
        }else {
            this.peselField.setBackground(Color.red);
        }
    }
}
