package com.brctl.vo;

/**
 * Created by Duan Xiaoxing on 2017-03-07.
 */
public class PictureVO {

    // base64编码值
    private String base64;

    public String getBase64() {
        return deleteBase64Header(base64);
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    // 删除base64头信息
    private String deleteBase64Header(String base64) {
        int indexOfBlank = base64.indexOf(",");
        if(indexOfBlank > -1) {
            base64 = base64.substring(indexOfBlank + 1);
        }
        return base64;
    }
}
