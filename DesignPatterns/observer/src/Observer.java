/**
 * @author 13053
 */
public interface Observer {
    /**
     * 更新状态
     */
    void update(float temp, float humidity, float pressure);
}
