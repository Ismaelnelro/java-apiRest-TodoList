package ismael.rosas.api.todolist.controllers;

import ismael.rosas.api.todolist.controllers.bases.BaseControllersImpl;
import ismael.rosas.api.todolist.models.User;
import ismael.rosas.api.todolist.services.UserServicesImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/users")
public class UserControllers extends BaseControllersImpl<User, UserServicesImpl>  {

}
