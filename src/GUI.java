import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Image.SCALE_SMOOTH;

public class GUI extends JFrame implements ActionListener {
    JButton start_button;

    public static void main(String[] args) {
        new GUI();
    }
    GUI() {
        String local_dir = System.getProperty("user.dir");
        ImageIcon chalzIcon = new ImageIcon(local_dir + "\\..\\chalzIcon.png");
        Image chalzImage = chalzIcon.getImage();
        Image chalzImageScaled = chalzImage.getScaledInstance(35, 35, SCALE_SMOOTH);
        Image chalzImageSmall = chalzImage.getScaledInstance(15, 15, SCALE_SMOOTH);
        chalzIcon.setImage(chalzImageScaled);
        ImageIcon chalzIconSmall = new ImageIcon(chalzImageSmall);
        Border title_border = BorderFactory.createLineBorder(new Color(138, 21, 0), 0);

        JPanel title_panel = getjPanel(new Color(108, 108, 108),34,30,420,120);

        JPanel menu_panel = getjPanel(new Color(65, 65, 65),34,150,420,530);

        JLabel startScreen_title = getjLabel(chalzIcon, title_border);

        start_button = new JButton();
        start_button.setBounds(105,250,210,30);
        start_button.addActionListener(this);
        start_button.setFocusable(false);
        start_button.setIcon(chalzIconSmall);
        start_button.setText("Start !");
        start_button.setBackground(Color.BLACK);
        start_button.setForeground(Color.WHITE);
        start_button.setBorder(BorderFactory.createEtchedBorder());


        ChalzFrame scene = new ChalzFrame();
        title_panel.add(startScreen_title);
        menu_panel.add(start_button);
        scene.add(title_panel);
        scene.add(menu_panel);
        //scene.pack();
    }

    private static JPanel getjPanel(Color color, int x, int y, int width, int height) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setBounds(x,y,width,height);
        panel.setLayout(null);
        return panel;
    }

    private static JLabel getjLabel(ImageIcon chalzIcon, Border title_border) {
        JLabel startScreen_title = new JLabel("Welcome to Chalz !");
        startScreen_title.setIcon(chalzIcon);
        startScreen_title.setHorizontalTextPosition(JLabel.CENTER);
        startScreen_title.setVerticalTextPosition(JLabel.TOP);
        startScreen_title.setForeground(new Color(49, 17, 0));
        startScreen_title.setFont(new Font("Ink Free",Font.BOLD,30));
        startScreen_title.setIconTextGap(0);
        startScreen_title.setBackground(new Color(182, 182, 182));
        startScreen_title.setOpaque(true);
        startScreen_title.setBorder(title_border);
        startScreen_title.setVerticalAlignment(JLabel.CENTER);
        startScreen_title.setHorizontalAlignment(JLabel.CENTER);
        startScreen_title.setBounds(10,10,400,100);
        return startScreen_title;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start_button) {
            System.out.println("Start !");
        }
    }
}
