package com.startCMS.core.services.servicesImp;

import java.util.List;
import java.util.Optional;

import com.startCMS.core.models.Task;
import com.startCMS.core.repositorys.TaskRepository;
import com.startCMS.core.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TasksSeviceImpl implements TasksService {

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public boolean save(Task task) {

		return taskRepository.save(task);
	}

	@Override
	public List<Task> findAll() {

		return taskRepository.findAll();

	}

	@Override
	public boolean delete(Integer id) {

		return taskRepository.deleteById(id);

	}

	@Override
	public Optional<Task> findById(Integer id) {
		return taskRepository.findById(id);
	}

	@Override
	public boolean update(Task task, Integer id) {

		return taskRepository.update(task, id);
	}



	

}
