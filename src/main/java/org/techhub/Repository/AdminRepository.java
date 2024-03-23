package org.techhub.Repository;
import org.techhub.Module.AdminModule;
public interface AdminRepository {
	public AdminModule isValidate(AdminModule am);
	public boolean update(AdminModule am);
}
