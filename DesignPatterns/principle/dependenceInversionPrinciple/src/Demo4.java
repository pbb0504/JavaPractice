/**
 * @author: pbb
 * @date: 2020/8/17 12:51
 */
public class Demo4 {
}

interface Interface1 {
    void open();
    void setTV(TV tv);
}

interface TV {
    void play();
}

class OpenAndPlay implements Interface1{
    private TV tv;

    @Override
    public void open() {
        this.tv.play();
    }

    @Override
    public void setTV(TV tv) {
        this.tv = tv;
    }
}
