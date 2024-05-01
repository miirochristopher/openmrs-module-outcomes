/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.outcomes.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.User;
import org.openmrs.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class configured as controller using annotation and mapped with the URL of
 * 'module/outcomes/outcomesLink.form'.
 */
@Controller("${rootrootArtifactId}.outcomesController")
@RequestMapping(value = "module/outcomes/outcomes.form")
public class OutcomesController {
	
	protected final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	UserService userService;
	
	private final String VIEW = "/module/outcomes/outcomes";
	
	@RequestMapping(method = RequestMethod.GET)
	public String onGet() {
		return VIEW;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onPost(HttpSession httpSession, @ModelAttribute("anyRequestObject") Object anyRequestObject,
	        BindingResult errors) {
		if (errors.hasErrors()) {
			log.info(errors);
		}
		return VIEW;
	}
	
	@ModelAttribute("users")
	protected List<User> getUsers() throws Exception {
		return userService.getAllUsers();
	}
}