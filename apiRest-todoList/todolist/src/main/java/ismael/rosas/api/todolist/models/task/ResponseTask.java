package ismael.rosas.api.todolist.models.task;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ismael.rosas.api.todolist.models.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
public class ResponseTask {
    private String title;
    private String description;
    private Date createAT = new Date();
    private Date updateAT;
    private boolean completed;
}
