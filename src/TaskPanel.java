import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskPanel extends JPanel implements ActionListener {
    String title;
    String description;
    LocalDateTime creation_date;
    Boolean completed;
    LocalDateTime completion_date;
    LocalDate deadline_date;

    private JLabel task_name;
    private JLabel task_deadline;
    private JTextArea task_description;
    private JButton delete_button;

    TaskPanel(String title, String description, LocalDate deadline_date) {
        this.setBackground(new Color(227, 227, 227));
        this.setLayout(null);
        this.setPreferredSize(new Dimension(400, 160));
        this.creation_date = LocalDateTime.now();
        this.completed = false;
        this.completion_date = LocalDateTime.now();
        this.deadline_date = deadline_date;

        this.title = title;
        this.description = description;

        this.task_name = makeTaskName(title);
        this.task_description = makeTaskDescription(description);
        this.task_deadline = makeDeadlineLabel(getDateString(deadline_date));
        this.delete_button = makeCloseButton();

        JScrollPane description_scroll = new JScrollPane(task_description);
        description_scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        description_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        description_scroll.setOpaque(false);
        description_scroll.setBorder(null);
        description_scroll.setBackground(new Color(227, 227, 227));
        description_scroll.setBounds(10,40,330,80);

        this.add(task_deadline);
        this.add(task_name);
        this.add(description_scroll);
        this.add(delete_button);
    }

    public void setName(String name){
        task_name = makeTaskName(name);
    }

    public void setDescription(String description){
        task_description = makeTaskDescription(description);
    }

    public void setDeadline(LocalDate date){
        task_name = makeDeadlineLabel(getDateString(date));
    }

    private JLabel makeTaskName(String text) {
        JLabel task_name = new JLabel(text);
        task_name.setForeground(Color.BLACK);
        task_name.setFont(new Font("Arial",Font.BOLD,16));
        task_name.setBounds(10,10,200,20);
        return task_name;
    }

    private JTextArea makeTaskDescription(String text) {
        JTextArea description_name = new JTextArea(text);
        description_name.setLineWrap(true);
        description_name.setEditable(false);
        description_name.setCursor(null);
        description_name.setOpaque(false);
        description_name.setFocusable(false);
        description_name.setWrapStyleWord(true);
        description_name.setForeground(Color.BLACK);
        description_name.setFont(new Font("Arial",Font.TRUETYPE_FONT,16));
        description_name.setBounds(10,40,350,-1);
        return description_name;
    }

    private JLabel makeDeadlineLabel(String date_string) {
        JLabel task_name = new JLabel("Deadline : " + date_string);
        task_name.setForeground(Color.BLACK);
        task_name.setFont(new Font("Arial",Font.TRUETYPE_FONT,16));
        task_name.setBounds(10,130,200,20);
        return task_name;
    }

    private String getDateString(LocalDate date){
        String day = String.format("%02d",date.getDayOfMonth());
        String month = String.format("%02d",date.getMonthValue());
        String year = String.valueOf(date.getYear());
        return day + "/" + month + "/" + year;
    }

    private String getDateString(LocalDateTime date){
        String day = String.format("%02d",date.getDayOfMonth());
        String month = String.format("%02d",date.getMonthValue());
        String year = String.valueOf(date.getYear());
        return day + "/" + month + "/" + year;
    }

    private JButton makeCloseButton(){
        JButton button = new JButton();
        button.setBounds(370,10,20,20);
        button.setFocusable(false);
        button.addActionListener(this);
        button.setText("x");
        button.setBackground(Color.red);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setVisible(true);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
