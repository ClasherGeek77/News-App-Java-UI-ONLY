package app;

import lombok.Getter;

public class Path {
    public static class Web {
        @Getter public static final String NEWS = "/news/";
        @Getter public  static final String NEWS_CATEGORY = "/news/:category/";

        @Getter public static final String NEWS_LOGIN = "/news/account/login/";
        @Getter public static final String NEWS_REGISTER = "/news/account/register/";
        @Getter public static final String NEWS_ACCOUNT_STATUS = "/news/account/status/";
        @Getter public static final String NEWS_READ = "/news/:id/read/";
        @Getter public static final String NEWS_RESULT = "/news/result/";
    }

    public static class Template {
        public static final String NEWS = "/velocity/news/news.vm";
        public static final String NEWS_CATEGORY = "/velocity/news/news_category.vm";
        public static final String NEWS_LOGIN = "/velocity/news/news_login.vm";
        public static final String NEWS_REGISTER = "/velocity/news/news_register.vm";
        public static final String NEWS_ACCOUNT_STATUS = "/velocity/news/news_account_status.vm";
        public static final String NEWS_READ = "/velocity/news/news_read.vm";
    }
}
