package springmvc.model;

public class ImageData {
    private Integer id;

    private String imagepath;

    public ImageData(Integer id, String imagepath) {
        this.id = id;
        this.imagepath = imagepath;
    }

    public ImageData() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath == null ? null : imagepath.trim();
    }
}