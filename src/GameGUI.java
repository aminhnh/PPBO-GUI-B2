import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameGUI extends JFrame {
    private JLabel backgroundLabel;
    private JLabel characterLabel;
    private JLabel textLabel;
    private int characterX;
    private int characterY;

    public GameGUI(){
        setTitle("Game Zombie"); // Judul window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Jika window di close, JFrame di close
        setSize(800,600); // Ukuran window
        setLocationRelativeTo(null); // Peletakan window ke tengah
        setResizable(false);

        characterX = 100;
        characterY = 100;


        // Masukkan image ke labe > setbounds > add label;
        ImageIcon backgroundImage = new ImageIcon("src/assets/background.jpeg");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0,0,800,600);
        add(backgroundLabel);

        ImageIcon characterImage = new ImageIcon("src/assets/character.png");
        characterLabel = new JLabel(characterImage);
        characterLabel.setBounds(characterX,characterY,100,167);

        backgroundLabel.add(characterLabel);

        textLabel = new JLabel("Hello, welcome to my game!");
        textLabel.setFont(new Font("Arial", Font.BOLD, 24));
        textLabel.setForeground(Color.BLACK);
        textLabel.setBounds(350, 200, 400, 30);
        backgroundLabel.add(textLabel);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode){
                    case KeyEvent.VK_UP :
                        characterY -= 10;
                        break;
                    case  KeyEvent.VK_DOWN:
                        characterY += 10;
                        break;
                    case KeyEvent.VK_LEFT:
                        characterX -= 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        characterX += 10;
                        break;
                    default:
                        break;
                }
                characterLabel.setLocation(characterX,characterY);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        setVisible(true); // Pastikan di bawah
    }
}
