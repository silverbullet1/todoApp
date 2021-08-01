package com.scaler.todoapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TodoResponse{

	public TodoResponse(String task, boolean done) {
		this.task = task;
		this.done = done;
	}
	@JsonProperty("task")
	private String task;

	@JsonProperty("done")
	private boolean done;

	public String getTask(){
		return task;
	}

	public boolean getDone(){
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
}