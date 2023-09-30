package ismael.rosas.api.todolist.services;

import ismael.rosas.api.todolist.models.user.MapperUser;
import ismael.rosas.api.todolist.models.user.RequestUsers;
import ismael.rosas.api.todolist.models.user.ResponseUser;
import ismael.rosas.api.todolist.models.user.User;
import ismael.rosas.api.todolist.repository.UserRepository;
import ismael.rosas.api.todolist.repository.base.BaseRepository;
import ismael.rosas.api.todolist.services.Iservices.UserServices;
import ismael.rosas.api.todolist.services.bases.BaseServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServicesImpl extends BaseServicesImpl<User, String> implements UserServices {
    public UserServicesImpl(BaseRepository<User,String> baseRepository) {
        super(baseRepository);
    }

    @Autowired
    public UserRepository userRepository;

    @Override
    public ResponseUser saveNewAccount(RequestUsers request) throws Exception {
        try {
            User newUser = MapperUser.RequestToEntity(request);
            userRepository.save(newUser);
            return  MapperUser.EntityToResponse(newUser);

        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }
}
