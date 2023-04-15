package com.example.bookstore.service;


import com.example.bookstore.dto.*;
import com.example.bookstore.entity.UserEntity;
import com.example.bookstore.enums.AuthorityName;
import com.example.bookstore.exception.NotFoundException;
import com.example.bookstore.mapper.BookMapper;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;


import java.nio.file.AccessDeniedException;
import java.util.List;


import static com.example.bookstore.enums.AppMessage.USER_NOT_FOUND;


@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;


    public void saveBook(Long id, SaveBookDto dto) throws AccessDeniedException {


        var user = userRepository.findById(id).orElseThrow(() ->
                new NotFoundException(
                        String.format(USER_NOT_FOUND.getCode()), (USER_NOT_FOUND.getMessage())));

        var book = user.getBooks();

        book.add(BookMapper.saveDtoToEntity(user, dto));

        if (user.getAuthority() == AuthorityName.ROLE_PUBLISHER) {
            user.setBooks(book);
            userRepository.save(user);
        } else {
            throw new AccessDeniedException("ACCESS_DENIED");
        }
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


    public BookResponseByUser getBooksByPublisher(Long userId) {

        var user = userRepository.findById(userId).orElseThrow(() ->
                new NotFoundException(
                        String.format(USER_NOT_FOUND.getCode()), (USER_NOT_FOUND.getMessage())));


        return BookResponseByUser.builder()
                .publisherName(user.getName())
                .publisherSurname(user.getSurname())
                .books(user.getBooks())
                .build();

    }


    public void listBookForUser(Long id, ResponseListBook listBook) throws AccessDeniedException {

        var user = userRepository.findById(id).orElseThrow(() ->
                new NotFoundException(
                        String.format(USER_NOT_FOUND.getCode()), (USER_NOT_FOUND.getMessage())));

        if (user.getAuthority() == AuthorityName.ROLE_USER) {
            var books = bookRepository.findByIdIn(listBook.getBookIds());

            user.setUser_books(books);
            userRepository.save(user);
        } else {
            throw new AccessDeniedException("ACCESS_DENIED");
        }

    }


}
