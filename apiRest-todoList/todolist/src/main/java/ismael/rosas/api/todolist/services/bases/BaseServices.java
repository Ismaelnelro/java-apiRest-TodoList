package ismael.rosas.api.todolist.services.bases;

import ismael.rosas.api.todolist.models.Base;
import ismael.rosas.api.todolist.models.user.ResponseUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseServices<E extends Base, ID extends Serializable> {
    public List<E> findAll() throws Exception;
    public Page<E> findAll(Pageable pageable) throws Exception;
    public E findById(ID id) throws Exception;
    public E save(E entity) throws Exception;
    public E update(E entity, ID id) throws Exception;
    public boolean delete (ID id) throws  Exception;
}
