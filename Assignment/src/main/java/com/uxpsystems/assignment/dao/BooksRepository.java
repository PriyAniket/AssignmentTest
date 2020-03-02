package com.uxpsystems.assignment.dao;
import org.springframework.data.repository.CrudRepository;

import com.uxpsystems.assignment.model.Books;
public interface BooksRepository extends CrudRepository<Books, Integer>
{
}
