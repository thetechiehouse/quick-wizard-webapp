package com.techiehouse.quickwebapp.repositories;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.techiehouse.quickwebapp.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	@Autowired MongoTemplate mongoTemplate;
    static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

	private List<User> users = new ArrayList<>();

	public UserRepositoryImpl() {
	}

	public User getById1(String id) {
		for (User u : this.users) {
			if (u.getId() == id) {
				return u;
			}
		}
		User user = new User();
		user.setId("USERNOTFOUND");
		return user;
	}

	public List<User> getAll() {
		return this.users;
	}

	@Override
	public User create(User user) {	
		mongoTemplate.insert(user); 
		return user;
	}

	@Override
	public User update(User user) {
		/*String id=user.getId();
		User byId = this.getById(user.getId());
		byId.setFirstName(user.getFirstName());
		byId.setLastName(user.getLastName());
		mongoTemplate.remove(user);
		*/
		mongoTemplate.save(user);
		return this.getById(user.getId());
	}
	
	
	@Override
	public User getById(String id) {
		Query query5 = new Query();
		query5.addCriteria(Criteria.where("id").gte(id));
		// TODO Auto-generated method stub

		List<User> users = mongoTemplate.find(query5, User.class);
		if (users.size() > 0)
			return users.get(0);
		else
			return null;
	}

	@Override
	public void remove(String id) {
		User userToBeRemoved = mongoTemplate.findById(id, User.class);
		mongoTemplate.remove(userToBeRemoved) ; 

	}

	@Override
	public int getNumberOfUsers() {
		return this.users.size();
	}



	@Override
	public List<User> getAllUsers() {
		return getAll();
	}

	@Override
	public User createNewUser(User user) {
		return create(user);
	}

	@Override
	public Iterable<User> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<User> findAll() {
		List<User> results = mongoTemplate.findAll(User.class);
        logger.info("Total amount of persons: {}", results.size());
        logger.info("Results: {}", results);	
        return results;
	}

	@Override
	public Iterable<User> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends User> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	
}
