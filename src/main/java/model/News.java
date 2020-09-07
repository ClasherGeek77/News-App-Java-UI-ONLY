package model;

import lombok.Getter;

public class News
{
    @Getter private Integer id;
    @Getter private String NewsTitle;
    @Getter private String NewsDesc;
    @Getter private String FullDesc;
    @Getter private String NewsDate;
    @Getter private String Arthur;
    @Getter private String Category;
    @Getter private String img;

    public News()
    {
        id = 0;
        NewsTitle = "";
        NewsDesc = "";
        FullDesc = "";
        NewsDate = "";
        Arthur = "";
        Category = "";
        img ="";
    }

    public News(Integer id, String NewsTitle, String NewsDesc, String FullDesc, String NewsDate, String Arthur, String Category,String img)
    {
        this.id = id;
        this.NewsTitle = NewsTitle;
        this.NewsDesc = NewsDesc;
        this.FullDesc = FullDesc;
        this.NewsDate = NewsDate;
        this.Arthur = Arthur;
        this.Category = Category;
        this.img = img;
    }
}
