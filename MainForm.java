import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
    private JPanel panel1;
    private JTextArea Output;
    private JTextField textField1;
    private JTextField textField2;
    private JButton StartBtn;
    private JButton StopBtn;
    private JLabel Checked;
    private JLabel Found;
    private JLabel Time;
    private Searcher searcher;

    public MainForm() {
        getStopBtn().setEnabled(false);
        StartBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searcher = new Searcher(MainForm.this);
                searcher.start();
            }
        });
        StopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searcher.stop();
                StartBtn.setEnabled(true);
                getStopBtn().setEnabled(false);
            }
        });
    }

    public JTextArea getOutput() {
        return Output;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JLabel getTime() {
        return Time;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public JButton getStartBtn() {
        return StartBtn;
    }

    public JButton getStopBtn() {
        return StopBtn;
    }

    public JLabel getChecked() {
        return Checked;
    }

    public JLabel getFound() {
        return Found;
    }
}
