package com.techiehouse.quickwebapp.web;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techiehouse.quickwebapp.entity.User;
import com.techiehouse.quickwebapp.repositories.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PersonRepositoryTests {

    @Autowired UserRepository repository;

    @Test
    public void readsFirstPageCorrectly() {

      Page<User> users = repository.findAll(new PageRequest(0, 10));
      System.out.println("size is "+users.getSize());
    }
}    