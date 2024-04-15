package com.neopane.annotation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;



public class AnnotationTest3 {
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	
	@Mock
	BookRepo br ;
	
	@InjectMocks
	BookService bs;
	
	
	
	@Test
	public void demoMockUsingMockAnnotations() {
		
			
		List<Book> newBooks = new ArrayList<>();
		newBooks.add(new Book("FD1", "Harry Potter", 500, LocalDate.now()));
		newBooks.add(new Book("FD2", "Lord of the rings", 400, LocalDate.now()));
		
		Mockito.when(br.findNewBooks(7)).thenReturn(newBooks);
		
		 List<Book> afterDiscount= bs.getNewBooks(10,7);
		 Assert.assertEquals(2, afterDiscount.size());
		 Assert.assertEquals(450, afterDiscount.get(0).getPrice());
		 Assert.assertEquals(360, afterDiscount.get(1).getPrice());
	 
		
	}

}
