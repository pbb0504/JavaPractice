package cn.pbb.proxy;

/**
 * @author 13053
 */
public interface IProducer {
    /**
     * sell
     * @param money pay
     */
    public void sellProduct(Float money);



    /**
     * after sell
     * @param money pay
     */
    public void afterService(Float money);

}
