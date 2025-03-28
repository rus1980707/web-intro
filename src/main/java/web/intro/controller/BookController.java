package web.intro.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import web.intro.dto.BookDto;
import web.intro.dto.CreateBookRequestDto;
import web.intro.seervice.BookService;
import java.util.List;
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
	private final BookService bookService;

	@GetMapping
	public List<BookDto> getAll() {
		return bookService.getAll();
	}

	@GetMapping("/{id}")
	public BookDto getBookById(@PathVariable Long id) {
		return bookService.getBookById(id);
	}
	@PutMapping("/{id}")
	public BookDto updateBook(@PathVariable Long id, @RequestBody CreateBookRequestDto bookDto) {
		return bookService.updateBook(id, bookDto);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BookDto createBook(@RequestBody CreateBookRequestDto bookDto) {
		return bookService.createBook(bookDto);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		bookService.deleteById(id);
	}
}
