import app.Path;
import controllers.NewsController;

import static spark.Spark.*;

public class Application {
    public static void main (String[] args)
    {
        staticFileLocation("assets");

        get(Path.Web.NEWS, NewsController.serveViewNewsPage);

        get(Path.Web.NEWS_CATEGORY, NewsController.serveViewCategoryPage);

        get(Path.Web.NEWS_READ, NewsController.serveVievNewsRead);

        post(Path.Web.NEWS_RESULT, NewsController.serveSearchNewsPage);

        get(Path.Web.NEWS_LOGIN, NewsController.serveViewLogin);
        post(Path.Web.NEWS_LOGIN, NewsController.handleLogin);

        get(Path.Web.NEWS_REGISTER, NewsController.serveViewRegister);
        post(Path.Web.NEWS_REGISTER, NewsController.handleRegister);

        get(Path.Web.NEWS_ACCOUNT_STATUS, NewsController.serveViewAccountStatus);
        post(Path.Web.NEWS_ACCOUNT_STATUS, NewsController.handleAccountStatusLogout);
    }
}
