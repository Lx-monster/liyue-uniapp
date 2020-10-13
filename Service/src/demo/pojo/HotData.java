package demo.pojo;

public class HotData {
    private Integer hotId;
    private String booksName;
    private String author;
    private String imageUrl;
    private String bookUrl;
    private String bookInfo;

    public HotData() {
    }

    public HotData(Integer hotId, String booksName, String author, String imageUrl, String bookUrl, String bookInfo) {
        this.hotId = hotId;
        this.booksName = booksName;
        this.imageUrl = imageUrl;
        this.author = author;
        this.bookUrl = bookUrl;
        this.bookInfo = bookInfo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBooksName() {
        return booksName;
    }

    public void setBooksName(String booksName) {
        this.booksName = booksName;
    }

    public Integer getHotId() {
        return hotId;
    }

    public void setHotId(Integer hotId) {
        this.hotId = hotId;
    }

    @Override
    public String toString() {
        return "HotData{" +
                "hotId=" + hotId +
                ", booksName='" + booksName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", author='" + author + '\'' +
                ", bookUrl='" + bookUrl + '\'' +
                ", bookInfo='" + bookInfo + '\'' +
                '}';
    }
}