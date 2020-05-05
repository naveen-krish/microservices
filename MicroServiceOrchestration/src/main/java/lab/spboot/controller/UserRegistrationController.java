/**
 * 
 */
package lab.spboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import lab.spboot.model.Card;
import lab.spboot.model.User;
import lab.spboot.service.IUserRegistration;

/**
 * @author Navin
 *
 */
@Controller
@SessionAttributes({"cardInfo","user"})
public class UserRegistrationController {

	@Autowired
	private IUserRegistration userRegistration;
	
	@RequestMapping("/user")
	public String getUserInfoForm(Model model) {
		
		System.out.println(" << UserInfo from Form >> ");
		model.addAttribute("user", new User());
		
		return "inputUser";
	}
	
	@RequestMapping("/userInfo")
	public String getUserInfo(Model model,@RequestParam(name ="id") String userId) {
		
		String viewName = "";
		User user = new User();
		user.setId(userId);
		user.setJob(userRegistration.getUserDepartment(userId));
		user.setName(userRegistration.getUserName(userId));
		user.setPremiumSubscription(userRegistration.isPremiumUser(userId));
		
		model.addAttribute("user", user);
		
		
	 if( user.isPremiumSubscription()) {
			viewName = "cardInfo";
		    model.addAttribute("card", new Card());
	 }else {
		  viewName = "displayUser";
	 }
		
		return viewName;
	}
	
	@RequestMapping("/cardInfo")
	public String getCardInfo(@ModelAttribute("card") Card card,Model model) {
		
		model.addAttribute("card", card);
		return "displayUser";
	}
}
