package com.ownProjects.springWebSite.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class TodoServlet {

    private final Logger logger = LoggerFactory.getLogger(TodoServlet.class);


    private TodoRepository repository;

    TodoServlet(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    ResponseEntity<List<Todo>> findAll() {
        logger.info("Got request !");
        return ResponseEntity.ok(repository.findAll());

    }

    @PutMapping("/{id}")
    ResponseEntity<Todo> toggle(@PathVariable Integer id) {
        Optional<Todo> todo=repository.findById(id);
        todo.ifPresent(t->{t.setDone(!t.isDone());
        repository.save(t);});
        return todo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    ResponseEntity<Todo>create(@RequestBody Todo todo){
        return ResponseEntity.ok(repository.save(todo));

    }

}