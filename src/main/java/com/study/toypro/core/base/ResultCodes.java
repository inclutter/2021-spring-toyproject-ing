package com.study.toypro.core.base;

public enum ResultCodes {
    /** 정상 처리 **/
    SUCCESS_200("200", "200"),

    /** 요청 오류 **/
    SUCCESS_400("400", "400")
    ;

    private String code;

    private String msgId;

    private ResultCodes(String code, String msgId) {
        this.code = code;
        this.msgId = msgId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
