package ismael.rosas.api.todolist.controllers.bases;

import ismael.rosas.api.todolist.models.Base;
import ismael.rosas.api.todolist.services.bases.BaseServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

public abstract class BaseControllersImpl<E extends Base, S extends BaseServicesImpl<E, String>> implements BaseControllers<E, String> {


    @Autowired
    protected S service;


    @Override
    @PostMapping(path = "")
    public ResponseEntity<?> save(@RequestBody E entity) {
        try {
            return  ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("there was an error while we were creating an new user!");
        }
    }

    @Override
    @GetMapping(path = "/all")
    public ResponseEntity<?> getAll() {
        try {
            return  ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("'Error'- not found!");
        }
    }

    @Override
    @GetMapping(path = "/paged")
    public ResponseEntity<?> getAll(Pageable pageable) {
        try {
            return  ResponseEntity.status(HttpStatus.OK).body(service.findAll((org.springframework.data.domain.Pageable) pageable));
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("'Error'- not found!");
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(String id) {
        try {
            return  ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("'Error'- not found!");
        }
    }


    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> update(E entity, String id) {
        try {
            return  ResponseEntity.status(HttpStatus.OK).body(service.update(entity, id));
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("'Error'- something went wrong!");
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(String id) {
        try {
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id));
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("'Error'- something went wrong!");
        }
    }



}