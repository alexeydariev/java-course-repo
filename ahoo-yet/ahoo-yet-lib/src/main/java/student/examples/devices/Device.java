package student.examples.devices;

import java.io.Serializable;

public abstract class Device implements DeviceInterface, Serializable {
    private int id;
    private String name;

    public Device () {}

    public Device(int id, String name) {
        this.setName(name);
        this.setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id >=0) this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
