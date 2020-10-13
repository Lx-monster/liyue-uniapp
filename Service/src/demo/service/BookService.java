package demo.service;

import demo.dao.BookMapper;
import demo.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    public List<Book> queryBook(){
        return bookMapper.queryBook();
    }
    public Book queryLikeBook(Integer id){
        return bookMapper.queryLikeBook(id);
    }
}
 /*public void insertBook(Book book){
        bookMapper.insertBook(book);
    }*/
    /*public Long updateBookImg(String bookname,String bookImage){
        return bookMapper.updateBookImg(bookname,bookImage);
    }*/
    /*public Long updateBook(String name,String author,String bookUrl){
        return bookMapper.updateBook(name,author,bookUrl);
    }*/