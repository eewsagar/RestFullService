package com.rest.webservice.restfulwebservice.user;

import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static int UserCount = 3;
	private static List <User> users =  new ArrayList<>();
	static {
		users.add(new User(1,"sagar", new Date()));
		users.add(new User(2,"sagar3", new Date()));
		users.add(new User(3,"sagar3", new Date()));
		users.add(new User(4,"sagar4", new Date()));
		users.add(new User(5,"sagar5", new Date()));
	}
	
	public List<User> findAll(){
		return users;
		
	}
	
	public User Save(User user){
		if(user.getId() == 0) {
			user.setId(++UserCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id){
		for(User user: users) {
			if(user.getId() ==id) {
				return user;
			}
		}
		
		return null;
	}
	
	public User deleteById(int id){
       
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			
			if(user.getId() ==id) {
				iterator.remove();
				return user;
			}
		}
		
		return null;
	}

}
