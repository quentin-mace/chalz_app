package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import static java.awt.Image.SCALE_SMOOTH;

public class GUI extends JFrame implements ActionListener {

    JButton start_button;
    JButton task_button;
    JButton save_button;
    JButton load_button;
    JButton quit_button;

    JPanel main_panel;
    JPanel menu_panel;
    JPanel tasks_panel;

    JScrollPane task_scroll;

    ChalzFrame scene;
    LoadFrame loader;
    NewTaskFrame task_maker;
    SaveFrame saver;

    List<Task> list_of_tasks;
    List<TaskPanel> list_of_task_panels;
    WindowListener exitFrame;

    GUI(List<Task> list_of_tasks) {

        exitFrame = getWindowAdapter();


        this.list_of_tasks = list_of_tasks;
        this.list_of_task_panels = new ArrayList<>();

        URL icon_url = getClass().getResource("/resources/chalzIcon.png");
        ImageIcon chalzIcon = new ImageIcon(icon_url);
        Image chalzImage = chalzIcon.getImage();
        Image chalzImageScaled = chalzImage.getScaledInstance(30, 30, SCALE_SMOOTH);
        chalzIcon.setImage(chalzImageScaled);

        JPanel title_panel = makeBorderPanel(new Color(108, 108, 108),420,100);
        main_panel = makeBorderPanel(new Color(77, 77, 77),420,120);
        menu_panel = makeNullPanel(new Color(51, 51, 51),420,130);
        tasks_panel = makeWrapPanel(new Color(77, 77, 77));
        task_scroll = new JScrollPane(tasks_panel);
        task_scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        task_scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        task_scroll.setOpaque(false);
        task_scroll.setBorder(null);


        JLabel startScreen_title = makeTitleLabel(chalzIcon);

        start_button = makeButton("Start !",145,50,210,30);


        scene = new ChalzFrame();
        title_panel.add(startScreen_title,BorderLayout.CENTER);
        menu_panel.add(start_button);
        main_panel.add(menu_panel, BorderLayout.NORTH);
        scene.add(title_panel,BorderLayout.NORTH);
        scene.add(main_panel,BorderLayout.CENTER);
    }

