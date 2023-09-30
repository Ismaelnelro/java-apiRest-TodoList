package ismael.rosas.api.todolist.controllers.bases;

import ismael.rosas.api.todolist.models.Base;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.print.Pageable;
import java.io.Serializable;

public interface BaseControllers<E extends Base, ID extends Serializable> {

    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getAll(Pageable pageable);
    public ResponseEntity<?> getOne(@PathVariable ID id);
    public ResponseEntity<?> save(@RequestBody E entity);
    public ResponseEntity<?> update(@RequestBody E entity, @PathVariable ID id);
    public ResponseEntity<?> delete(@PathVariable ID id);

}
