package Student.homework.box;

public class Journal implements ThingInterface{
    private ThingInterface content;
    private Integer pages;
    private String title;
    private String category;

    public Journal() {}

    public Journal(ThingInterface content, Integer pages, String title, String category) {
        this.setContent(content);
        this.setPages(pages);
        this.setTitle(title);
        this.setCategory(category);
    }

    public void setName(String name) {
    }

    public String getName() {
        return "";
    }

    public void setContent(ThingInterface content) {
        this.content = content;
    }

    public ThingInterface getContent() {
        return this.content;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "content=" + content +
                ", pages=" + pages +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
