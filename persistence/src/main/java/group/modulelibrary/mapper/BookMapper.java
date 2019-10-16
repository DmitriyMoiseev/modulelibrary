package group.modulelibrary.mapper;

import group.modulelibrary.dto.BookDto;
import group.modulelibrary.model.Book;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface BookMapper {

    @Mapping(target = "author.authorId", source = "authorId")
    Book toBook(BookDto bookDto);

    @InheritInverseConfiguration
    BookDto toDtoBook(Book book);

    List<Book> toBookList(List<BookDto> bookDtoList);
    List<BookDto> toDtoBookList(List<Book> bookList);
}
