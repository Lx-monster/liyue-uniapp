package demo.pojo;

public class Book {
    private String fromS="l";
    private Integer bookId;
    private String bookName;
    private String author;
    private String imgUrl;
    private String bookUrl;
    private String bookInfo;

    public Book() {
    }

    public Book(Integer bookId, String bookName, String author, String bookUrl) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.bookUrl = bookUrl;
    }

    public Book(String bookName, String author, String imgUrl, String bookUrl, String bookInfo) {
        this.bookName = bookName;
        this.author = author;
        this.imgUrl = imgUrl;
        this.bookUrl = bookUrl;
        this.bookInfo = bookInfo;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", bookUrl='" + bookUrl + '\'' +
                ", bookInfo='" + bookInfo + '\'' +
                '}';
    }
}
