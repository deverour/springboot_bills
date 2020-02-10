package deverour.service;

import deverour.domain.User;

public interface UserService {

    /**
     * 登录方法
     * @param user
     * @return
     */
    User login(User user);

}
