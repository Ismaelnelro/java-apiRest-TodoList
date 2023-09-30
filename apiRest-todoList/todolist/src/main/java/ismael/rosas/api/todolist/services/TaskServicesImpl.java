package ismael.rosas.api.todolist.services;

import ismael.rosas.api.todolist.models.Task;
import ismael.rosas.api.todolist.models.User;
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
    public List<Task> addTaskToUser(Task task, String userID) throws Exception {
        try {
            Optional<User> opt = userRepository.findById(userID);
            if (opt.isEmpty()) return null;
            User user = opt.get();
            List<Task> userTask = user.getTasks();
            task.setUser(user);
            userTask.add(task);
            taskRepository.save(task);
            return userTask;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public List<Task> findAllByUserId(String id) throws Exception {
        List<Task> userListTask = new ArrayList<>();
        try {
            List<Task> listTaskByUserID = taskRepository.findAllByUserId(id);
            userListTask.addAll(listTaskByUserID);
            return userListTask;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Task> findAllTasksByUserIdWithPagination(String id, Pageable pageable) throws Exception {
        try {
            return taskRepository.findAllTasksByUserIdWithPagination(id,pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
