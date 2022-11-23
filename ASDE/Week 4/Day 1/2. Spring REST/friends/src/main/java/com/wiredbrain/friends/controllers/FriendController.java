package com.wiredbrain.friends.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.wiredbrain.friends.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wiredbrain.friends.model.Friend;
import com.wiredbrain.friends.services.FriendService;
import com.wiredbrain.friends.util.FieldErrorMessage;

import javax.validation.Valid;
import javax.validation.ValidationException;

@RestController
public class FriendController {

	@Autowired
	FriendService friendService;

//	@PostMapping("/friend")
//	Friend create(@RequestBody Friend friend) {
//		if (friend.getId() == 0 && friend.getFirstName() != null && friend.getLastName() != null)
//			return friendService.save(friend);
//		else
//			throw new ValidationException("friend cannot be created");
//	}

	@PostMapping("/friend")
	Friend create(@Valid @RequestBody Friend friend) {

			return friendService.save(friend);

	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class )
	List<FieldErrorMessage>	 exceptionHandler(MethodArgumentNotValidException e ) {

		List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
		List<FieldErrorMessage> fieldErrorMessages =fieldErrors.stream().map(fieldError ->
																	new FieldErrorMessage(fieldError.getField(), fieldError.getDefaultMessage()))
			                                    					.collect(Collectors.toList());
	return fieldErrorMessages;

	}

//
//	@ExceptionHandler(ValidationException.class)
//	ResponseEntity<String> exceptionHandler(ValidationException e) {
//		return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
//
//	}

//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ExceptionHandler(ValidationException.class)
//	ErrorMessage exceptionHandler(ValidationException e) {
//		return new ErrorMessage("400", e.getMessage());
//
//	}

	@GetMapping("/friend")
	Iterable<Friend> read() {
		return friendService.findAll();
	}

	@GetMapping("/friend/{id}")
	Optional<Friend> findById(@PathVariable Integer id) {

		return friendService.findById(id);

	}


	@PutMapping("/friend")
	ResponseEntity<Friend> update(@RequestBody Friend friend) {
		if (friendService.findById(friend.getId()).isPresent())
			return new ResponseEntity(friendService.save(friend), HttpStatus.OK);
		else
			return new ResponseEntity(friend, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/friend/{id}")
	void delete(@PathVariable Integer id) {
		friendService.deleteById(id);
	}



	@GetMapping("/friend/search")
	Iterable<Friend> findByQuery(@RequestParam(value = "first",  required = false) String firstName,
			@RequestParam(value = "last", required = false) String lastName) {
//	Iterable<Friend> findByQuery(@RequestParam(value = "first", required = true) String firstName,
//								 @RequestParam(value = "last", required = true) String lastName) {

		if (firstName != null && lastName != null)
			return friendService.findByFirstNameAndLastName(firstName, lastName);
		else if (firstName != null)
			return friendService.findByFirstName(firstName);
		else if (lastName != null)
			return friendService.findByLastName(lastName);
		else
			return friendService.findAll();

	}

}
