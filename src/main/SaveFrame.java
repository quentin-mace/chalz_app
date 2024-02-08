package main;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class SaveFrame extends JFrame {
    JTextField save_field;
    JButton save_button;
    JButton cancel_button;
    SaveFrame(){
        URL icon_url = getClass().getResource("/resources/chalzIcon.png");
        ImageIcon chalzIcon = new ImageIcon(icon_url);

        this.setLayout(null);
        this.setSize(250,140);
        this.setTitle("Load");
        this.setResizable(false);
        this.setIconImage(chalzIcon.getImage());
        this.getContentPane().setBackground(new Color(199, 199, 199));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel ask_save_name = makeTextLabel("How do you want to call your save ?");
        save_field = makeTextField("MySave", 10, 40, 200, 20);
        save_button = makeButton("Save", 10,70,100,20);
        cancel_button = makeButton("Cancel", 120,70,100,20);

        this.add(ask_save_name);
        this.add(save_field);
        this.add(save_button);
        this.add(cancel_button);
    }

    public JButton makeButton(String name, int x, int y, int width, int height) {
        JButton button = new JButton();
        button.setBounds(x,y,width,height);
        button.setFocusable(false);
        button.setText(name);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(width,height));
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setVisible(true);
        return button;
    }

    public JLabel makeTextLabel (String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial",Font.PLAIN,10));
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(10,10,200,20);
        return label;
    }

    public JTextField makeTextField(String message, int x, int y, int width, int height){
        JTextField field = new JTextField(message);
        field.setBounds(x,y,width,height);
        return field;
    }
}
