package net.login.springbootsecurity.web;

import net.login.springbootsecurity.entities.Role;
import net.login.springbootsecurity.entities.User;
import net.login.springbootsecurity.entities.UserRole;
import net.login.springbootsecurity.repositories.RoleRepository;
import net.login.springbootsecurity.repositories.UserRepository;
import net.login.springbootsecurity.repositories.UserRoleRepository;
import net.login.springbootsecurity.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/Home")
public class HomeController
{
	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping("")
	public String home(Model model)
	{
//		model.addAttribute("msgs", messageRepository.findAll());



		return "index";
	}
	
//	@PostMapping("/messages")
//	public String saveMessage(Message message)
//	{
//		messageRepository.save(message);
//		return "redirect:/home";
//	}

	@GetMapping("/add-users")
	public String test(Model model){
		User temp = new User();

		model.addAttribute("user",temp);
		model.addAttribute("Role", roleRepository.findAll());
		return "addusers";
	}

	@PostMapping("/user/add")
	public String addStudent(@Valid User user) {

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		UserRole temp = new UserRole();




		temp.setUserId(user.getId());

//		By Default admin can only add users with role ROLE_USER, for admins will be later on

		temp.setRoleId(2);


		userRoleRepository.save(temp);
		return "redirect:/Home";

//		for(int i = 0 ; i < r.size(); i++){
//			if(r.get(i).toString().equals("ROLE_ADMIN")){
//				temp.setRoleId(1);
//				userRoleRepository.save(temp);
//				break;
//			}
//			else{
//				temp.setRoleId(2);
//				userRoleRepository.save(temp);
//				break;
//			}
//		}







	}

	@GetMapping("/Change-Password")
	public String pwchange(Model model){
		User temp = new User();
		model.addAttribute("user",temp);
		return "ChangePassword";
	}

	@PostMapping("/Edit-Password")
	public String changePassword(@Valid User user, Model model){
		Optional<User> temp = userRepository.findByEmail(user.getEmail());
//		User temp = userRepository.findByEmail2(user.getEmail());
		User temp2 = temp.get();
		temp2.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//		temp.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		userRepository.save(temp2);

		return "redirect:/Home";

	}


	@RequestMapping(value = "/Dashboard", method = RequestMethod.GET)
	public ModelAndView EmployeeDashboard() {

		return new ModelAndView("redirect:http://localhost:8081/Dashboard/");
	}

	@RequestMapping(value = "/Dashboard-Admin", method = RequestMethod.GET)
	public ModelAndView AdminDashboard() {
		return new ModelAndView("redirect:http://localhost:8082");
	}









}
