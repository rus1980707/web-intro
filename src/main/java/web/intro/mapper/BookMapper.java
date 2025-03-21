package web.intro.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import web.intro.dto.BookDto;
import web.intro.dto.CreateBookRequestDto;
import web.intro.model.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {
	BookDto toDto(Book book);

	Book toEntity(CreateBookRequestDto dto);

	@Mapping(target = "id" , ignore = true)
	void updateBookDto(CreateBookRequestDto bookDto, @MappingTarget Book curentBook);

}
