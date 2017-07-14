package com.niit.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.TaskBacend.Dao.FileDao;
import com.niit.TaskBacend.Dao.UserDetailsDao;
import com.niit.TaskBacend.Model.UploadFile;
import com.niit.TaskBacend.Model.UserDetails;

@Controller
public class HomeController {
	@Autowired
	UserDetailsDao userDetailsDao;

	@Autowired
	FileDao fileDao;
	@Autowired
	UserDetails userDetails;

	@RequestMapping(value = "/")
	public String showIndex() {
		return "home";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String handleFileUpload(@ModelAttribute UploadFile uploadFile, HttpServletRequest request,
			@RequestParam CommonsMultipartFile[] fileUpload, @ModelAttribute UserDetails userDetails) throws Exception {
		userDetailsDao.saveorupdate(userDetails);
		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload) {

				System.out.println("Saving file: " + aFile.getOriginalFilename());

				uploadFile.setFileName(aFile.getOriginalFilename());
				uploadFile.setData(aFile.getBytes());
				fileDao.save(uploadFile);
			}
		}

		return "index";
	}

	@RequestMapping("/viewDetails")
	public ModelAndView viewDetails() {

		List<UserDetails> List = userDetailsDao.list();
		List<UploadFile> List1 = fileDao.list();
		ModelAndView mv = new ModelAndView("/viewDetails");
		mv.addObject("details", List);
		mv.addObject("details1", List1);

		return mv;
	}

}
