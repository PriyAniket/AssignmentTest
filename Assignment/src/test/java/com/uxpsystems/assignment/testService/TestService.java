package com.uxpsystems.assignment.testService;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uxpsystems.assignment.dao.BooksRepository;
import com.uxpsystems.assignment.service.BooksService;
import com.uxpsystems.assignment.model.Books;
import com.uxpsystems.assignment.model.Books.name;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestService 
{
	@Mock
	private BooksRepository booksrepository;
	
	@Mock
	private BooksService booksservice;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllBooks()
	{
		List<Books> booksList=new ArrayList<Books>();
		booksList.add(new Books(100,"TEST1","test1",name.ACTIVATED));
		booksList.add(new Books(200,"TEST2","test2",name.DEACTIVATED));
		
		when(booksrepository.findAll()).thenReturn(booksList);
		List<Books> result = booksservice.getAllBooks();
		assertEquals(2, result.size());
	}
	
	@Test
	public void getBooksById(){
		Books books = new Books(100,"TEST1","test1",name.ACTIVATED);
		when(booksrepository.findById(100));
		Books result = booksservice.getBooksById(1);
		assertEquals(1, result.getBookid());
		assertEquals("Books Sample 1", result.getUsername());
		assertEquals("Books Password", result.getPassword());
		assertEquals("Books Status", result.getStatus());
		}
	
	@Test
	public void saveBooks(){
		Books books = new Books(100,"TEST1","test1",name.DEACTIVATED);
		when(booksrepository.save(books)).thenReturn(books);
		Books result = booksservice.saveOrUpdate(books);
		assertEquals(1, result.getBookid());
		assertEquals("Books Sample 1", result.getUsername());
		assertEquals("Books Password", result.getPassword());
		assertEquals("Books Status", result.getStatus());
	}
	
	@Test
	public void removeBooks(){
		Books books = new Books(100,"TEST1","test1",name.DEACTIVATED);
		booksservice.delete(100);;
        verify(booksrepository);
	}
	
	
}
