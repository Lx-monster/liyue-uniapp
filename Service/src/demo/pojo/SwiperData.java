package demo.pojo;

public class SwiperData {
    private Integer swiperId;
    private String swiperName;
    private String author;
    private String imageUrl;
    private String bookUrl;
    private String swiperInfo;

    public SwiperData() {
    }

    public SwiperData(Integer swiperId, String swiperName, String author, String imageUrl, String bookUrl, String swiperInfo) {
        this.swiperId = swiperId;
        this.swiperName = swiperName;
        this.author = author;
        this.imageUrl = imageUrl;
        this.bookUrl = bookUrl;
        this.swiperInfo = swiperInfo;
    }

    public Integer getSwiperId() {
        return swiperId;
    }

    public void setSwiperId(Integer swiperId) {
        this.swiperId = swiperId;
    }

    public String getSwiperName() {
        return swiperName;
    }

    public void setSwiperName(String swiperName) {
        this.swiperName = swiperName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSwiperInfo() {
        return swiperInfo;
    }

    public void setSwiperInfo(String swiperInfo) {
        this.swiperInfo = swiperInfo;
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

    @Override
    public String toString() {
        return "SwiperData{" +
                "swiperId=" + swiperId +
                ", swiperName='" + swiperName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", swiperInfo='" + swiperInfo + '\'' +
                ", author='" + author + '\'' +
                ", bookUrl='" + bookUrl + '\'' +
                '}';
    }
}
