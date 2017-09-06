package springmvc.model;

public class Websites {
    private Integer id;

    private String name;

    private String url;

    private Integer alexa;

    private String country;

    public Websites(Integer id, String name, String url, Integer alexa, String country) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.alexa = alexa;
        this.country = country;
    }

    public Websites() {
        super();
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
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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
        this.country = country == null ? null : country.trim();
    }
}