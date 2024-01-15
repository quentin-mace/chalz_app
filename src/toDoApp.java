import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.*;

public class toDoApp {
	public static void main(String[] args) {
		List<Task> list_of_tasks = new ArrayList<Task>();
		list_of_tasks.add(createTask());
		displayTasks(list_of_tasks);
	}

	public static void displayTasks(List<Task> list_of_tasks){
		int list_length = list_of_tasks.size();
		for (int i = 0; i<list_length ; i++) {
			String completion_checker = " ";
			String completion_date = "";
			if (list_of_tasks.get(i).completed){
				completion_checker = "x";
				completion_date = " the " + list_of_tasks.get(i).completion_date.toString();
			}
			System.out.println("#####################################################");
			System.out.print("Title :");
			System.out.print(list_of_tasks.get(i).title);
			System.out.print("                     Creation :");
			System.out.println(list_of_tasks.get(i).creation_date.toString());
			System.out.print("Description:");
			System.out.print(list_of_tasks.get(i).description);
			System.out.println("    Completed : ["+completion_checker+"]"+completion_date);
			System.out.print("Deadline :");
			System.out.println(list_of_tasks.get(i).deadline_date.toString());
			System.out.println("#####################################################");
			System.out.println("");
		}
	}

	public static Task createTask() {
		Scanner ask_user = new Scanner(System.in);
		System.out.println("What's the name of your task ?");
		String title = ask_user.nextLine();
		System.out.println("What's the description of your task ?");
		String description = ask_user.nextLine();
		System.out.println("What's the deadline of your task ?(DD/MM/YYYY)");
		String deadline_string = ask_user.nextLine();
		String[] deadline_splitted = deadline_string.split("/");
		int day = Integer.parseInt(deadline_splitted[0]);
		int month = Integer.parseInt(deadline_splitted[1]);
		int year = Integer.parseInt(deadline_splitted[2]);
		LocalDate deadline_date = LocalDate.of(year, month, day);
		Task task_created = new Task(title, description, deadline_date);
		return task_created;
	}
}

class Task {
	String title;
	String description;
	LocalDateTime creation_date;
	Boolean completed;
	LocalDateTime completion_date;
	LocalDate deadline_date;
	Task(String title, String description, LocalDate deadline_date) {
		this.title = title;
		this.description = description;
		this.creation_date = LocalDateTime.now();
		this.completed = false;
		this.completion_date = LocalDateTime.now();
		this.deadline_date = deadline_date;
	}
}