package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>
{
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void initData(){
        //NHL
        Author nhl = new Author("Le", "Nguyen Hien");
        Book dnt = new Book("Dac Nhan Tam","1234","NXB Tre");
        nhl.getBooks().add(dnt);
        dnt.getAuthors().add(nhl);
        authorRepository.save(nhl);
        bookRepository.save(dnt);

        //NDC
        Author ndc = new Author("Can","Nguyen Duy");
        Book ltth = new Book("Lao Tu Tinh Hoa","2345","NXB VHTT");
        ndc.getBooks().add(ltth);
        ltth.getAuthors().add(ndc);
        authorRepository.save(ndc);
        bookRepository.save(ltth);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();

    }
}
