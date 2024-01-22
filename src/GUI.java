import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static java.awt.Image.SCALE_SMOOTH;

public class GUI {
    public static void main(String[] args) {
        String local_dir = System.getProperty("user.dir");
        ImageIcon chalzIcon = new ImageIcon(local_dir + "\\..\\chalzIcon.png");
        Image chalzImage = chalzIcon.getImage();
        Image chalzImageScaled = chalzImage.getScaledInstance(25, 25, SCALE_SMOOTH);
        chalzIcon.setImage(chalzImageScaled);
        Border title_border = BorderFactory.createLineBorder(new Color(138, 21, 0), 3);

        JLabel startScreen_title = new JLabel("Welcome to Chalz !");
        startScreen_title.setIcon(chalzIcon);
        startScreen_title.setHorizontalTextPosition(JLabel.CENTER);
        startScreen_title.setVerticalTextPosition(JLabel.TOP);
        startScreen_title.setForeground(new Color(234, 212, 119));
        startScreen_title.setFont(new Font("MV Boli",Font.PLAIN,20));
        startScreen_title.setIconTextGap(20);
        startScreen_title.setBackground(Color.BLACK);
        startScreen_title.setOpaque(true);
        startScreen_title.setBorder(title_border);
        startScreen_title.setVerticalAlignment(JLabel.CENTER);
        startScreen_title.setHorizontalAlignment(JLabel.CENTER);
        startScreen_title.setBounds(40,200,400,100);


        ChalzFrame scene = new ChalzFrame();
        scene.add(startScreen_title);
        //scene.pack();
    }


}
