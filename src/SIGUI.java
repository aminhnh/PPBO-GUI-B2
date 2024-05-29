import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SIGUI extends JFrame {
    public SIGUI(){
        setTitle("Sistem Informasi"); // Judul window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Jika window di close, main di close
        setSize(800,600); // Ukuran window
        setLocationRelativeTo(null); // Peletakan window ke tengah
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label1 = new JLabel("Label 1");
        JLabel label2 = new JLabel("Label 2");
        JLabel label3 = new JLabel("Label 3");

        panel.add(label1, BorderLayout.NORTH);
        panel.add(label2, BorderLayout.EAST);
        panel.add(label3, BorderLayout.SOUTH);

        JButton closeButton = new JButton();
        closeButton.setText("CLOSE");
        panel.add(closeButton, BorderLayout.EAST);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JButton openButton = new JButton();
        openButton.setText("OPEN");
        panel.add(openButton, BorderLayout.CENTER);
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GameGUI();
            }
        });

        add(panel);


        setVisible(true); // Pastikan di bawah
    }
}
