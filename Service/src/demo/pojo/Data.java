package demo.pojo;

import java.util.List;

public class Data<T> {
    private Integer statusCode;
    private String msg;
    private List<T> data;
    private UserInfo userInfo;

    public Data() {
    }

    public Data(Integer statusCode, String msg) {
        this.statusCode = statusCode;
        this.msg = msg;
    }

    public Data(Integer statusCode, String msg, List<T> data) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.data = data;
    }

    public Data(Integer statusCode, String msg,UserInfo userInfo) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.userInfo = userInfo;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "Data{" +
                "statusCode=" + statusCode +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", userInfo=" + userInfo +
                '}';
    }
}
