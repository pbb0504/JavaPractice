package cn.pbb.mybatis.sqlsession;

/**
 * @author 13053
 */
public interface SqlSessionFactory {
    /**
     * 返回SqlSession对象
     * @return SqlSession
     */
    public SqlSession openSession();
}
