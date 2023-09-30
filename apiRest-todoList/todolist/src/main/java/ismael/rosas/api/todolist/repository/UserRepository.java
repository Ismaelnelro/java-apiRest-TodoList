package ismael.rosas.api.todolist.repository;

import ismael.rosas.api.todolist.models.user.User;
import ismael.rosas.api.todolist.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, String> {
}
