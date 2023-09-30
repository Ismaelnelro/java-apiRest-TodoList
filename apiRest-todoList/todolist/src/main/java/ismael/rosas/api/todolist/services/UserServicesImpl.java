package ismael.rosas.api.todolist.services;

import ismael.rosas.api.todolist.models.User;
import ismael.rosas.api.todolist.repository.base.BaseRepository;
import ismael.rosas.api.todolist.services.bases.BaseServicesImpl;
import org.springframework.stereotype.Service;


@Service
public class UserServicesImpl extends BaseServicesImpl<User, String> {
    public UserServicesImpl(BaseRepository<User,String> baseRepository) {
        super(baseRepository);
    }
}
