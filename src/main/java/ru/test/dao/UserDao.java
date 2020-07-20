package ru.test.dao;

import ru.test.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    User findOne(long id);

    User update(User user);

    void delete(User user);

    void create(User user);

    void deleteById(long id);
}
