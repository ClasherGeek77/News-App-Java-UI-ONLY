package dao;

import app.BaseDao;
import model.Login;
import model.News;
import org.sql2o.Connection;

import java.util.List;

public class NewsDao extends BaseDao
{
    public List<News> getNewsContent(Integer id)
    {
        String sql = "SELECT * FROM dbnews WHERE id = :id";
        try (Connection con = db.open())
        {
            return con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetch(News.class);
        }
    }


    public List<News> getNewsCategory(String category)
    {
        String sql = "SELECT * FROM dbnews WHERE Category = :category";
        try (Connection con = db.open())
        {
            return con.createQuery(sql)
                    .addParameter("category",category)
                    .executeAndFetch(News.class);
        }
    }


    public List<News> getSearchNews(String name)
    {
        name = "%"+name+"%";
        System.out.println(name);
        String sql = "SELECT * FROM dbnews WHERE NewsTitle LIKE :name";
        try (Connection con = db.open())
        {
            return con.createQuery(sql)
                    .addParameter("name",name)
                    .executeAndFetch(News.class);
        }
    }

    //register
    public void registerAccount(String  username, String  password) {
        String sql = "INSERT INTO login (username, password) VALUES(:username, :password) ";

        try(Connection con = db.open()){
            con.createQuery(sql)
                    .addParameter("username", username)
                    .addParameter("password", password)
                    .executeUpdate();
        }
    }
    //login
    public Login getLogin(String username, String password) {
        String sql = "SELECT * FROM login WHERE username = :username AND password = :password";
        try (Connection con = db.open()) {
            return con.createQuery(sql)
                    .addParameter("username", username)
                    .addParameter("password",password)
                    .executeAndFetchFirst(Login.class);
        }
    }
}
