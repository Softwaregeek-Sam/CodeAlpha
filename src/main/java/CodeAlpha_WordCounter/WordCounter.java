package CodeAlpha_WordCounter;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter extends JFrame {
    private final JTextArea textArea;
    private final JButton countButton;
    private final JLabel resultLabel;

    public WordCounter() {

        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());


        countButton = new JButton("Count Words");
        panel.add(countButton, BorderLayout.NORTH);


        resultLabel = new JLabel("Word Count: 0");
        panel.add(resultLabel, BorderLayout.SOUTH);

        add(panel, BorderLayout.SOUTH);


        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                System.out.println("Text: " + text);
                int wordCount = countWords(text);
                System.out.println("Word Count: " + wordCount);
                resultLabel.setText("Word Count: " + wordCount);
            }
        });
    }


    private int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCounter().setVisible(true);
            }
        });
    }
}
