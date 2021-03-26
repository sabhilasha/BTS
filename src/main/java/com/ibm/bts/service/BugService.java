package com.ibm.bts.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ibm.bts.entity.Bug;
import com.ibm.bts.repo.BugRepository;

@Service
public class BugService {
	@Autowired
	BugRepository bugRepository;
	/**
	 * create bug
	 * @param bug
	 * @return the id
	 */

	public String createBug(@RequestBody Bug bug) {
		Bug savedBug = bugRepository.save(bug);
		return savedBug.getId();
	}
	/**
	 * 
	 * @param bugId
	 * @return bug details
	 */

	public Optional<Bug> getBug(String bugId) {
		return bugRepository.findById(bugId);
	}
	public void updateBug(@RequestBody Bug bug) {
		bugRepository.save(bug);
	}

	public void deleteBug(String bugId) {
		bugRepository.deleteById(bugId);
	}

}
