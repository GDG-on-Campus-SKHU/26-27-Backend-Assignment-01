package leesak.restapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Book {
    private Long id;
    private String name;
    private Integer price;
    private String category;

    public void update(String name, Integer price, String category) {
        if (name != null) {
            this.name = name;
        }
        if (price != null) {
            this.price = price;
        }
        if (category != null) {
            this.category = category;
        }
    }
}
