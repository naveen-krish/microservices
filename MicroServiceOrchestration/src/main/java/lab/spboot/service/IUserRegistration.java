package lab.spboot.service;

import lab.spboot.model.User;

public interface IUserRegistration {

	public User getUserInfo(String id);
	public String getUserName(String id);
	public String getUserDepartment(String id);
	public boolean isPremiumUser(String id);
}
