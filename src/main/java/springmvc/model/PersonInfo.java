package springmvc.model;

public class PersonInfo {
    private Integer id;

    private String name;

    private Integer websiteid;

    private String url;

    private Integer alexa;

    private String country;

    public PersonInfo(Integer id, String name, Integer websiteid, String url, Integer alexa, String country) {
        this.id = id;
        this.name = name;
        this.websiteid = websiteid;
        this.url = url;
        this.alexa = alexa;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWebsiteid() {
        return websiteid;
    }

    public void setWebsiteid(Integer websiteid) {
        this.websiteid = websiteid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getAlexa() {
        return alexa;
    }

    public void setAlexa(Integer alexa) {
        this.alexa = alexa;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
