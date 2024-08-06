package am.itspace.catalogservice.demo;


import am.itspace.catalogservice.domain.Book;
import am.itspace.catalogservice.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("testdata")
public class BookDataLoader {
    private final BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        var book1 = new Book("1234567891" , "Cloud Native Spring in Action" , "Thomas Vitale" , 29.99);
        var book = new Book("1234567892" , "Spring in Action" , "Craig Walls" , 19.99);
        bookRepository.save(book1);
        bookRepository.save(book);
    }
}