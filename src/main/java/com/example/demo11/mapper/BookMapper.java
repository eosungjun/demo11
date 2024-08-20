package com.example.demo11.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo11.dto.BookDto;

@Mapper
public interface BookMapper {

    @Select("select sysdate from dual")
    public String getTime();

    public String selectTime();


    public List<BookDto>selectBookList();

    public BookDto selectBook(String b_no);

    @Delete("delete from tb_book where b_no=#{b_no}")
    public int deleteBook(String b_no);
}
