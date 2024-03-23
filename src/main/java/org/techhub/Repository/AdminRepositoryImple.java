package org.techhub.Repository;

import java.sql.SQLException;

import org.techhub.Module.AdminModule;

public class AdminRepositoryImple extends DBconfig implements AdminRepository{
	public AdminModule isValidate(AdminModule am) {
		try {
			stmt=conn.prepareStatement("select * from adminprofile where email=? and password=?");
			stmt.setString(1,am.getEmail());
			stmt.setString(2,am.getPassword());
			rs=stmt.executeQuery();
			if(rs.next())
			{
				am.setId(rs.getInt(1));
				am.setName(rs.getString(2));
				am.setEmail(rs.getString(3));
				am.setContact(rs.getString(4));
				am.setPassword(rs.getString(5));
				return am;
			}
			else
			{
				return null;
			}
		}
		catch(SQLException ex)
		{
			System.out.println("error is "+ex);
			return null;
		}
		
	}

	@Override
	public boolean update(AdminModule am)
	{
		try {
			
			stmt=conn.prepareStatement("update adminprofile set name=?,email=?,contact=?,password=? where aid=?");
			stmt.setString(1,am.getName());			
			stmt.setString(2,am.getEmail());
			stmt.setString(3,am.getContact());
    		stmt.setString(4,am.getPassword());
			stmt.setInt(5, am.getId());
			int val=stmt.executeUpdate();
			if(val>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(SQLException ex)
		{
			System.out.println("error is "+ex);
			return false;
		}	
    }
}