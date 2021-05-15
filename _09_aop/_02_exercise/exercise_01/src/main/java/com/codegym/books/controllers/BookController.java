package com.codegym.books.controllers;

import com.codegym.books.models.Book;
import com.codegym.books.models.RentCode;
import com.codegym.books.services.IBookService;
import com.codegym.books.services.IRentCodeService;
import com.codegym.books.util.custom_exception.OutOfBookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IRentCodeService rentCodeService;

    @GetMapping("/")
    public ModelAndView list() {
        return new ModelAndView("/book/list", "books", bookService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute(name = "book")Book newBook) {
        bookService.save(newBook);
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("message", "Adding Successfully!");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @GetMapping("/rent/{id}")
    public ModelAndView view(@PathVariable(name = "id")Long id) {
        Book book = bookService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/book/view");
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @PostMapping("/rent")
    public ModelAndView rent(@ModelAttribute(name = "book")Book book,
                             @RequestParam(name = "rent")String confirm) throws OutOfBookException {
        if (confirm.equals("yes")) {
//            Generate and save an unique rent code
            Long randomNumber;
            while(true) {
                randomNumber = (long) (Math.random() * (99999 - 11111 + 1) + 11111);
                List<RentCode> rentCodeList = rentCodeService.findAll();
                boolean check = false;
                for (RentCode rentCode : rentCodeList) {
                    if (rentCode.getCode().equals(randomNumber)) {
                        check = true;
                        break;
                    }
                }
                if (!check) {
                    break;
                }
            }

//            Check randomNumber whether already exist or not...

            RentCode rentCode = new RentCode(randomNumber, book);
            rentCodeService.save(rentCode);

//            update number available for rented book
            if (book.getNumberAvailable() == 0) {
                throw new OutOfBookException();
            }
            book.setNumberAvailable(book.getNumberAvailable() - 1);
            bookService.save(book);

            ModelAndView modelAndView = new ModelAndView("/book/view");
            modelAndView.addObject("message", "Successfully. Rent code: " + randomNumber);
            modelAndView.addObject("book", bookService.findById(book.getId()));
            return modelAndView;
        }
        return new ModelAndView("/book/list");
    }

    @GetMapping("/return")
    public String returnBook() {
        return "/book/return";
    }

    @PostMapping("/return")
    public ModelAndView returnBook(@RequestParam(name = "rentCode")Long rentCode) {
        List<RentCode> rentCodeList = rentCodeService.findAll();
        Book returnedBook = null;
        boolean check = true;
        for (RentCode aRentCode : rentCodeList) {
            if (aRentCode.getCode().equals(rentCode)) {
                returnedBook = aRentCode.getBook();
                check = false;
                break;
            }
        }
//        Entered code is not exist.
        if (check) {
            ModelAndView modelAndView = new ModelAndView("/book/return");
            modelAndView.addObject("message", "Not exist code. Please try again!");
            return modelAndView;
        }
//        Increase the number available of returned book.
        returnedBook.setNumberAvailable(returnedBook.getNumberAvailable() + 1);
        bookService.save(returnedBook);

//        delete the returning rent code.
        RentCode returningRentCode = rentCodeService.findById(rentCode);
        rentCodeService.delete(returningRentCode);
        ModelAndView modelAndView = new ModelAndView("book/list");
        modelAndView.addObject("books", bookService.findAll());
        modelAndView.addObject("message", "Returning successfully!");
        return modelAndView;
    }
}
