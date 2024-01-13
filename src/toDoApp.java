import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.*;

public class toDoApp {
	public static void main(String[] args) {
		List<Task> list_of_tasks = new ArrayList<Task>();
		list_of_tasks.add(createTask());

		System.out.println("Titre de la tâche :");
		System.out.println(list_of_tasks.get(0).title);
		System.out.println("Description de la tâche :");
		System.out.println(list_of_tasks.get(0).description);
		System.out.println("Date de création de la tâche :");
		System.out.println(list_of_tasks.get(0).creation_date.toString());
		System.out.println("La tâche est-elle completée :");
		System.out.println(list_of_tasks.get(0).completed);
		System.out.println("Date de complétion de la tâche :");
		System.out.println(list_of_tasks.get(0).completion_date.toString());
		System.out.println("Deadline de la tâche :");
		System.out.println(list_of_tasks.get(0).deadline_date.toString());
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