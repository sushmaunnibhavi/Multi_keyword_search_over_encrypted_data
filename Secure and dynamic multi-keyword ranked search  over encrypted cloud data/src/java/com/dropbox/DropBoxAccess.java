package com.dropbox;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxRequestConfig;
import java.util.Locale;

public class DropBoxAccess {

    private final static String ACCESS_TOKEN = "sl.Aw0-sEEECZx-ar_G5-K4Xn8z82y0hr7AyqLduUAF8-vbecThhj2js5PuLfKQ_tdjcm6KlSKLPhUR7zxi5MN16AuI5M-KoRDAiv3qlygEtDzkN3dwmK6S4FrdxAs6fNwERejrZb8";
    private final static String userLocale = Locale.getDefault().toString();
    private static DbxClient dbxClient;

    public static DbxClient getDbxClient() {
        DbxRequestConfig requestConfig = new DbxRequestConfig("dropbox/fyp_cyber", userLocale);
        if (dbxClient == null) {
            dbxClient = new DbxClient(requestConfig, ACCESS_TOKEN);
        }
        return dbxClient;
    }

}

