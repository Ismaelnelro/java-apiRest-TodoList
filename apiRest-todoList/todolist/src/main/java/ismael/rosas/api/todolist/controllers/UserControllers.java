package ismael.rosas.api.todolist.controllers;

import ismael.rosas.api.todolist.controllers.bases.BaseControllersImpl;
import ismael.rosas.api.todolist.models.user.RequestUsers;
import ismael.rosas.api.todolist.models.user.ResponseUser;
import ismael.rosas.api.todolist.models.user.User;
import ismael.rosas.api.todolist.services.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/users")
public class UserControllers extends BaseControllersImpl<User, UserServicesImpl>  {

    @Autowired
    private  UserServicesImpl services;

    @PostMapping(path = "/new")
    public ResponseEntity<?> saveNewAccount(@RequestBody RequestUsers request){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(services.saveNewAccount(request));
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

}
