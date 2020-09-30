package cn.pbb.abstractPizza;

import cn.pbb.basematrial.*;

/**
 * @author: pbb
 * @date: 2020/9/30 15:03
 */
public abstract class Pizza {
    public String name;
    public Cheese cheese;
    public Clams clams;
    public Dough dough;
    public Pepperoni pepperoni;
    public Sauce sauce;
    public Veggies veggies;

    /**
     * add base material
     */
    public abstract void prepare();

    public void bake(){
        System.out.println("bake............");
    }

    public void cut(){
        System.out.println("cut....................");
    }

    public void box(){
        System.out.println("box....................");
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", cheese=" + cheese +
                ", clams=" + clams +
                ", dough=" + dough +
                ", pepperoni=" + pepperoni +
                ", sauce=" + sauce +
                ", veggies=" + veggies +
                '}';
    }
}
