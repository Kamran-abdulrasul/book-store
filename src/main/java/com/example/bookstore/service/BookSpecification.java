package com.example.bookstore.service;

import com.example.bookstore.dto.BookCriteria;
import com.example.bookstore.entity.BookEntity;
import com.example.bookstore.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class BookSpecification implements Specification<BookEntity> {

    private final BookCriteria bookCriteria;




    private static final String NAME = "name";
    private static final String AUTHOR = "author";
    private static final String GENRE = "genre";
    private static final String LANGUAGE = "language";




    @Override
    public Predicate toPredicate(Root<BookEntity> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        if (bookCriteria != null) {
            if (StringUtils.hasText(bookCriteria.getName())){
                predicates.add(
                        criteriaBuilder.like(root.get(NAME),"%"+bookCriteria.getName().toUpperCase()+"%"));
            }
            if (StringUtils.hasText(bookCriteria.getAuthor())) {
                predicates.add(
                        criteriaBuilder.like(root.get(AUTHOR),"%"+ bookCriteria.getAuthor()+"%"));
            }

            if (StringUtils.hasText(bookCriteria.getLanguage())){
                predicates.add(
                        criteriaBuilder.like(root.get(LANGUAGE),"%"+bookCriteria.getAuthor()+"%"));
            }

            if (StringUtils.hasText(bookCriteria.getGenre())) {
                predicates.add(
                        criteriaBuilder.like(root.get(GENRE),"%"+bookCriteria.getGenre()+"%"));
            }

        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
