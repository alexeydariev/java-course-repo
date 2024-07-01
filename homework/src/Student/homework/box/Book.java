package Student.homework.box;

public class Book implements ThingInterface{
    private ThingInterface content;
    private Integer pages;
    private String title;
    private String authorName;
    private Integer publishingYear;

    public Book() {}

    public Book(ThingInterface content, Integer pages, String title, String authorName, Integer publishingYear) {
        this.setContent(content);
        this.setPages(pages);
        this.setTitle(title);
        this.setAuthorName(authorName);
        this.setPublishingYear(publishingYear);
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(Integer publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String toString() {
         return "Book{" +
                "content=" + content +
                ", pages=" + pages +
                ", title='" + title + '\'' +
                 ", authorName='" + authorName + '\'' +
                ", publishingYear='" + publishingYear + '\'' +
                '}';
    }
}

