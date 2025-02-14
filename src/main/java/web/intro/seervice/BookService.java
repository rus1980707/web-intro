package web.intro.seervice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.intro.EntityNotFoundException;
import web.intro.dto.BookDto;
import web.intro.dto.CreateBookRequestDto;
import web.intro.mapper.BookMapper;
import web.intro.model.Book;
import web.intro.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
	private final BookRepository bookRepository;
	private final BookMapper bookMapper;

	public List<BookDto> getAll() {
		return bookRepository.findAll().stream()
				.map(bookMapper::toDto)
				.collect(Collectors.toList());
	}

	public BookDto getBookById(Long id) {
		return bookMapper.toDto(bookRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Book not found")));
	}

	public BookDto createBook(CreateBookRequestDto bookDto) {
		Book book = bookMapper.toEntity(bookDto);
		return bookMapper.toDto(bookRepository.save(book));
	}
}
