package cn.pbb.dao;

import cn.pbb.domain.Account;

import java.util.List;

public interface IAccountDao {
    List<Account> findAllAccount();
}
