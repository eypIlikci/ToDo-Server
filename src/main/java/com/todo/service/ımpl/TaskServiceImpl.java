package com.todo.service.ımpl;

import com.todo.dto.CreateTaskDto;
import com.todo.dto.TaskDto;
import com.todo.entity.Task;
import com.todo.entity.User;
import com.todo.error.InconsistenValuesException;
import com.todo.repository.TaskRepository;
import com.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {


    private TaskRepository taskRepository;
    private User auth;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {

        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskDto> findTasksByUser() {
        User authUser= (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        List<Task> tasks=taskRepository.findTasksByUser(authUser);
        if (tasks.size()>0){
            List<TaskDto> taskDtos=new ArrayList<>();
            for (Task task:tasks) {
                taskDtos.add(TaskDto.taskConvertToTaskDto(task));
            }
            return taskDtos;
        }
        return null;
    }

    @Override
    public TaskDto save(CreateTaskDto taskDto) {
        Task newTask=taskDto.cloneTask();
        newTask.setUser(getAuth());
        Task task=taskRepository.save(newTask);
        return TaskDto.taskConvertToTaskDto(task);
    }

    @Override
    public void  deleteById(Long id){
        try {
            Task task=taskRepository.findById(id).get();
            if (task!=null && task.getUser().getId()==getAuth().getId()){
                taskRepository.delete(task);
            }else{
               throw new Exception();
            }
        }catch (Exception exception){
            throw new InconsistenValuesException("Task id false");
        }
    }

    @Override
    public void update(TaskDto taskDto) {
        try {
            Task task=taskRepository.findById(taskDto.getId()).get();
            if (task!=null && task.getUser().getId()==getAuth().getId()){
                Task upTask=taskDto.cloneTask();
                upTask.setUser(getAuth());
                taskRepository.save(upTask);
            }else{
                throw new Exception();
            }
        }catch (Exception exception){
            throw new InconsistenValuesException("Task id false");
        }
    }

    private User getAuth(){
        if (this.auth==null)return (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return this.auth;
    }
}
