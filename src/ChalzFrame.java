import javax.swing.*;
import java.awt.*;

public class ChalzFrame extends JFrame {

    ChalzFrame(){
        String local_dir = System.getProperty("user.dir");
        ImageIcon chalzIcon = new ImageIcon(local_dir + "\\..\\chalzIcon.png");

        this.setLayout(null);
        this.setSize(500,750);
        this.setTitle("Chalz");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(chalzIcon.getImage());
        this.getContentPane().setBackground(new Color(40, 40, 40));
        this.setVisible(true);
    }
}
