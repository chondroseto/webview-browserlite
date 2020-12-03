package com.xela.browser.model;

public class HistoryData {

    private String no,link;

    public HistoryData(String no, String link) {
        this.no = no;
        this.link = link;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
