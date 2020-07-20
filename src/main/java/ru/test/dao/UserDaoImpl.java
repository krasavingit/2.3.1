package ru.test.dao;

import org.springframework.stereotype.Component;
import ru.test.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    @PersistenceContext(unitName = "emf")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public User findOne( long id ){
        return entityManager.find( User.class, id );
    }
    public List< User > getAll(){
        return entityManager.createQuery( "from " + User.class.getName() )
                .getResultList();
    }
    public void create( User user ){
        entityManager.persist(user);
    }

    public User update( User user ){
        return entityManager.merge(user);
    }

    public void delete( User user ){
        entityManager.remove(user);
    }
    public void deleteById( long id ){
        delete(findOne(id));
    }
}