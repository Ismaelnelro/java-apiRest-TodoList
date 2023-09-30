package ismael.rosas.api.todolist.models.request.task;

import ismael.rosas.api.todolist.models.Task;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RequestTask {

    private String id;
    private Task task;
}
