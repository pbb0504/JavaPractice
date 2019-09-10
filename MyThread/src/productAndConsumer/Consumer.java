package productAndConsumer;

public class Consumer extends Thread {
   private ProductPool pool;

    Consumer(ProductPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        while (pool.productList.size()>=15) {
            Product product = this.pool.pop();
            System.out.println("消费者消费了一件产品" + product.getName() +
                    "还剩余" + pool.productList.size() + "件产品");
        }
    }
}
