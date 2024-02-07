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
    int task_number;

    private JLabel task_name;
    private JLabel task_deadline;
    private JTextArea task_description;
    private JCheckBox completed_box;
    private JLabel completion_label;
    JButton delete_button;

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
        this.completed_box = makeCompletedBox();

        JScrollPane description_scroll = new JScrollPane(task_description);
        description_scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        description_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        description_scroll.setOpaque(false);
        description_scroll.setBorder(null);
        description_scroll.setBackground(new Color(227, 227, 227));
        description_scroll.setBounds(10,40,350,80);

        this.add(completed_box);
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

    public void setTaskNumber(int number){
        this.task_number = number;
    }



    public int getTaskNumber(){return this.task_number;}

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

    private JLabel makeCompletionLabel(String date_string) {
        JLabel label = new JLabel(" the " + date_string);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial",Font.TRUETYPE_FONT,12));
        label.setBounds(300,130,100,20);
        return label;
    }

    private JCheckBox makeCompletedBox(){
        JCheckBox box = new JCheckBox();
        box.setText("Completed : ");
        box.setFocusable(false);
        box.addActionListener(this);
        box.setHorizontalTextPosition(SwingConstants.LEFT);
        box.setBounds(200,130,100,20);
        return box;
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

    private void checkCompleteTask(){
        this.completion_date = LocalDateTime.now();
        String date_label = getDateString(completion_date);
        completion_label = makeCompletionLabel(date_label);
        this.add(completion_label);
        this.revalidate();
        this.repaint();
    }

    private void uncheckCompleteTask(){
        this.remove(completion_label);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == completed_box){
            if (completed_box.isSelected()){
                checkCompleteTask();
            }
            if(!completed_box.isSelected()){
                uncheckCompleteTask();
            }
        }
    }
}
