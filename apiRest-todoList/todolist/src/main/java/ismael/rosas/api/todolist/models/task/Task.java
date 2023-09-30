package ismael.rosas.api.todolist.models.task;


import com.fasterxml.jackson.annotation.JsonBackReference;
import ismael.rosas.api.todolist.models.Base;
import ismael.rosas.api.todolist.models.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Task extends Base {

    @Column(name="title", columnDefinition = "VARCHAR(40)")
    private String title;

    @Column(name ="description", columnDefinition = "VARCHAR(244)")
    private String description;

    @Column(name="createAt")
    @Temporal(TemporalType.DATE)
    private Date createAT = new Date();

    @Column(name="updateAt")
    @Temporal(TemporalType.DATE)
    private Date updateAT;

    @Column(name="completed")
    private boolean completed = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
}
