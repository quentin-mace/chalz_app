package main;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ChalzFrame extends JFrame {

    ChalzFrame(){
        URL icon_url = getClass().getResource("/resources/chalzIcon.png");
        ImageIcon chalzIcon = new ImageIcon(icon_url);

        this.setLayout(new BorderLayout());
        this.setSize(500,750);
        this.setTitle("Chalz");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(chalzIcon.getImage());
        this.getContentPane().setBackground(new Color(40, 40, 40));
        this.setVisible(true);
    }
}
