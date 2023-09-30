package ismael.rosas.api.todolist.repository;


import ismael.rosas.api.todolist.models.Task;
import ismael.rosas.api.todolist.repository.base.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends BaseRepository<Task,String> {

    @Query("SELECT t FROM Task t JOIN FETCH t.user u WHERE t.user.id = :userId")
    List<Task> findAllByUserId(@Param("userId") String userId);


    @Query("SELECT t FROM Task t WHERE t.user.id = :id")
    Page<Task> findAllTasksByUserIdWithPagination(@Param("id") String id, Pageable pageable);




}
