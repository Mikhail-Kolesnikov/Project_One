package back.service;

import back.dto.ResponseDto;
import back.entity.Task;
import back.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

public class FindTaskService {
    private TaskRepository repository;

    public FindTaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public ResponseDto<List<Task>> findAllTasks(){

        List<Task> allTasks = repository.findAll();

        if (allTasks.isEmpty()) {
            return new ResponseDto<>(205, allTasks, "Список задач пустой");
        } else {
            return new ResponseDto<>(200,allTasks,"");
        }
    }

    public ResponseDto<Task> findTaskById(Integer id){
        Optional<Task> foundedTask = repository.findById(id);

        if (foundedTask.isPresent()) {
            return new ResponseDto<>(200,foundedTask.get(),"");
        } else {
            return new ResponseDto<>(404,null,"Task with id = " + id + " not found");
        }
    }

    public ResponseDto<List<Task>> findByName(String name){
        List<Task> tasksByName = repository.findByName(name);

        if (tasksByName.isEmpty()){
            return new ResponseDto<>(404, tasksByName,"Tasks with name " + name + " not found");
        } else {
            return new ResponseDto<>(200, tasksByName, "");
        }

    }
}