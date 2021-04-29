package com.todo.repository;

import com.todo.entity.Task;
import com.todo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    @Query(value ="select t from Task t where t.user= :user" )
    List<Task> findTasksByUser(@Param("user") User user);
}
