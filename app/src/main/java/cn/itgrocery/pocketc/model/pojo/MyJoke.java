package cn.itgrocery.pocketc.model.pojo;

/**
 * @Author chenxl
 * @Date 2017/9/8 17:33
 * @Describle
 */

public class MyJoke {
    private String title;
    private String content;
    private String poster;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MyJoke{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", poster='" + poster + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
