import basematrial.*;

/**
 * @author: pbb
 * @date: 2020/9/30 15:03
 */
public abstract class Pizza {
    String name;
    Cheese cheese;
    Clams clams;
    Dough dough;
    Pepperoni pepperoni;
    Sauce sauce;
    Veggies veggies;

    /**
     * prepare
     */
    abstract void prepare();

    void bake(){
        System.out.println("bake............");
    }

    void cut(){
        System.out.println("cut....................");
    }

    void box(){
        System.out.println("box....................");
    }

    void setName(String name){
        this.name = name;
    }

    String getName(){
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
