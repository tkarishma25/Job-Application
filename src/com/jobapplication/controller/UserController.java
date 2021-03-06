/*
 * This controller handles new user registration
 * Author: Anusha
 */
package com.jobapplication.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jobapplication.entity.User;
import com.jobapplication.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	// Injecting the user service
	@Autowired
	private UserService userService;

	@GetMapping("/showFormForRegister")
	public String showFormForRegister(ModelMap theModel) {
		//This method renders model to view
		User theUser = new User();
		theModel.addAttribute("user", theUser);
		return "register-form";
	}

	@PostMapping("/registerUser")
	public ModelAndView registerUser(@ModelAttribute("user") @Valid User theUser, BindingResult theBindingResult) {
		/*
		 * This method checks for user name existence
		 * Based on role of the user redirects to corresponding home page
		 */
		ModelAndView mav = null;
		boolean checkUser;
		checkUser = userService.checkUserNameExists(theUser);
		if (theBindingResult.hasErrors()) {
			mav = new ModelAndView("register-form");
		}
		// save the user using our service
		else {
			if (checkUser) {
				String retVal = userService.saveUser(theUser);
				if (theUser.getRole().equals("Applicant")) {
					int empId = userService.getUser(theUser.getId());
					mav = new ModelAndView("homepage-applicant");
					mav.addObject("successmessage", "You registered successfully!!");
					mav.addObject("firstname", theUser.getFirstName());
					mav.addObject("id", empId);

				} else {
					int appId = userService.getUser(theUser.getId());
					mav = new ModelAndView("homepage-employer");
					mav.addObject("successmessage", "You registered successfully!!");
					mav.addObject("firstname", theUser.getFirstName());
					mav.addObject("id", appId);
				}
			} 
			else {
				mav = new ModelAndView("register-form");
				mav.addObject("message", "Username already exists!!");
			}
		}
		return mav;
	}
}
