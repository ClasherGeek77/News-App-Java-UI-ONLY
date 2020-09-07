package controllers;

import app.Path;
import app.View;
import dao.NewsDao;
import model.Login;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

public class NewsController
{
    private static NewsDao dao = new NewsDao();
    private static Login loginstatus;

    public static Route serveSearchNewsPage=(Request req, Response res) ->
    {
        System.out.println("s");
        Map<String, Object> model = new HashMap<>();
        String newsTitle = req.queryParams("keyword");
        model.put("NewsList", dao.getSearchNews(newsTitle));

        return View.render(req, model, Path.Template.NEWS_CATEGORY);
    };

    public static Route serveVievNewsRead= (Request req, Response res) ->
    {
        Map<String, Object> model = new HashMap<>();
        Integer id = Integer.parseInt(req.params("id"));
        model.put("NewsContent", dao.getNewsContent(id));
        return View.render(req, model, Path.Template.NEWS_READ);
    };

    public static Route serveViewNewsPage = (Request req, Response res) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("NewsHot", dao.getNewsCategory("Hot"));
        model.put("NewsSport", dao.getNewsCategory("Sport"));
        model.put("NewsPolitic", dao.getNewsCategory("Politic"));
        model.put("NewsTravel", dao.getNewsCategory("Travel"));
        model.put("NewsCrimes", dao.getNewsCategory("Crimes"));

        return View.render(req, model, Path.Template.NEWS);
    };

    public static Route serveViewCategoryPage = (Request req, Response res) ->
    {
        Map<String, Object> model = new HashMap<>();
        String category = req.params("Category");
        model.put("NewsList", dao.getNewsCategory(category));

        return View.render(req, model, Path.Template.NEWS_CATEGORY);
    };

    public static Route serveViewLogin = (Request req, Response res) ->
    {
        Map<String, Object> model = new HashMap<>();
        //cek apakah belom login
        if (loginstatus!=null){
            res.redirect(Path.Web.NEWS_ACCOUNT_STATUS);
            return null;
        }
        return View.render(req, model, Path.Template.NEWS_LOGIN);
    };
    public static Route handleLogin = (Request req, Response res)-> {
        Map<String, Object> model = new HashMap<>();

        String username = req.queryParams("username");
        String password = req.queryParams("password");


        loginstatus = dao.getLogin(username,password);


        if (loginstatus!=null){
            res.redirect(Path.Web.NEWS_ACCOUNT_STATUS);
            return null;
        }
        return View.render(req, model, Path.Template.NEWS_LOGIN);
    };
//done
    public static Route serveViewRegister = (Request req, Response res) ->
    {
        Map<String, Object> model = new HashMap<>();
        return View.render(req, model, Path.Template.NEWS_REGISTER);
    };
    //done
    public static Route handleRegister = (Request req, Response res)-> {
        Map<String, Object> model = new HashMap<>();

        String username = req.queryParams("username");
        String password =  req.queryParams("password");

        dao.registerAccount(username, password);

        return View.render(req, model, Path.Template.NEWS_REGISTER);
    };

    public static Route serveViewAccountStatus = (Request req, Response res) ->
    {
        Map<String, Object> model = new HashMap<>();
        return View.render(req, model, Path.Template.NEWS_ACCOUNT_STATUS);
    };
    public static Route handleAccountStatusLogout = (Request req, Response res) ->
    {
        Map<String, Object> model = new HashMap<>();
        loginstatus = dao.getLogin("null","null");
        return View.render(req, model, Path.Template.NEWS_LOGIN);
    };


}
