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

@Service
@RequiredArgsConstructor
public class BookService {
	private final BookRepository bookRepository;
	private final BookMapper bookMapper;

	public List<BookDto> getAll() {
		return bookRepository.findAll().stream()
				.map(bookMapper::toDto)
				.toList();
	}

	public BookDto getBookById(Long id) {
		return bookMapper.toDto(bookRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Book by id not found")));
	}

	public BookDto createBook(CreateBookRequestDto bookDto) {
		Book book = bookMapper.toEntity(bookDto);
		return bookMapper.toDto(bookRepository.save(book));
	}

	public BookDto updateBook(Long id, CreateBookRequestDto bookDto) {
		Book curentBook =bookRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Book by id not found"));
		bookMapper.updateBookDto(bookDto, curentBook);

		curentBook = bookRepository.save(curentBook);
		return bookMapper.toDto(curentBook);
	}

	public void deleteById(long id) {
		bookRepository.deleteById(id);
	}
}
