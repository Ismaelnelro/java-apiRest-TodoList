package ismael.rosas.api.todolist.services.Iservices;

import ismael.rosas.api.todolist.models.task.ResponseTask;
import ismael.rosas.api.todolist.models.task.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskSevices {
    List<ResponseTask> addTaskToUser(ResponseTask task , String userID) throws Exception;
    List<ResponseTask> findAllByUserId(String id)throws  Exception;
    Page<ResponseTask> findAllTasksByUserIdWithPagination(String id, Pageable pageable)throws  Exception;
}
