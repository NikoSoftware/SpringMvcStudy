package springmvc.model;

public class PersonInfo {
    private Integer id;

    private String name;

    private Person websiteid;

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

    public Person getWebsiteid() {
        return websiteid;
    }

    public void setWebsiteid(Person websiteid) {
        this.websiteid = websiteid;
    }
}
