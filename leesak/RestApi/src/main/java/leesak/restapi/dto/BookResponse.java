package leesak.restapi.dto;

import leesak.restapi.domain.Book;

public record BookResponse (
    Long id,
    String name,
    Integer price,
    String category
) {
    public BookResponse(Book book) {
        this(book.getId(), book.getName(), book.getPrice(), book.getCategory());
    }
}
