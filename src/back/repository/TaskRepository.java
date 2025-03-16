package back.repository;

import back.entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepository {

    private List<Task> database;
    private Integer taskIdCounter = 0;

    public TaskRepository() {
        this.database = new ArrayList<>();
    }

    public Task addTask(Task task){
        // в момент вызова метода addTask в объекте task, который нам передали
        // будут заполнены ТОЛЬКО два поля: name и description
        //        task.setTaskId(++taskIdCounter);
        //        database.add(task);
        //        return task;

        Task taskForSave = new Task(++taskIdCounter, task.getName(), task.getDescription());
        database.add(taskForSave);
        return taskForSave;
    }

    public Optional<Task> findById(Integer taskId){
//       for (Task currentTask : database){
//           if (currentTask.getTaskId().equals(taskId)){
//               return Optional.of(currentTask);
//           }
//       }
//
//       return Optional.empty();

        return database.stream()
                .filter(task -> task.getTaskId().equals(taskId))
                .findFirst();

    }

    public List<Task> findByName(String name){
        // вариант 1 с циклами

//        List<Task> foundedTasks = new ArrayList<>();
//
//        for (Task currentTask : database){
//            if (currentTask.getName().equals(name)){
//                foundedTasks.add(currentTask);
//            }
//        }
//        return foundedTasks;

        // вариант 2 Stream API

        return database.stream()
                .filter(task -> task.getName().equals(name))
                .toList();

    }


    public Optional<Task> deleteById(Integer taskId){
        Optional<Task> optionalTask = findById(taskId);

        if (optionalTask.isPresent()){
            Task taskForDelete = optionalTask.get();
            database.remove(taskForDelete);
        }

        return optionalTask;
    }

    public List<Task> findAll(){
        return database;
    }



}
