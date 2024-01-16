import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.*;

public class toDoApp {
	public static void main(String[] args) {
		List<Task> list_of_tasks = new ArrayList<Task>();
		list_of_tasks.add(createTask());
		completeTask(list_of_tasks);
		displayTasks(list_of_tasks);
	}

	public static void completeTask(List<Task> list_of_tasks){
		Scanner ask_user = new Scanner(System.in);
		System.out.println("Which task do you wish to complete ?");
		int number_entered = ask_user.nextInt();
		int task_number = number_entered-1;
		list_of_tasks.get(task_number).completed = true;
		list_of_tasks.get(task_number).completion_date = LocalDateTime.now();		
	}

	public static void displayTasks(List<Task> list_of_tasks){
		int list_length = list_of_tasks.size();
		for (int i = 0; i<list_length ; i++) {
			String completion_checker = " ";
			String completion_date = "";
			int task_number = i+1;

			String creation_date_day = String.format("%02d",list_of_tasks.get(i).creation_date.getDayOfMonth());
			String creation_date_month = String.format("%02d",list_of_tasks.get(i).creation_date.getMonthValue());
			String creation_date_year = String.valueOf(list_of_tasks.get(i).creation_date.getYear());
			String creation_date_hour = String.valueOf(list_of_tasks.get(i).creation_date.getHour());
			String creation_date_minute = String.valueOf(list_of_tasks.get(i).creation_date.getMinute());

			String completion_date_day = String.format("%02d",list_of_tasks.get(i).completion_date.getDayOfMonth());
			String completion_date_month = String.format("%02d",list_of_tasks.get(i).completion_date.getMonthValue());
			String completion_date_year = String.valueOf(list_of_tasks.get(i).completion_date.getYear());
			String completion_date_hour = String.valueOf(list_of_tasks.get(i).completion_date.getHour());
			String completion_date_minute = String.valueOf(list_of_tasks.get(i).completion_date.getMinute());

			String deadline_date_day = String.format("%02d",list_of_tasks.get(i).deadline_date.getDayOfMonth());
			String deadline_date_month = String.format("%02d",list_of_tasks.get(i).deadline_date.getMonthValue());
			String deadline_date_year = String.valueOf(list_of_tasks.get(i).deadline_date.getYear());

			if (list_of_tasks.get(i).completed){
				completion_checker = "x";
				completion_date = " the " + completion_date_day +"/"+ completion_date_month +"/"+ completion_date_year +" "+ completion_date_hour +":"+ completion_date_minute;
			}
			System.out.println("#################################################################################");
			System.out.print(task_number + ". Title : ");
			System.out.print(list_of_tasks.get(i).title);
			System.out.println("                     Creation : " + creation_date_day +"/"+ creation_date_month +"/"+ creation_date_year +" "+ creation_date_hour +":"+ creation_date_minute);
			System.out.print("Description: ");
			System.out.print(list_of_tasks.get(i).description);
			System.out.println("    Completed : ["+completion_checker+"]"+completion_date);
			System.out.print("Deadline : ");
			System.out.println(deadline_date_day +"/"+ deadline_date_month +"/"+ deadline_date_year);
			System.out.println("#################################################################################");
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