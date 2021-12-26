package com.study.toypro.core.utilities;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;

public class StaticMessageSourceUtility {
    //
    private static MessageSourceAccessor msgSrcAcs;

    public static MessageSourceAccessor getMsgSrcAcs() {
        return msgSrcAcs;
    }

    public static void setMsgSrcAcs(MessageSourceAccessor msgSrcAcs) {
        StaticMessageSourceUtility.msgSrcAcs = msgSrcAcs;
    }

    /**
     * KEY에 해당하는 메세지 반환
     *
     * @param  key
     * @return
     */
    public static String getMessage(String key) {
        return msgSrcAcs.getMessage(key, LocaleContextHolder.getLocale());
    }

    /**
     * KEY에 해당하는 메세지 반환
     *
     * @param  key
     * @return
     */
    public static String getMessage(String key, Object[] objs) {
        return msgSrcAcs.getMessage(key, objs, LocaleContextHolder.getLocale());
    }
}
