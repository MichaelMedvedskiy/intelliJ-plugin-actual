import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

public class TrelloPluginForm  {

    private TrelloProjectKostil kostil;
    private JButton submitYourDataButton;
    private JTextField trelloKeyField;
    private JTextField trelloAccessTokenField;
    private JTextField listIdField;
    private JButton helpButton;
    private JPanel mainPanel;



    public TrelloPluginForm() {
        //initializing the fields
        kostil = new TrelloProjectKostil();
        trelloKeyField.setText(kostil.getTrelloKey());
        trelloAccessTokenField.setText(kostil.getTrelloAccessToken());
        listIdField.setText(kostil.getListId());

        //setting listeners for buttons
        submitYourDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                kostil.setTrelloKey(trelloKeyField.getText());
                kostil.setTrelloAccessToken(trelloAccessTokenField.getText());
                kostil.setListId(listIdField.getText());


            }
        });

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessageDialog(null,"" +
                        "So, you might ask, where do I get all these fields? \n" +
                        "Rather simple, for Key and Token go to " +
                        "https://trello.com/app-key\n" +
                        "These parameters represent your Trello account\n" +
                        "According to them you will or will not be able" +
                        " to post cards to different \n" +
                        "For the list " +
                        "https://customer.io/actions/trello/\n" +
                        "here is a way to get it");
            }
        });

    }

    public static void main(String[] args) {
        TrelloPluginForm form = new TrelloPluginForm();
        JFrame frame = new JFrame("Set you data");
        //form.mainPanel.setSize(800,400);
        frame.setContentPane(form.mainPanel);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        frame.setPreferredSize(new Dimension(600, 400));
        frame.pack();
        //frame.setPreferredSize(new Dimension(800,400));
        frame.setVisible(true);
    }
}
