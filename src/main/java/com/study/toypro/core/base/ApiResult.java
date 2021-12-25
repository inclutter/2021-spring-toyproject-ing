package com.study.toypro.core.base;

public class ApiResult<T> {
    private String resltCd;

    private String resltMsg;

    private T resltData;

    private String ttsMsg;

    public ApiResult(String resltCd) {
        this.resltCd = resltCd;
    }

    public ApiResult(String resltCd, String resltMsg) {
        this.resltCd = resltCd;
        this.resltMsg = resltMsg;
    }

    public ApiResult(String resltCd, String resltMsg, T resltData) {
        this.resltCd = resltCd;
        this.resltMsg = resltMsg;
        this.resltData = resltData;
    }

    public ApiResult(String resltCd, String resltMsg, T resltData, String ttsMsg) {
        this.resltCd = resltCd;
        this.resltMsg = resltMsg;
        this.resltData = resltData;
        this.ttsMsg = ttsMsg;
    }

    public String getResltCd() {
        return resltCd;
    }

    public void setResltCd(String resltCd) {
        this.resltCd = resltCd;
    }

    public String getResltMsg() {
        return resltMsg;
    }

    public void setResltMsg(String resltMsg) {
        this.resltMsg = resltMsg;
    }

    public T getResltData() {
        return resltData;
    }

    public void setResltData(T resltData) {
        this.resltData = resltData;
    }

    public String getTtsMsg() {
        return ttsMsg;
    }

    public void setTtsMsg(String ttsMsg) {
        this.ttsMsg = ttsMsg;
    }
}
