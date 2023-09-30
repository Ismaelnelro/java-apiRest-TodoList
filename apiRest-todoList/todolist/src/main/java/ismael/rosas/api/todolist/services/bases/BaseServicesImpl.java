package ismael.rosas.api.todolist.services.bases;

import ismael.rosas.api.todolist.models.Base;
import ismael.rosas.api.todolist.models.task.MapperTask;
import ismael.rosas.api.todolist.models.task.ResponseTask;
import ismael.rosas.api.todolist.models.task.Task;
import ismael.rosas.api.todolist.models.user.ResponseUser;
import ismael.rosas.api.todolist.models.user.User;
import ismael.rosas.api.todolist.repository.base.BaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class BaseServicesImpl<E extends Base, ID extends Serializable> implements BaseServices<E, ID> {
    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    protected BaseRepository<E, ID> baseRepository;

    protected BaseServicesImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try {
           return baseRepository.save(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    @Transactional
    public List<E> findAll() throws Exception {
        try {
            return baseRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Page<E> findAll(Pageable pageable) throws Exception {
        try {
            return (Page<E>) baseRepository.findAll(pageable);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try {
            Optional<E> opt = baseRepository.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    @Transactional
    public E update(E entity, ID id) throws Exception {
        try {
            Optional<E> opt = baseRepository.findById(id);
            if (!opt.isPresent() || opt == null) throw new Exception("There  is not entity");
            E entityDB = opt.get();
            entityDB = (E) baseRepository.save(entity);
            return entityDB;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try {
            if (baseRepository.existsById(id)) {
                baseRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("Error while deleting entity");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
