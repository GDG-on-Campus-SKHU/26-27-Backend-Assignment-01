package leesak.restapi.repository;

import leesak.restapi.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepository {
    private final Map<Long, Book> books = new HashMap<>();
    private long sequence = 0L;

    public BookRepository() {
        save(new Book(null, "싯다르타", 8000, "고전소설"));
        save(new Book(null, "데미안", 8000, "고전소설"));
        save(new Book(null, "안나 카레니나", 30800, "고전소설"));
    }

    public Book save(Book newBook) {
        Book book = new Book(++sequence, newBook.getName(),
                newBook.getPrice(), newBook.getCategory());
        books.put(book.getId(), book);
        return book;
    }

    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(books.get(id));
    }

    public boolean delete(Long id) {
        return books.remove(id) != null;
    }
}
