package net.login.springbootsecurity.Models;

import net.login.springbootsecurity.entities.Role;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;



public class UserModel
{
	private Integer id;

	private String name;

	private String email;

	private String password;


	private List<Role> roles;

	private Role roleByid;



	public UserModel(){};

	public UserModel(String name, String email, String password, List<Role> roles){
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public List<Role> getRoles()
	{
		return roles;
	}
	public void setRoles(List<Role> roles)
	{
		this.roles = roles;
	}

	public Role getRoleByid() {
		return roleByid;
	}

	public void setRoleByid(Role roleByid) {
		this.roleByid = roleByid;
	}




}
