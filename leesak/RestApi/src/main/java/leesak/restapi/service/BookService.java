package leesak.restapi.service;

import leesak.restapi.domain.Book;
import leesak.restapi.dto.BookRequest;
import leesak.restapi.dto.BookResponse;
import leesak.restapi.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public BookResponse create(BookRequest request) {
        Book book = new Book(null, request.name(), request.price(), request.category());
        return new BookResponse(bookRepository.save(book));
    }

    public List<BookResponse> findAll() {
        return bookRepository.findAll().stream()
                .map(BookResponse::new)
                .toList();
    }

    public BookResponse findById(Long id) {
        return new BookResponse(bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 책입니다.")));
    }

    public BookResponse update(Long id, BookRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 책입니다."));

        book.update(request.name(), request.price(), request.category());
        return new BookResponse(book);
    }

    public void delete(Long id) {
        if (!bookRepository.delete(id)) {
            throw new IllegalArgumentException("존재하지 않는 책입니다.");
        }
    }
}
