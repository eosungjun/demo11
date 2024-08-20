package com.example.demo11.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo11.dto.BookDto;

@SpringBootTest
public class BookMapperTest {
   
    @Autowired
    BookMapper bookmapper;
   
    @Test
    void testSelectBookList() {

        List<BookDto>list= bookmapper.selectBookList();
        assertEquals(116, list.size());
    }

    @Test
    void testGetTime() {
        String time= bookmapper.getTime();
        assertNotNull(time);
    }

    @Test
    void testSelectTime() {

        String time = bookmapper.selectTime();
        assertNotNull(time);
        
    }

    @Test
    void testSelectBook() {
        BookDto book = bookmapper.selectBook("B00005");
        assertEquals("INSERTBOOK", book.getTitle());
    }

    @Test
    void testDeleteBook() {

        int res = bookmapper.deleteBook("B00005");
        assertEquals(0, res);
        
    }
}
