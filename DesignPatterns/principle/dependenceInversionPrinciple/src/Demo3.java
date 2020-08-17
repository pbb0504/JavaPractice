/**
 * @author: pbb
 * @date: 2020/8/17 12:51
 */
public class Demo3 {
}

interface IOpenAndClass {
    public void open();
}

interface ITV {
    public void play();
}

class OpenAndClass implements IOpenAndClass{
    private ITV itv;
    // 通过构造函数传入实现类
    OpenAndClass(ITV itv){
        this.itv = itv;
    }

    @Override
    public void open() {
        this.itv.play();
    }
}
