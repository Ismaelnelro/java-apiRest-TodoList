package ismael.rosas.api.todolist.services.Iservices;

import ismael.rosas.api.todolist.models.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskSevices {
    List<Task> addTaskToUser(Task task , String userID) throws Exception;
    List<Task> findAllByUserId(String id)throws  Exception;
    Page<Task> findAllTasksByUserIdWithPagination(String id, Pageable pageable)throws  Exception;
}
