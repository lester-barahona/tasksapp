package com.startCMS.core.repositorys.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.startCMS.core.models.Task;

public class TaskRowMapper implements RowMapper<Task>{

	@Override
	public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
		Task task = new Task();
		task.setId(rs.getInt("id"));
        task.setName(rs.getString("name"));
		task.setDescription(rs.getString("description"));
		task.setDate(rs.getDate("date"));
		task.setComplete(rs.getBoolean("complete"));
		return task;
	}

	

}
