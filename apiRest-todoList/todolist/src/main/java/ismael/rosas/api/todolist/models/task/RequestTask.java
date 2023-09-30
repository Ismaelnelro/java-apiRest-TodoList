package ismael.rosas.api.todolist.models.task;

import ismael.rosas.api.todolist.models.task.Task;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RequestTask {

    private String id;
    private ResponseTask task;
//    private Task task;
}
