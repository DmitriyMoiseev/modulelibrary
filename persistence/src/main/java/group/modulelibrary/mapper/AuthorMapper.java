package group.modulelibrary.mapper;

import group.modulelibrary.dto.AuthorDto;
import group.modulelibrary.model.Author;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface AuthorMapper {

    @Mapping(target = "books")
    Author toAuthor (AuthorDto authorDto);

    @InheritInverseConfiguration
    AuthorDto toDtoAuthor (Author author);

    List<Author> toAuthorList(List<AuthorDto> authorDtoList);
    List<AuthorDto> toAuthorDtoList(List<Author> authorList);
}
