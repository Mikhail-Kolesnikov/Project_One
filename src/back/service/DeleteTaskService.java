package back.service;

import back.dto.ResponseDto;
import back.entity.Task;
import back.repository.TaskRepository;

import java.util.Optional;

public class DeleteTaskService {

    private final TaskRepository repository;

    public DeleteTaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public ResponseDto<Task> deleteTaskById(Integer taskId) {
        Optional<Task> taskForDelete = repository.deleteById(taskId);

        if (taskForDelete.isPresent()) {
            return new ResponseDto<>(200, taskForDelete.get(), "Задача удалена успешно");
        } else {
            return new ResponseDto<>(404, null, "Задача с ID " + taskId + " не найдена");
        }
    }
}

