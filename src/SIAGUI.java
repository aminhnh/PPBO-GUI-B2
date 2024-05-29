import javax.swing.*;
import javax.swing.plaf.TabbedPaneUI;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SIAGUI extends JFrame {
    public SIAGUI(){
        setTitle("Sistem Informasi Akademik"); // Judul window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Jika window di close, main di close
        setSize(800,600); // Ukuran window
        setLocationRelativeTo(null); // Peletakan window ke tengah
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Text Fields
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new BorderLayout());

        JTextField namaTextField = new JTextField();
        JTextField nimTextField = new JTextField();
        JTextField prodiTextField = new JTextField();
        textFieldPanel.add(namaTextField, BorderLayout.NORTH);
        textFieldPanel.add(nimTextField, BorderLayout.CENTER);
        textFieldPanel.add(prodiTextField, BorderLayout.SOUTH);

        mainPanel.add(textFieldPanel, BorderLayout.NORTH);


        // Table
        // Model utk me-manage content dari table
        String[] kolom = {"Nama", "NIM", "Prodi"};
        DefaultTableModel model = new DefaultTableModel(kolom, 0);
        JTable tabel = new JTable(model);

        mainPanel.add(new JScrollPane(tabel), BorderLayout.CENTER);


        // Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton submitButton = new JButton("SUBMIT");
        JButton updateButton = new JButton("UPDATE");
        JButton deleteButton = new JButton("DELETE");
        buttonPanel.add(submitButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Insert data ke tabel
                String nama = namaTextField.getText();
                String nim = nimTextField.getText();
                String prodi = prodiTextField.getText();

                model.addRow(new Object[]{nama, nim, prodi});
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tabel.getSelectedRow();
                if (row != -1){
                    model.removeRow(row);
                }
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tabel.getSelectedRow();
                String newNama = namaTextField.getText();
                String newNim = nimTextField.getText();
                String newProdi = prodiTextField.getText();
                if (row != -1){
                    model.setValueAt(newNama, row, 0);
                    model.setValueAt(newNim, row, 1);
                    model.setValueAt(newProdi, row, 2);
                }
            }
        });
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);


        add(mainPanel);
        setVisible(true); // Pastikan di bawah
    }
}
