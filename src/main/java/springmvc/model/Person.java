package springmvc.model;

public class Person {
    private Integer id;

    private String name;

    private Integer websiteid;

    public Person(Integer id, String name, Integer websiteid) {
        this.id = id;
        this.name = name;
        this.websiteid = websiteid;
    }

    public Person() {
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

    public Integer getWebsiteid() {
        return websiteid;
    }

    public void setWebsiteid(Integer websiteid) {
        this.websiteid = websiteid;
    }
}