package front.menu;

import back.dto.RequestDto;
import back.dto.ResponseDto;
import back.entity.Task;
import back.service.AddTaskService;
import back.service.DeleteTaskService;
import back.service.FindTaskService;

import java.util.List;

public class UserMenu {

    private AddTaskService addTaskService;
    private FindTaskService findTaskService;
    private UserInput userInput;
    private DeleteTaskService deleteTaskService;


    public UserMenu(AddTaskService addTaskService, FindTaskService findTaskService, UserInput userInput, DeleteTaskService deleteTaskService) {
        this.addTaskService = addTaskService;
        this.findTaskService = findTaskService;
        this.userInput = userInput;
        this.deleteTaskService = deleteTaskService;
    }

    public UserMenu(AddTaskService addTaskService, FindTaskService findTaskService, UserInput userInput) {
        this.addTaskService = addTaskService;
        this.findTaskService = findTaskService;
        this.userInput = userInput;
    }

    public void menu(){

        while (true){

            // печать меню
            printMenu();

            int choice = userInput.userInt("Выберите пункт меню: ");

            switch (choice) {
                case 1 -> addNewTask();
                case 2 -> findAllTasks();
                case 3 -> findTaskById();
                case 4 -> findTasksByName();
                case 5 -> deleteTaskById();
                case 6 -> updateTaskById();
                case 7 -> { return;}
                default -> System.out.println("Incorrect ...");
            }
        }
    }

    //------------------ внутренние метода menu --------

    private void updateTaskById() {
        System.out.println("Пока не работает");
    }

    private void deleteTaskById() {
        System.out.println("Удаление задачи по ID");

        int taskIDForDelete = userInput.userInt("Введите ID задачи для удаления:");
        ResponseDto<Task> response = deleteTaskService.deleteTaskById(taskIDForDelete);

        if (response.getResponseMessage().isEmpty()) {
            System.out.println("Код ответа: " + response.getResponseCode());
            System.out.println(response.getResponseBody());
        } else {
            System.out.println("Код ответа: " + response.getResponseCode());
            System.out.println(response.getResponseMessage());
        }
    }


    private void findTasksByName() {

        System.out.println("Поиск задач по названию");

        String taskNameForSearch = userInput.userText("Введите название задачи:");
        ResponseDto<List<Task>> response = findTaskService.findByName(taskNameForSearch);

        if (response.getResponseMessage().isEmpty()){
            System.out.println("Код ответа: " + response.getResponseCode());
            System.out.println(response.getResponseBody());
        } else {
            System.out.println("Код ответа: " + response.getResponseCode());
            System.out.println(response.getResponseMessage());
        }
    }

    private void findTaskById() {
        System.out.println("Поиск задач по ID");

        int taskIDForSearch = userInput.userInt("Введите ID задачи:");
        ResponseDto<Task> response = findTaskService.findTaskById(taskIDForSearch);

        if (response.getResponseMessage().isEmpty()){
            System.out.println("Код ответа: " + response.getResponseCode());
            System.out.println(response.getResponseBody());
        } else {
            System.out.println("Код ответа: " + response.getResponseCode());
            System.out.println(response.getResponseMessage());
        }
    }

    private void findAllTasks() {
        System.out.println("Список всех задач");
        ResponseDto<List<Task>> response = findTaskService.findAllTasks();

        if (response.getResponseMessage().isEmpty()){
            System.out.println("Код ответа: " + response.getResponseCode());
            for (Task currentTask : response.getResponseBody()){
                System.out.println(currentTask);
            }

        } else {
            System.out.println("Код ответа: " + response.getResponseCode());
            System.out.println(response.getResponseMessage());
        }

    }

    private void addNewTask() {

        System.out.println("Ввод новой задачи:");
        String taskName = userInput.userText("Введите название задачи: ");
        String taskDescription = userInput.userText("Введите описание задачи:");

        RequestDto request = new RequestDto(taskName, taskDescription);

        ResponseDto<Task> response = addTaskService.createNewTask(request);

        if (response.getResponseMessage().isEmpty()){
            System.out.println("Код ответа: " + response.getResponseCode());
            System.out.println(response.getResponseBody());
        } else {
            System.out.println("Код ответа: " + response.getResponseCode());
            System.out.println(response.getResponseMessage());
        }

    }



    private void printMenu() {
        System.out.println("-------------");
        System.out.println("User menu:");
        System.out.println("1. Add new task");
        System.out.println("2. Find all tasks");
        System.out.println("3. Find task by ID");
        System.out.println("4. Find tasks by name");
        System.out.println("5. Delete task by ID");
        System.out.println("6. Update task by ID");
        System.out.println("7. Exit");

    }


}