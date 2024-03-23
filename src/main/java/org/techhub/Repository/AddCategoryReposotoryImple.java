package org.techhub.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.techhub.Module.CategoryModule;

public class AddCategoryReposotoryImple extends DBconfig implements  AddCategoryRepository{
    List<CategoryModule> list=new ArrayList<CategoryModule>();
	@Override
	public boolean isAddNewCategory(CategoryModule cm) 
	{
		try
		{
			stmt=conn.prepareStatement("insert into category values('0',?,?)");
//			stmt.setInt(1,cm.getId());
			stmt.setString(1,cm.getName());
			stmt.setInt(2,1);
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

	@Override
	public List<CategoryModule> getAllCategories() {
		try
		{
			stmt=conn.prepareStatement("select * from category where status=1");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				CategoryModule cm=new CategoryModule();
				cm.setId(rs.getInt(1));
				cm.setName(rs.getString(2));
				list.add(cm);
			}
			return list;
		}
		catch(Exception ex)
		{
			System.out.println("error is "+ex);
			return null;
		}
	}

	@Override
	public boolean isDisable(int id) {
		try {
			
			stmt=conn.prepareStatement("update category set status=0 where cid=?");
			stmt.setInt(1,id);
			int value=stmt.executeUpdate();
			if(value>0)
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

	@Override
	public List<CategoryModule> getAllDisableCategory() {
		try
		{
			stmt=conn.prepareStatement("select * from category where status=0");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				CategoryModule cm=new CategoryModule();
				cm.setId(rs.getInt(1));
				cm.setName(rs.getString(2));
				list.add(cm);
			}
			return list;
		}
		catch(Exception ex)
		{
			System.out.println("error is "+ex);
			return null;
		}
	}

	@Override
	public boolean isEnable(int id) {
     try   
        {
			
			stmt=conn.prepareStatement("update category set status=1 where cid=?");
			stmt.setInt(1,id);
			int value=stmt.executeUpdate();
			if(value>0)
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

	@Override
	public boolean isUpdate(CategoryModule cm) {
		try
		{
			stmt=conn.prepareStatement("update category set cname=? where cid=?");
			stmt.setString(1,cm.getName());
			stmt.setInt(2,cm.getId());
			int value=stmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			System.out.println("error is "+ex);
			return false;
		}	
	}

	@Override
	public List<CategoryModule> getAllCategoriesByName(String name) {
		try
		{
			stmt=conn.prepareStatement("select * from category where status=1 and cname like '%"+name+"%'");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				CategoryModule cm=new CategoryModule();
				cm.setId(rs.getInt(1));
				cm.setName(rs.getString(2));
				list.add(cm);
			}
			return list;
		}
		catch(Exception ex)
		{
			System.out.println("error is "+ex);
			return null;
		}
	}
}
