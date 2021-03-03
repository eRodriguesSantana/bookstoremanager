package com.erodriguessantana.bookstoremanager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erodriguessantana.bookstoremanager.dto.BookDTO;
import com.erodriguessantana.bookstoremanager.entity.Book;
import com.erodriguessantana.bookstoremanager.service.BookService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@ApiOperation(value = "Retorna uma lista de Books")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna uma lista de Books"),
							@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
							@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	@GetMapping("/")
	public List<Book> getAll() {
		return bookService.getAll();
	}

	@ApiOperation(value = "Retorna um Book pelo ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um Book pelo ID"),
							@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
							@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@GetMapping("/{id}")
	public ResponseEntity<?> findBookById(@PathVariable Long id) {
		return bookService.findBookById(id);
	}

	@ApiOperation(value = "Retorna um Book com Author pelo ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um Book com Author pelo ID"),
							@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
							@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/bookwithauthor/{id}", method = RequestMethod.GET, produces = "application/json")
	@GetMapping("/bookwithauthor/{id}")
	public ResponseEntity<?> findBookAndAuthorById(@PathVariable Long id) {
		return bookService.findByBookAuthorByID(id);
	}

	@ApiOperation(value = "Registra um novo Book informando um ID de Author já cadastrado")
	@ApiResponses(value = {	@ApiResponse(code = 200, message = "Registra um novo Book informando um ID de Author já cadastrado"),
							@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
							@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	@PostMapping("/create")
	public ResponseEntity<?> save(@RequestBody BookDTO bookDTO) {		
		return bookService.save(bookDTO);
	}

	@ApiOperation(value = "Altera os dados de um Book previamente registrado informando um ID de Author já cadastrado (opcional)")
	@ApiResponses(value = {	@ApiResponse(code = 200, message = "Altera os dados de um Book previamente registrado informando um ID de Author já cadastrado (opcional)"),
							@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
							@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody BookDTO bookDTO, @PathVariable Long id) {
		return bookService.update(bookDTO, id);
	}

	@ApiOperation(value = "Remove os dados de um Book previamente registrado informando um ID.")
	@ApiResponses(value = {	@ApiResponse(code = 200, message = "Remove os dados de um Book previamente registrado informando um ID."),
							@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
							@ApiResponse(code = 500, message = "Foi gerada uma exceção"), })
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		if(bookService.findBookById(id) != null) {
			bookService.delete(id);
			return ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity<>("Erro na tentativa de remoção: ID do Book informando não existe.", HttpStatus.NOT_FOUND);
	}
}
