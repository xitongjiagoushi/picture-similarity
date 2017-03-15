package com.brctl.vo;

/**
 * Created by Duan Xiaoxing on 2017-03-07.
 */
public class ResponseVO {

    private String url;
    private ResponseStatus status;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