    private WindowAdapter getWindowAdapter() {
        return new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                enableScene();
            }
        };
    }

    private void makeMenu(){
        task_button = makeButton("New Task",85,30,150,30);
        save_button = makeButton("Save",265,30,150,30);
        load_button = makeButton("Load",85,70,150,30);
        quit_button = makeButton("Quit",265,70,150,30);

        menu_panel.add(task_button);
        menu_panel.add(save_button);
        menu_panel.add(load_button);
        menu_panel.add(quit_button);

        main_panel.add(task_scroll, BorderLayout.CENTER);

        menu_panel.repaint();
    }

    private void displayTasks() {
        clearDisplayedTasks();
        list_of_task_panels.clear();
        for (int i = 0; i < list_of_tasks.size(); i++) {
            list_of_task_panels.add(new TaskPanel(
                    list_of_tasks.get(i).title,
                    list_of_tasks.get(i).description,
                    list_of_tasks.get(i).deadline_date,
                    list_of_tasks.get(i).completed,
                    list_of_tasks.get(i).completion_date));
            list_of_task_panels.get(i).setTaskNumber(i);
            list_of_task_panels.get(i).delete_button.addActionListener(this);
            tasks_panel.add(list_of_task_panels.get(i));
        }
        this.task_scroll.revalidate();
        this.task_scroll.repaint();
    }

    private void clearDisplayedTasks(){
        for (int i = 0; i < list_of_task_panels.size(); i++) {
            tasks_panel.remove(list_of_task_panels.get(i));
        }
    }



    public JButton makeButton(String name, int x, int y, int width, int height) {
        JButton button = new JButton();
        button.setBounds(x,y,width,height);
        button.addActionListener(this);
        button.setFocusable(false);
        button.setText(name);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(width,height));
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setVisible(true);
        return button;
    }

    private static JPanel makeNullPanel(Color color, int width, int height) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(width, height));
        return panel;
    }

    private static JPanel makeWrapPanel(Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setLayout(new WrapLayout(FlowLayout.CENTER,10,20));
        //panel.setPreferredSize(new Dimension(width, height))
        return panel;
    }

    private static JPanel makeBorderPanel(Color color, int width, int height) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setPreferredSize(new Dimension(width, height));
        panel.setLayout(new BorderLayout());
        return panel;
    }

    private static JLabel makeTitleLabel(ImageIcon chalzIcon) {
        JLabel startScreen_title = new JLabel("Welcome to Chalz !");
        startScreen_title.setIcon(chalzIcon);
        startScreen_title.setHorizontalTextPosition(JLabel.CENTER);
        startScreen_title.setVerticalTextPosition(JLabel.TOP);
        startScreen_title.setForeground(new Color(49, 17, 0));
        startScreen_title.setFont(new Font("Ink Free",Font.BOLD,30));
        startScreen_title.setIconTextGap(0);
        startScreen_title.setBackground(new Color(182, 182, 182));
        startScreen_title.setOpaque(true);
        startScreen_title.setVerticalAlignment(JLabel.CENTER);
        startScreen_title.setHorizontalAlignment(JLabel.CENTER);
        startScreen_title.setBounds(10,10,400,100);
        return startScreen_title;
    }



    private void openLoaderMenu() throws ClassNotFoundException {
        scene.setEnabled(false);

        loader = new LoadFrame();
        loader.addWindowListener(exitFrame);
        loader.load_button.addActionListener(this);
        loader.cancel_button.addActionListener(this);
    }

    private void openNewTaskMenu() throws ClassNotFoundException {
        scene.setEnabled(false);

        task_maker = new NewTaskFrame();
        task_maker.addWindowListener(exitFrame);
        task_maker.create_button.addActionListener(this);
        task_maker.cancel_button.addActionListener(this);
    }

    private void openSaveMenu() throws ClassNotFoundException {
        scene.setEnabled(false);

        saver = new SaveFrame();
        saver.addWindowListener(exitFrame);
        saver.save_button.addActionListener(this);
        saver.cancel_button.addActionListener(this);
    }



    public void loadSaveFile(String save_name) throws ClassNotFoundException {
        list_of_tasks = new FileHandler().loadFromFile(save_name);
    }

    public void saveListToFile(){
        for (int i = 0; i < list_of_tasks.size(); i++) {
            list_of_tasks.get(i).completed = list_of_task_panels.get(i).completed;
            list_of_tasks.get(i).completion_date = list_of_task_panels.get(i).completion_date;
        }
        new FileHandler().saveToFile(list_of_tasks, saver.save_field.getText());
        enableScene();
    }

    private void setNewTask() {
        String title = task_maker.title_field.getText();
        String description = task_maker.description_field.getText();
        int deadline_day = Integer.parseInt(task_maker.day_field.getText());
        int deadline_month = Integer.parseInt(task_maker.month_field.getText());
        int deadline_year = Integer.parseInt(task_maker.year_field.getText());
        LocalDate deadline = LocalDate.of(deadline_year, deadline_month, deadline_day);
        Task new_task = new Task(title, description, deadline);
        list_of_tasks.add(new_task);
        enableScene();
        displayTasks();
    }

    private void showTasksList(){
        String titles = "";
        for (int i = 0; i < list_of_tasks.size(); i++) {
            titles = titles.concat(list_of_tasks.get(i).title);
        }
        JOptionPane.showMessageDialog(null, titles, "List of tasks",JOptionPane.PLAIN_MESSAGE);
    }



    public void enableScene(){
        scene.setEnabled(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start_button) {
            start_button.setVisible(false);
            menu_panel.remove(start_button);
            makeMenu();
        }

        if (e.getSource() == load_button) {
            try {
                openLoaderMenu();
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == task_button) {
            try {
                openNewTaskMenu();
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == quit_button) {
            System.exit(-1);
        }

        if (e.getSource() == save_button){
            try {
                openSaveMenu();
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }



        if (this.loader != null && e.getSource() == loader.load_button) {
            loader.result = loader.save_picker.getSelectedItem().toString();
            try {
                loadSaveFile(loader.result);
                enableScene();
                displayTasks();
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            loader.dispose();
        }

        if (this.loader != null && e.getSource() == loader.cancel_button) {
            loader.dispose();
            enableScene();
        }



        if (this.task_maker != null && e.getSource() == task_maker.create_button) {
            setNewTask();
            task_maker.dispose();
        }

        if (this.task_maker != null && e.getSource() == task_maker.cancel_button) {
            task_maker.dispose();
            enableScene();
        }



        if (this.saver != null && e.getSource() == saver.save_button) {
            saveListToFile();
            saver.dispose();
        }

        if (this.saver != null && e.getSource() == saver.cancel_button) {
            saver.dispose();
            enableScene();
        }


        for (int i =0; i<list_of_task_panels.size(); i++){
            if(e.getSource() == list_of_task_panels.get(i).delete_button){
                list_of_tasks.remove(i);
                displayTasks();
            }


        }
    }

}
