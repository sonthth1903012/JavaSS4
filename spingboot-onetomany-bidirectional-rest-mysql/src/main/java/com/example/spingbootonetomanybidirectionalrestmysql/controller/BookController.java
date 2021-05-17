package com.example.spingbootonetomanybidirectionalrestmysql.controller;

import com.example.spingbootonetomanybidirectionalrestmysql.jpa.Book;
import com.example.spingbootonetomanybidirectionalrestmysql.jpa.Library;
import com.example.spingbootonetomanybidirectionalrestmysql.service.BookService;
import com.example.spingbootonetomanybidirectionalrestmysql.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/admin/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private LibraryService libraryService;

    @RequestMapping(path = "")
    public String getBooks(Model model) {
        Book book = new Book();

        List<Library> listLibrary = libraryService.getAll();
        model.addAttribute("listLibrary",listLibrary);
        return "admin/book/bookList";
    }

    @RequestMapping(path = "saveBook", method = RequestMethod.POST)
    public String createBook(@ModelAttribute("bookNew") @Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/book/bookList";
        }
        boolean bl = bookService.createBook(book);
        List<Library> listLibrary = libraryService.getAll();
        model.addAttribute("listLibrary",listLibrary);
        if (bl) {
            return "redirect:/admin/book?success=Add New book success";
        }
        return "redirect:/admin/book?error=Add New book failed";
    }

    @RequestMapping(path = "editBook")
    public String editBook(@RequestParam("id") Integer id, Model model) {
        Book book = bookService.getById(id);
        model.addAttribute("bookEdit", book);
        List<Library> listLibrary = libraryService.getAll();
        model.addAttribute("listLibrary",listLibrary);
        return "admin/book/editBook";

    }

    @RequestMapping(path = "updateBook", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute("bookEdit") Book book) {
        boolean bl = bookService.updateBook(book);
        if (bl) {
            return "redirect:/admin/book?success=Update book success";
        }
        return "redirect:/admin/book?error=Update book failed";
    }

    @RequestMapping(path = "deleteBook")
    public String deleteBook(@RequestParam("id") Integer id) {
        boolean bl = bookService.deleteBook(id);
        if (bl) {
            return "redirect:/admin/book?success=Delete book success";
        }
        return "redirect:/admin/book?error=Delete book failed";
    }

}
