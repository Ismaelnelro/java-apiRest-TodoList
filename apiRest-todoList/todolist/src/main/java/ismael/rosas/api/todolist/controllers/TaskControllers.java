package ismael.rosas.api.todolist.controllers;

import ismael.rosas.api.todolist.controllers.bases.BaseControllersImpl;
import ismael.rosas.api.todolist.models.task.ResponseTask;
import ismael.rosas.api.todolist.models.task.Task;
import ismael.rosas.api.todolist.models.task.RequestTask;
import ismael.rosas.api.todolist.services.TaskServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/task")
public class TaskControllers extends BaseControllersImpl<Task, TaskServicesImpl> {

    @Autowired
    public TaskServicesImpl taskService;

    @PostMapping("/new")
    public ResponseEntity<?> NewTaskCreatedToSpecificUser(@RequestBody RequestTask request){

        try {
            String id = request.getId();
            ResponseTask responseTask = request.getTask();
            List<ResponseTask> responseTasks = taskService.addTaskToUser(responseTask,id);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseTasks);
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/all/user/{id}")
    public ResponseEntity<?> GetAllTaskByUserID(@PathVariable String id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(taskService.findAllByUserId(id));
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }


    @GetMapping("/all/user/{id}/paged")
    public ResponseEntity<?> getAllTaskByUserId(@PathVariable("id") String id, Pageable pageable) {
        try {
            Page<ResponseTask> tasksPage = taskService.findAllTasksByUserIdWithPagination(id, pageable);
            return ResponseEntity.ok(tasksPage);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

}
