package productAndConsumer;

public class Productor extends Thread{
    ProductPool pool;
    Productor(ProductPool pool){
        this.pool=pool;
    }
    @Override
    public void run(){
        while (pool.productList.size()<15){
            String name=String.valueOf(Math.random()*15+"号产品");
            System.out.println("生产了一件产品:"+name);
            Product product=new Product(name);
            this.pool.push(product);
        }
    }
}
