import back.repository.TaskRepository;
import back.service.AddTaskService;
import back.service.DeleteTaskService;
import back.service.FindTaskService;
import back.service.ValidationService;
import front.menu.UserInput;
import front.menu.UserMenu;

public class TaskApp {
    public static void main(String[] args) {

        TaskRepository repository = new TaskRepository();
        ValidationService validationService = new ValidationService();

        AddTaskService addTaskService = new AddTaskService(repository,validationService);
        FindTaskService findTaskService = new FindTaskService(repository);
        DeleteTaskService deleteTaskService = new DeleteTaskService(repository);
        UserInput userInput = new UserInput();

        UserMenu userMenu = new UserMenu(addTaskService,findTaskService,userInput,deleteTaskService);

        userMenu.menu();

    }
}