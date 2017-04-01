import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Piotrek on 2017-03-26.
 */
public class Aplikacja implements ActionListener {
    private String userPesel;
    private JFrame okno;
    private JLabel peselLabel;
    private JTextField peselField;
    private JLabel dateLabel;
    private JTextField dateField;
    private JLabel sexLabel;
    private JTextField sexField;
    private JButton button;

    public Aplikacja () {
        this.okno = new JFrame();
        this.okno.setSize(300, 300);
        this.okno.setLayout(new BoxLayout(okno.getContentPane(), BoxLayout.Y_AXIS));

        this.peselLabel = new JLabel("Wpisz PESEL:");
        this.peselField = new JTextField();
        this.dateLabel = new JLabel("Data urodzenia:");
        this.dateField = new JTextField();
        this.sexLabel = new JLabel("Płeć:");
        this.sexField = new JTextField();
        this.peselField.setPreferredSize(new Dimension(200, 40));
        this.dateField.setPreferredSize(new Dimension(200, 40));
        this.sexField.setPreferredSize(new Dimension(200, 40));
        this.button = new JButton("Sprawdź");

        this.okno.add(peselLabel);
        this.okno.add(peselField);
        this.okno.add(button);
        this.okno.add(dateLabel);
        this.okno.add(dateField);
        this.okno.add(sexLabel);
        this.okno.add(sexField);

        this.okno.setVisible(true);
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.userPesel = this.peselField.getText();
        this.printInformation();
    }

    void getPeselNumber() {
        this.button.addActionListener(this);
    }

    private void printInformation() {
        if (Pesel.isPeselValid(userPesel)){
            this.peselField.setBackground(Color.green);
            this.dateField.setText(Pesel.getBirthDate(this.userPesel));
            this.sexField.setText(Pesel.getSex(this.userPesel));
        }else {
            this.peselField.setBackground(Color.red);
            this.dateField.setText("");
            this.sexField.setText("");
        }
    }
}
