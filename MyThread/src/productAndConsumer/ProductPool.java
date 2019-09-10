package productAndConsumer;

import java.util.LinkedList;
import java.util.List;

class ProductPool {
    List<Product> productList;
    private int maxSize;

    ProductPool(int maxSize) {
        this.productList = new LinkedList<>();
        this.maxSize = maxSize;
    }
    /*
    关于生产者生产商品和消费者消费商品，两者因为同时发生所以会被两个线程调用，所以需要成为同步方法
     */

    /**
     * 生产者生产商品
     */
    synchronized void push(Product product) {
        // 是否需要生产产品
        // 如果生产出的商品数量超过池子的大小就放开CPU资源
        if (productList.size() >= maxSize) {
            try {
                this.wait();
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 如果商品池中产品没满，就生产商品
        // 添加产品
        this.productList.add(product);
        // 通知消费者
        this.notifyAll();
    }

    /**
     * 消费者消费
     */
    synchronized Product pop() {
        // 是否还有商品能供消费
        if (productList.size() == 0) {
            try {
                this.wait();
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Product product = this.productList.remove(0);
        // 通知其他人已经取出商品
        this.notifyAll();
        return product;
    }
}
