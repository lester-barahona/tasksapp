package com.startCMS.core.repositorys;


import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import com.startCMS.core.models.Task;
import com.startCMS.core.repositorys.interfaces.CrudRepository;
import com.startCMS.core.repositorys.mappers.TaskRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepository implements CrudRepository<Task> {

    
    protected final JdbcTemplate jdbcTemplate;
    
    private static final TaskRowMapper TASK_ROW_MAPPER = new TaskRowMapper();
    

    public TaskRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

    @Override
    public boolean save(Task task) {
        
        boolean success;

        int affectRows=jdbcTemplate.update(
                "INSERT INTO tasks (name,description) values (?,?)",
                task.getName(),task.getDescription()
                );

        success=(affectRows==1);
           
        return success;
    }

    @Override
    public boolean update(Task task, Integer id) {
        boolean success;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		int affectRows=jdbcTemplate.update(
				"UPDATE tasks SET name=?, description=?, date=?, complete=? where id=?",
				task.getName(),task.getDescription(),formatter.format(task.getDate()),task.isComplete(),id
		);

		success=(affectRows==1);

		return success;
    }

    @Override
    public boolean deleteById(Integer id) {
        String sql="DELETE FROM tasks where id=?;";
        return jdbcTemplate.update(sql,id)==1;
    }

    @Override
    public List<Task> findAll() {
        	return jdbcTemplate.query("SELECT * FROM tasks",TASK_ROW_MAPPER);
    }

    @Override
    public Optional<Task> findById(Integer id) {
        Task task=null;

		try {
			 task = jdbcTemplate.queryForObject(
					 "SELECT * FROM tasks WHERE ID = ?",TASK_ROW_MAPPER, new Object[]{id});
		} catch (Exception e) {

		
		}

		return Optional.ofNullable(task);
    }

	
    
}
