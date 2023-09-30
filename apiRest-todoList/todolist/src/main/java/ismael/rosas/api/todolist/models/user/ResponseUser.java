package ismael.rosas.api.todolist.models.user;


import ismael.rosas.api.todolist.models.task.ResponseTask;
import ismael.rosas.api.todolist.models.task.Task;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResponseUser {
//    private String fullname;
    private String username;
    private String email;
    List<ResponseTask> tasks = new ArrayList<>();
}
