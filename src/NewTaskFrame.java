import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewTaskFrame extends JFrame implements ActionListener {
    JTextField title_field;
    JTextArea description_field;

    JButton create_button;
    JButton cancel_button;

    NewTaskFrame(){

        String local_dir = System.getProperty("user.dir");
        ImageIcon chalzIcon = new ImageIcon(local_dir + "\\..\\chalzIcon.png");

        this.setLayout(null);
        this.setSize(250,280);
        this.setTitle("New Task");
        this.setResizable(false);
        this.setIconImage(chalzIcon.getImage());
        this.getContentPane().setBackground(new Color(199, 199, 199));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel ask_title = textLabel("Title of your task :",10,10,200,20);
        title_field = makeTextField("Title", 10, 40, 200, 20);
        JLabel description_title = textLabel("Description :",10,70,200,20);
        description_field = makeTextArea("Description", 10, 100, 200, -1);
        description_field.setLineWrap(true);
        create_button = makeButton("Create", 10,210,100,20);
        cancel_button = makeButton("Cancel", 120,210,100,20);
        JScrollPane description_scroll = new JScrollPane(description_field);
        description_scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        description_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        description_scroll.setBounds(10, 100, 200, 100);



        this.add(ask_title);
        this.add(title_field);
        this.add(description_title);
        this.add(description_scroll);
        this.add(create_button);
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

    public JLabel textLabel (String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial",Font.PLAIN,10));
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(x,y,width,height);
        return label;
    }

    public JTextField makeTextField(String message, int x, int y, int width, int height){
        JTextField field = new JTextField(message);
        field.setBounds(x,y,width,height);
        return field;
    }

    public JTextArea makeTextArea(String message, int x, int y, int width, int height){
        JTextArea field = new JTextArea(message);
        field.setBounds(x,y,width,height);
        return field;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
