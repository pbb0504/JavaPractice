package productAndConsumer;

public class Program {
    // 生产者

    /*
     * 生产产品
     * 生产逻辑：通过一个生产标记，判断是否需要生产产品
     * 如果需要生产：生产产品，通知消费者消费
     * 不需要生产：等待
     */

    // 消费者

    /*
     *消费产品
     * 消费逻辑：判断是否有足够的产品可以消费
     * 如果可以消费：获取产品，进行消费
     * 不能消费：等待
     */
    public static void main(String[] args) {
        ProductPool productPool = new ProductPool(15);
        Productor productor = new Productor(productPool);
        productor.start();
        Consumer consumer = new Consumer(productPool);
        consumer.start();
    }
}
