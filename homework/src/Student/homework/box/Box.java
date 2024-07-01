package Student.homework.box;

public class Box implements ThingInterface{
    private ThingInterface content;

    public Box() {}

    public Box(ThingInterface content) {
        this.setContent(content);
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return "";
    }

    public ThingInterface getContent() {
        return content;
    }

    public void setContent(ThingInterface content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Box{" +
                "content=" + content +
                '}';
    }
}

