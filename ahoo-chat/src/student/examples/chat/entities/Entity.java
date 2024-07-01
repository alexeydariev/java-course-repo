package student.examples.chat.entities;

public abstract class Entity {
    private int id;

    public Entity () {

    }

    public Entity (int id) {
        this.setId(id);
    }

    public void setId (int id) {
        if (id > 0 && id <= 1000000) {
            this.id = id;
        } else {
            System.out.println("invalid id");
        }
    }

    public int getId () {
        return this.id;
    }
}
