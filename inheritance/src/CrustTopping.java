public class CrustTopping extends Crust {

    public CrustTopping () {
    }

    public String name;

    public CrustTopping (String name) {
        this.setName(name);
    }

    public CrustTopping (String name, int weight) {
        super(weight);
        this.setName(name);
        System.out.println(this.name + weight);
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }
}
