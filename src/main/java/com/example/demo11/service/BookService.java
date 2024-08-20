package com.example.demo11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo11.dto.BookDto;
import com.example.demo11.mapper.BookMapper;

@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;

    public List<BookDto>selectBookList(){
        return bookMapper.selectBookList();
    }

    public BookDto selectBook(String b_no) {
       return bookMapper.selectBook(b_no);
    }

    public int deleteBook(String b_no) {
        return bookMapper.deleteBook(b_no);
     }
}
