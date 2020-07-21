package ru.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.dao.UserDao;
import ru.test.models.User;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public List<User> getAll() {
        return userDao.getAll();
    }
    @Transactional
    public User get( Long id ) {
        return userDao.findOne(id);
    }
    @Transactional
    public void add(User user) {
        userDao.create(user);
    }
    @Transactional
    public long getMin() {
        User user = userDao.getAll().get(0);
        return user.getId();
    }
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }
    @Transactional
    public void edit(User user) {
        User exsistUser = userDao.findOne(user.getId());
        exsistUser.setName(user.getName());
        exsistUser.setEmail(user.getEmail());
        exsistUser.setPassword(user.getPassword());
        exsistUser.setRole(user.getRole());
        userDao.update(exsistUser);
    }
    @Transactional
    public User getUser(long id){
        return userDao.findOne(id);
    }
    @Transactional
    public void deleteById( long id ){
        userDao.deleteById(id);
    }
}