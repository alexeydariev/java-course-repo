package Student.homework.kitchen.cup;

import Student.homework.kitchen.world.Liquid;

public class Cup{
    private Liquid liquid;
    private static final int MAX_VOLUME = 600;

    public Cup () {}


    public Cup (Liquid liquid) {
        this.setLiquid(liquid);
    }

    public void setLiquid (Liquid liquid) {
        if (checkLiquidName(liquid) && checkLiquidVolume(liquid)) this.liquid = liquid;
    }

    public Liquid getLiquid() {
        return this.liquid;
    }

    public void setLiquidVolume(Integer volume) {
        if ((liquid.getVolume() + volume) < MAX_VOLUME) liquid.setVolume(volume);
    }

    public Integer getLiquidVolume() {
        return this.liquid.getVolume();
    }

    public Boolean checkLiquidName(Liquid liquid) {
        return liquid.getName().equals("Water") || liquid.getName().equals("Milk") || liquid.getName().equals("Tea");
    }

    public Boolean checkLiquidVolume(Liquid liquid) {
        return liquid.getVolume() >= 0 && liquid.getVolume() <= MAX_VOLUME;
    }

    @Override
    public String toString() {
        return "Cup{" +
                "liquidName='" + this.liquid.getName() + '\'' +
                ", liquidVolume=" + this.liquid.getVolume() +
                '}';
    }


}

class SmallCup extends Cup {

    public SmallCup () {}

    /*
    public SmallCup (String liquidName, Integer liquidVolume) {
        super.setLiquidName(liquidName);
        this.setLiquidVolume(liquidVolume);
    }

    @Override
    public void setLiquidVolume(Integer liquidVolume) {
        if (liquidVolume < 0 || liquidVolume > 250) {
            super.setLiquidVolume(null);
        }
        super.setLiquidVolume(liquidVolume);
    }

     */
}

class BigCup extends Cup {
    //private Integer liquidVolume;

    public BigCup () {}
    /*
    public BigCup (String liquidName, Integer liquidVolume) {
        super.setLiquidName(liquidName);
        this.setLiquidVolume(liquidVolume);
    }

    @Override
    public void setLiquidVolume(Integer liquidVolume) {
        if (liquidVolume < 0 || liquidVolume > 1000) {
            super.setLiquidVolume(null);
        }
        super.setLiquidVolume(liquidVolume);
    }

     */
}