package productAndConsumer;

import java.util.LinkedList;
import java.util.List;

public class ProductPool {
    List<Product> productList;
    private int maxSize=0;
    ProductPool(int maxSize){
        this.productList=new LinkedList<Product>();
        this.maxSize=maxSize;
    }
    /**
     * 生产者生产商品
     */
    public synchronized void push(Product product){
        // 是否需要生产产品
        if(productList.size()>=maxSize){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 添加产品
        this.productList.add(product);
        // 通知消费者
        this.notifyAll();
    }

    /**
     * 消费者消费
     */
    public synchronized Product pop(){
        // 是否还有商品能供消费
        if(productList.size()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Product product=this.productList.remove(0);
        // 通知其他人已经取出商品
        this.notifyAll();
        return product;
    }
}
