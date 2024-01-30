import javax.swing.*;
import java.awt.*;

public class TaskPanel extends JPanel{

    TaskPanel() {
        this.setBackground(new Color(227, 227, 227));
        this.setLayout(null);
        this.setPreferredSize(new Dimension(400, 100));
    }


    private static JLabel makeTaskName(String text) {
        JLabel task_name = new JLabel(text);
        task_name.setForeground(Color.BLACK);
        task_name.setFont(new Font("Arial",Font.BOLD,16));
        task_name.setVerticalAlignment(JLabel.CENTER);
        task_name.setHorizontalAlignment(JLabel.CENTER);
        task_name.setBounds(10,10,200,20);
        return task_name;
    }

    private static JLabel makeTaskDescription(String text) {
        JLabel task_name = new JLabel(text);
        task_name.setForeground(Color.BLACK);
        task_name.setFont(new Font("Arial",Font.BOLD,16));
        task_name.setVerticalAlignment(JLabel.TOP);
        task_name.setHorizontalAlignment(JLabel.WEST);
        task_name.setBounds(10,40,200,50);
        return task_name;
    }

}
