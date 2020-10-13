package demo.dao;

import demo.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    List<Book> queryBook();
    Book queryLikeBook(Integer bookId);
}
//    void insertBook(Book book);
//    Long updateBookImg(@Param("bookName")String bookname,@Param("bookUrl")String bookUrl);
//    Long updateBook(@Param("bookName")String bookname,@Param("author")String author,@Param("bookUrl")String bookUrl);
