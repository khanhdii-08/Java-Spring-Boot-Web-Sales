package com.nhom11.webseller.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.nhom11.webseller.dto.UserRequest;
import com.nhom11.webseller.model.Authority;
import com.nhom11.webseller.model.User;
import com.nhom11.webseller.service.AuthorityService;
import com.nhom11.webseller.service.StorageService;
import com.nhom11.webseller.service.UserService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("admin/users")
public class UserController {

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Autowired
	private UserService userService;

	@Autowired
	private AuthorityService authorityService;

    @Autowired
    private StorageService storageService;

    @GetMapping("/images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> transferFile(@PathVariable(name = "filename") String fileName) {
		Resource file = storageService.loadAsResoure(fileName);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@GetMapping
    public String list(ModelMap model){
        List<User> list = userService.findAll();
		model.addAttribute("users", list);
        System.out.println(list);
        return "admin/user/list-user";
    }

	@GetMapping("/addForm")
	public String showFormAddUser(Model model){
		model.addAttribute("user", new UserRequest());
		return "admin/user/add-user";
	}

	@PostMapping("/saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, UserRequest userRequest){
		Date utilDate  = new Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		UUID uuid = UUID.randomUUID();
		String uuString = uuid.toString();
		User user = new User();
		BeanUtils.copyProperties(userRequest, user);
		if(userRequest.getEnabled() == 0)
			user.setEnabled(true);
		else
			user.setEnabled(false);
		user.setRegisteredAt(sqlDate);

		try {
			if(userRequest.getImage() != null)
				storageService.delete(userRequest.getImage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}

		user.setImage(storageService.getStoredFilename(userRequest.getImageFile(), uuString));
		storageService.store(userRequest.getImageFile(), user.getImage());

		String encodedPassword = passwordEncoder.encode(user.getPassword());
        encodedPassword = "{bcrypt}" + encodedPassword;

		user.setPassword(encodedPassword);

		userService.save(user);

		Authority authority = new Authority(0, user, userRequest.getAuthority());
		authorityService.save(authority);

		return new ModelAndView("redirect:/admin/users");
	}

}
