package deverour.service.impl;


import deverour.domain.User;
import deverour.mapper.LoginMapper;
import deverour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User login(User user) {
        return loginMapper.findUserByUsernameAndPassword(user);
    }


}
