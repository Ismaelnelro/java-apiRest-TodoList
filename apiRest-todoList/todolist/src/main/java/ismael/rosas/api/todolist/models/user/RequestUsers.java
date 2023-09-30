package ismael.rosas.api.todolist.models.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class RequestUsers {
    private String fullname;
    private String username;
    private String email;
}
