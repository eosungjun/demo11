package com.example.demo11.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo11.dto.BookDto;
import com.example.demo11.service.BookService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@Slf4j
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("list", bookService.selectBookList());
        return "book/bookList";
    }

    @GetMapping("/book/write")
    public void write() {
    
    }

    @GetMapping("/book/detail")
    public String detail(BookDto book, Model model) {
        log.info("++++++++++++++++" +book.getB_no());
        if(book.getB_no() !=null){
            book = bookService.selectBook(book.getB_no());
            model.addAttribute("book", book);
            return "/book/detail";
        }else{
            model.addAttribute("msg", "도서번호(필수)가 입력되지 않았습니다.");
            model.addAttribute("url", "/book/detail");
            return "common/msg";
        }
    }
    
    @GetMapping("/book/delete")
    public String getMethodName(@RequestParam(required=false, name="b_no") String b_no
                                    ,Model model) {
        
        if (b_no==null) {
            model.addAttribute("msg", "도서번호가 입력되지 않았습니다.");
            return "/common/msg";
        }

        int res= bookService.deleteBook(b_no);
        if(res>0){
            model.addAttribute("msg", "삭제 되었습니다.");
            model.addAttribute("url", "/");
           
        }else{
            model.addAttribute("msg", "삭제 중 예외가 발생 하였습니다.\n 관리자에게 문의해주세요");
        }

        // model 객체에 저장된 msg를 출력하고 화면을 전환 
        // 뒤로가기 또는 url로 이동 
        return "common/msg";

    }
    

}
