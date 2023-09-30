package ismael.rosas.api.todolist.services;

import ismael.rosas.api.todolist.models.task.MapperTask;
import ismael.rosas.api.todolist.models.task.ResponseTask;
import ismael.rosas.api.todolist.models.task.Task;
import ismael.rosas.api.todolist.models.user.User;
import ismael.rosas.api.todolist.repository.TaskRepository;
import ismael.rosas.api.todolist.repository.UserRepository;
import ismael.rosas.api.todolist.repository.base.BaseRepository;
import ismael.rosas.api.todolist.services.Iservices.TaskSevices;
import ismael.rosas.api.todolist.services.bases.BaseServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TaskServicesImpl extends BaseServicesImpl<Task, String> implements TaskSevices {


    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    public TaskServicesImpl(BaseRepository<Task, String> baseRepository) {
        super(baseRepository);
    }


    @Override
    @Transactional
    public List<ResponseTask> addTaskToUser(ResponseTask responseTask, String userID) throws Exception {
        try {
            Optional<User> opt = userRepository.findById(userID);
            if (opt.isEmpty()) return null;
            User user = opt.get();
            List<Task> userTask = user.getTasks();
            Task task = MapperTask.ResponseToEntity(responseTask);
            task.setUser(user);
            userTask.add(task);
            taskRepository.save(task);

            return MapperTask.EntityToListResponse(userTask);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public List<ResponseTask> findAllByUserId(String id) throws Exception {
        List<Task> userListTask = new ArrayList<>();
        try {
            List<Task> listTaskByUserID = taskRepository.findAllByUserId(id);
            userListTask.addAll(listTaskByUserID);
            return MapperTask.EntityToListResponse(listTaskByUserID);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<ResponseTask> findAllTasksByUserIdWithPagination(String id, Pageable pageable) throws Exception {
        try {
            Page<Task> taskPaged = taskRepository.findAllTasksByUserIdWithPagination(id,pageable);
            return taskPaged.map(task -> MapperTask.EntityToResponse(task));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
