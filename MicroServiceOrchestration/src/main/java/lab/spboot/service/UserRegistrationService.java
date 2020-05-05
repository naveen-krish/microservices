package lab.spboot.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import lab.spboot.model.User;

@Service
public class UserRegistrationService implements IUserRegistration{

	@Override
	public String getUserName(String id) {
		
		Map<String,String> userNames = new HashMap<String,String>();
		 userNames.put("1","X");
		 userNames.put("2", "Y");
		 
		 return userNames.get(id);
		
	}
	
	@Override
	public String getUserDepartment(String id) {
		
		Map<String,String> dept = new HashMap<String,String>();
		 dept.put("1","Architect");
		 dept.put("2", "Developer");
		 
		 return dept.get(id);
		
	}
	
	@Override
	public boolean isPremiumUser(String id) {
		
		Map<String,Boolean> premiumUser = new HashMap<String,Boolean>();
		premiumUser.put("1",Boolean.valueOf(true));
		premiumUser.put("2", Boolean.valueOf(false));
		
		return premiumUser.get(id).booleanValue();
		
	}
	
	@Override
	public User getUserInfo(String id) {
		
        Map<String,User> users = new HashMap<String,User>();
        
        
        User user = new User();
        user.setId("1");
        user.setJob("Architect");
        user.setName("X");
        user.setPremiumSubscription(true);
        
        User user1 = new User();
        user1.setId("2");
        user1.setJob("Developer");
        user1.setName("Y");
        user1.setPremiumSubscription(false);
         
        users.put(user.getId(), user);
        users.put(user1.getId(), user1);
        
       /*  System.out.println(" << Inside Registration service >> "+users.size()+ " "+user.getId());
        for (Map.Entry<String,User> entry : users.entrySet())  
            System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue()); */
        
        return users.get(id);
        
		  
	}

	 
}
