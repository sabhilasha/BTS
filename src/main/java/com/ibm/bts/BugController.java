package com.ibm.bts;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bts.entity.Bug;
import com.ibm.bts.service.BugService;

@RestController
public class BugController {
	@Autowired
	BugService bugService;
	@PostMapping("/bug")
	
	/**
	 * method to create bug
	 * @param bug
	 * @param bindingResult
	 * @return the id
	 */
	
	String createBug(@RequestBody Bug bug,BindingResult bindingResult) {
		validateModel(bindingResult);
		return bugService.createBug(bug);
	}
	
	/**
	 * validation
	 * @param bindingResult
	 */
	
	private void validateModel(Errors bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Somethign went wrong. Plesae retry");
		}
	}
	
	/**
	 * method to search bugId
	 * @param bugId
	 * @return zero or matchingId
	 */
	@GetMapping("/bug/{id}")
	Optional<Bug> getBug(@PathVariable ("id") String bugId) {
		return bugService.getBug(bugId);
	}
	/**
	 * updates the changes in Bug
	 * @param bugId
	 * @param bug
	 * @param bindingResult
	 */
	
	@PutMapping("/bug/{id}")
	void updateBug(@PathVariable ("id") String bugId,@RequestBody Bug bug,BindingResult bindingResult) {
		validateModel(bindingResult);
		bug.setId(bugId);
		bugService.updateBug(bug);
	}
	/**
	 * deletes a bug
	 * @param bugId
	 */
	@DeleteMapping("/bug/{id}")
	void deleteBug(@PathVariable ("id") String bugId) {
		bugService.deleteBug(bugId);
		
	}

}
