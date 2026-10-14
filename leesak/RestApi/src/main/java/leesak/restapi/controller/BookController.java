package leesak.restapi.controller;

import leesak.restapi.dto.BookRequest;
import leesak.restapi.dto.BookResponse;
import leesak.restapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponse> create(@RequestBody BookRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookResponse> update(@PathVariable("id") Long id, @RequestBody BookRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        bookService.delete((id));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
