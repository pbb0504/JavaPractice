package cn.pbb.mybatis.cfg;

/**
 * @author: pbb
 * @date: 2020/6/17 22:41
 * 用于封装执行的sql语句和结果类型的全限定类名
 */
public class Mapper {
    private String queryString;
    private String resultType;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
