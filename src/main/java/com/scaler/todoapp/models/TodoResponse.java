package com.scaler.todoapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoResponse{

	public TodoResponse(String task, boolean done) {
		this.task = task;
		this.done = done;
	}
	@JsonProperty("task")
	private String task;

	@JsonProperty("done")
	private boolean done;

}