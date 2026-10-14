package leesak.restapi.dto;

public record  BookRequest (
    String name,
    Integer price,
    String category
) {}
