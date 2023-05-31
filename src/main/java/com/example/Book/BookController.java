package com.example.Book;

import com.example.Book.entity.Book;
import com.example.Book.services.BookService;
import com.example.Book.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String showAllBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book/list";
    }
    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "book/add";
    }
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book")Book book, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("categories", categoryService.getAllCategories());
            return "book/add";
        }
        bookService.addBook(book);
        return "redirect:/books";
    }

}
