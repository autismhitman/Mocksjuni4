package com.neopane.annotation;

import java.util.List;

public interface BookRepo {
	
 

	List<Book> findNewBooks(int days);
 

}
