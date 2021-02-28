package com.startCMS.core.services;


import java.util.List;
import java.util.Optional;

import com.startCMS.core.models.Task;

public interface TasksService {
    
    boolean save(Task task);

    List<Task> findAll();

    boolean delete(Integer id);

    Optional<Task> findById(Integer id);

    boolean update(Task task,Integer id);

}
