package com.wiredbrain.friends.services;

import org.springframework.data.repository.CrudRepository;

import com.wiredbrain.friends.model.Friend;
import org.springframework.stereotype.Repository;

//@Repository
// JpaRepository
//PagingAndSortingRepository
public interface FriendService extends CrudRepository<Friend, Integer> {

	Iterable<Friend> findByFirstNameAndLastName(String firstName, String lastName);

	Iterable<Friend> findByFirstName(String firstName);

	Iterable<Friend> findByLastName(String lastName);

}
