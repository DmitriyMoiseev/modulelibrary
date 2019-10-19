package group.modulelibrary.service.impl;

import group.modulelibrary.model.Author;
import group.modulelibrary.model.Book;
import group.modulelibrary.repository.AuthorRepository;
import group.modulelibrary.service.api.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl (AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public boolean saveAuthor(Author author) {
        Optional<Author> authorCandidate = authorRepository.findAuthorByFirstNameAndLastNameAndPatronymic(
                author.getFirstName(), author.getLastName(), author.getPatronymic());
        if (authorCandidate.isPresent()) {
            return false;
        } else {
            authorRepository.save(author);
            return true;
        }
    }

    @Override
    public Author deleteAuthor(Author author) {
        Optional<Author> authorCandidate = authorRepository.findById(author.getAuthorId());
        if (authorCandidate.isPresent()) {
            authorRepository.delete(author);
            return null;
        } else {
            return author;
        }
    }

    @Override
    public Author getAuthorById(Integer id) {
        Optional<Author> authorCandidate = authorRepository.findById(id);
        if (authorCandidate.isPresent()) {
            return authorCandidate.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

}
