package com.attrecto.academy.java.courseapp.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attrecto.academy.java.courseapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByName(String name);
	
	
	
	//A kapott string alapján szűrjön a felhasználók nevére úgy hogy a ne tegyen 
	//különbséget kis és nagybetűk között
	//A visszadott felhasználókat név és id szerint növekvő sorrendbe rendezze
	
	//List<User> findByNameContainingIgnoreCaseOrderByNameAscOrderByidAsc(String name);

}
