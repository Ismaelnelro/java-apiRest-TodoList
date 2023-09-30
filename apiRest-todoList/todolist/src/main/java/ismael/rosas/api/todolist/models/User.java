package ismael.rosas.api.todolist.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User extends Base {

    @Column(name = "fullname", length = 100, nullable = false, updatable = true)
    private String fullname;

    @Column(name = "username", length = 50, nullable = false, updatable = true, unique = true)
    private String username;

    @Column(name = "email", length = 50, nullable = false, updatable = true, unique = true)
    private String email;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.REMOVE
    )
    @JsonManagedReference
    List<Task> tasks = new ArrayList<>();

    public void addTask(Task task){
        task.setUser(this);
        tasks.add(task);
    }
}
