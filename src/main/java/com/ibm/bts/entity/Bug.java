package com.ibm.bts.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class Bug {
	@NotBlank
	@NotNull
	private String status;
	@NotNull
	@NotBlank
	private String description;
	@Id
	private String id;
	Date date = new Date();

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		int count = 0;
		String[] arr = { "New", "Assigned", "Open", "Reopen", "Closed", "Verified", "Fixed", "PendingRequest",
				"Retest" };
		for (int i = 0; i < arr.length; i++) {
			if (status.equals(arr[i])) {
				count++;
			}
		}
		if (count == 0) {
			throw new IllegalArgumentException("Invalid Status");
		}
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
