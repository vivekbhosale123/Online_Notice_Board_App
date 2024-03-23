package org.techhuub.Service;
import org.techhub.Repository.*;
import org.techhub.Module.AdminModule;
public class AdminServiceImple implements AdminService {
	AdminRepository aRepo=new  AdminRepositoryImple();
	public AdminModule isValidate(AdminModule am) {
		return aRepo.isValidate(am);
	}
	
	public boolean update(AdminModule am) {
		return aRepo.update(am);
	}	
}
