package springmvc.model;

public class PersonInfo {
    private Integer id;

    private String name;

    private Websites websites;

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


    public Websites getWebsites() {
        return websites;
    }

    public void setWebsites(Websites websites) {
        this.websites = websites;
    }
}
