package cn.pbb.service;

import cn.pbb.domain.Account;

/**
 * @author: pbb
 * @date: 2020/7/19 15:41
 */
public interface IAccountService {
    /**
     * find
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * transfer
     *
     * @param sourceName from
     * @param targetName to
     * @param money how much
     */
    void transfer(String sourceName, String targetName, Float money);

}
