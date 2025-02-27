package web.intro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import web.intro.dto.BookDto;
import web.intro.dto.CreateBookRequestDto;
import web.intro.seervice.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
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

	@PostMapping
	public BookDto createBook(@RequestBody CreateBookRequestDto bookDto) {
		return bookService.createBook(bookDto);
	}
}
