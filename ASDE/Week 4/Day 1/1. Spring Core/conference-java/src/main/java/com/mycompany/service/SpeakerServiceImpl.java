package com.mycompany.service;

import java.util.List;

import com.mycompany.model.Speaker;
import com.mycompany.repository.HibernateSpeakerRepositoryImpl;
import com.mycompany.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service("speakerService")
@Profile("dev")
public class SpeakerServiceImpl implements SpeakerService {

	private SpeakerRepository repository;

//	public SpeakerServiceImpl() {
//		System.out.println("SpeakerServiceImpl no args constructor");
//	}

//	@Autowired
	public SpeakerServiceImpl(SpeakerRepository speakerRepository) {

		System.out.println("SpeakerServiceImpl repository constructor");
		this.repository = speakerRepository;
	}

	@PostConstruct
	private void initialize(){
		System.out.println("We're called after the constructors");
	}

	@Override
	public List<Speaker> findAll() {
		return repository.findAll();
	}

//	@Autowired
	public void setRepository(SpeakerRepository repository) {

		System.out.println("SpeakerServiceImpl setter");
		this.repository = repository;
	}

	public SpeakerRepository getRepository() {
		return repository;
	}
}
