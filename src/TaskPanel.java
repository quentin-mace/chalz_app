import javax.swing.*;
import java.awt.*;

public class TaskPanel extends JPanel{
    String title;
    String description;

    TaskPanel() {
        this.setBackground(new Color(227, 227, 227));
        this.setLayout(null);
        this.setPreferredSize(new Dimension(400, 100));
        JLabel task_name = makeTaskName(title);
        JLabel task_description = makeTaskDescription(description);
        this.add(task_name);
        this.add(task_description);
    }


    private JLabel makeTaskName(String text) {
        JLabel task_name = new JLabel(text);
        task_name.setForeground(Color.BLACK);
        task_name.setFont(new Font("Arial",Font.BOLD,16));
        task_name.setVerticalAlignment(JLabel.CENTER);
        task_name.setHorizontalAlignment(JLabel.CENTER);
        task_name.setBounds(10,10,200,20);
        return task_name;
    }

    private JLabel makeTaskDescription(String text) {
        JLabel task_name = new JLabel(text);
        task_name.setForeground(Color.BLACK);
        task_name.setFont(new Font("Arial",Font.BOLD,16));
        task_name.setVerticalAlignment(JLabel.TOP);
        task_name.setHorizontalAlignment(JLabel.WEST);
        task_name.setBounds(10,40,200,50);
        return task_name;
    }

}
