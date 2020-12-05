package com.cybertek.implementation;

import com.cybertek.dto.TaskDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImlp extends AbstractMapService<TaskDTO,Long> implements TaskService {
    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public TaskDTO save(TaskDTO Object) {
        return super.save(Object.getId(),Object);
    }

    @Override
    public void update(TaskDTO object) {

        TaskDTO foundProject = findById(object.getId());
        object.setAssignDate(foundProject.getAssignDate());
        object.setTaskStatus(foundProject.getTaskStatus());

        super.update(object.getId(),object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(TaskDTO object) {
        super.delete(object);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<TaskDTO> findTaskByManager(UserDTO manager) {
        return super.findAll().stream().filter(task -> task.getProject().getAssignManager().equals(manager)).collect(Collectors.toList());
    }
}
