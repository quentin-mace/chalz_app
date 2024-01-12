import java.time.LocalDateTime;
import java.time.LocalDate;

public class toDoApp {
	public static void main(String[] args) {
		System.out.println("Hello World !");
	}

	public static Task createTask() {
		
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