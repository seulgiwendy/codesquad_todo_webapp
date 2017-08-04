package com.wheejuni.spring;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wheejuni.spring.domain.Todo;

@Controller
public class TodoController {
	ArrayList<Todo> todolist = new ArrayList<>();

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView setTodo(Todo todo) {
		todo.setTime();
		todolist.add(todo);
		return new ModelAndView("redirect:/");
	}
	
	/*@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String returnNewPage() {
		return "/new.html";
	}*/
	
	@RequestMapping (value = "/", method = RequestMethod.GET)
	public ModelAndView getTodo() {

		ModelAndView mav = new ModelAndView("index");
		
		mav.addObject("todolist", todolist);
		return mav;
	}

}
