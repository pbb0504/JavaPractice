package cn.pbb.service;

/**
 * @author: pbb
 * @date: 2020/7/17 14:22
 */
public interface IAccountService {
    /**
     * save
     */
    void saveAccount();

    /**
     * update
     *
     * @param id
     */
    void updateAccount(int id);

    /**
     * delete
     *
     * @return
     */
    int deleteAccount();
}
