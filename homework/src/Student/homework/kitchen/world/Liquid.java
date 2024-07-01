package Student.homework.kitchen.world;

public class Liquid {
    private String name;
    private Integer volume;
    private Integer temp;

    public Liquid () {}

    public Liquid (String name, Integer volume, Integer temp) {
        this.setName(name);
        this.setVolume(volume);
        this.setTemp(temp);
    }

    public void setName(String name) {
        if (!name.isEmpty()) this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setVolume(Integer volume) {
        if (volume > 0) this.volume = volume;
    }

    public Integer getVolume() {
        return this.volume;
    }

    public void setTemp(Integer temp) {
        if (temp >= 0 && temp <=100 ) this.temp=temp;
    }

    public Integer getTemp() {
        return this.temp;
    }

    //methods

    public Boolean isCold() {
        if (this.temp <= 18) return true;
        return false;
    }

    public Boolean isWarm() {
        if (this.getTemp() > 18 && this.getTemp() <= 36) return true;
        return false;
    }

    public Boolean isHot() {
        if (this.getTemp() >= 36) return true;
        return false;
    }


}
