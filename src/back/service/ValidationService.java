package back.service;

import back.dto.RequestDto;

public class ValidationService {
    public String validate(RequestDto request){
        String message = "";

        if (request.getName().isBlank()){
            message = message + "Название задачи не может быть пустым\n";
        }

        if (request.getName().length() < 5){
            message = message + "Длина названия задачи не может быть менее 5 символов\n";
        }

        if (request.getName().length() > 15){
            message = message + "Длина названия задачи не может быть более 15 символов\n";
        }

        if (request.getDescription().isBlank()){
            message = message + "Описание задачи не может быть пустым\n";
        }

        return message;


    }
}