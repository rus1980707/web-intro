package web.intro.mapper;

import org.mapstruct.Mapper;
import web.intro.dto.BookDto;
import web.intro.dto.CreateBookRequestDto;
import web.intro.model.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {
	BookDto toDto(Book book);
	Book toEntity(CreateBookRequestDto dto);
}
