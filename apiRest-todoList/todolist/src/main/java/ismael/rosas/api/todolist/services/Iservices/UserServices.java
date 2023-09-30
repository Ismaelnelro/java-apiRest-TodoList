package ismael.rosas.api.todolist.services.Iservices;

import ismael.rosas.api.todolist.models.user.RequestUsers;
import ismael.rosas.api.todolist.models.user.ResponseUser;
import ismael.rosas.api.todolist.models.user.User;

public interface UserServices {

    ResponseUser saveNewAccount(RequestUsers request) throws Exception;;
}
