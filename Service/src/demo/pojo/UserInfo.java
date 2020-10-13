package demo.pojo;

import com.google.gson.Gson;

public class UserInfo {
    private boolean is;
//    private Integer isLogin;
    private Integer id;
    private String userName;
    private String userPW;
    private String imgUrl;
    private String likeList;

    public UserInfo() {
    }

    public UserInfo(String userName, String userPW) {
        this.userName = userName;
        this.userPW = userPW;
    }

    public UserInfo(boolean is, String userName) {
        this.is = is;
        this.userName = userName;
    }

    public UserInfo(String userName, String userPW, String imgUrl) {
        this.userName = userName;
        this.userPW = userPW;
        this.imgUrl = imgUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isIs() {
        return is;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPW() {
        return userPW;
    }

    public void setUserPW(String userPW) {
        this.userPW = userPW;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getLikeList() {
        return likeList;
    }

    public void setLikeList(String likeList) {
        this.likeList = likeList;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "is=" + is +
                ", id=" + id +
                ", userName='" + userName + '\'' +
                ", userPW='" + userPW + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", likeList=" + likeList +
                '}';
    }
}
