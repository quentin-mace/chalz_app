import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LoadFrame extends JFrame implements ActionListener {
    String result;
    JComboBox save_picker;
    JButton load_button;
    JButton cancel_button;
    LoadFrame(){
        List<String> file_names = new FileHandler().listFilesInFolder();
        String[] names = new String[file_names.size()];
        names = file_names.toArray(names);

        String local_dir = System.getProperty("user.dir");
        ImageIcon chalzIcon = new ImageIcon(local_dir + "\\..\\chalzIcon.png");

        this.setLayout(null);
        this.setSize(250,140);
        this.setTitle("Load");
        this.setResizable(false);
        this.setIconImage(chalzIcon.getImage());
        this.getContentPane().setBackground(new Color(199, 199, 199));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel ask_save = textLabel("Which save do you want to load ?");
        save_picker = choice(names);
        load_button = makeButton("Load", 10,70,100,20);
        cancel_button = makeButton("Cancel", 120,70,100,20);




        this.add(ask_save);
        this.add(save_picker);
        this.add(load_button);
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

    public static JLabel textLabel (String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial",Font.PLAIN,10));
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(10,10,200,20);
        return label;
    }

    public static JComboBox choice (String[] list){
        JComboBox combo_box = new JComboBox(list);
        combo_box.setBounds(10, 40, 200, 20);
        return combo_box;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
