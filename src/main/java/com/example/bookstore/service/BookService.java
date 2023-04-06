package com.example.bookstore.service;

import com.example.bookstore.dto.BookCriteria;
import com.example.bookstore.dto.BookResponse;
import com.example.bookstore.dto.SaveBookDto;
import com.example.bookstore.exception.NotFoundException;
import com.example.bookstore.mapper.BookMapper;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.bookstore.enums.AppMessage.USER_NOT_FOUND;


@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;


    public void saveBook(Long id, SaveBookDto dto) {


        var user = userRepository.findById(id)
                .orElseThrow() ;
        log.info("User ID:",user);

        var book = user.getBooks();

        book.add(BookMapper.saveDtoToEntity(user, dto));
        user.setBooks(book);
        userRepository.save(user);


    }


    public List<BookResponse> getBooks(BookCriteria bookCriteria) {
        log.info("ActionLog.getBooks.start");
        var books = bookRepository.findAll(new BookSpecification(bookCriteria))
                .stream()
                .map(BookMapper::mapEntityToDto)
                .toList();

        log.info("ActionLog.getBooks.success");

        return books;
    }


}
