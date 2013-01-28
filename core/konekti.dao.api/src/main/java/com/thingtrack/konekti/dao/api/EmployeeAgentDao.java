package com.thingtrack.konekti.dao.api;

import java.util.List;

import com.thingtrack.konekti.dao.template.Dao;
import com.thingtrack.konekti.domain.EmployeeAgent;
import com.thingtrack.konekti.domain.EmployeeAgentType;
import com.thingtrack.konekti.domain.Organization;
import com.thingtrack.konekti.domain.User;

/**
 * @author Thingtrack S.L.
 *
 */
public interface EmployeeAgentDao extends Dao<EmployeeAgent, Integer> {
	
	public EmployeeAgent getByName(Organization organization, String name) throws Exception;
	public EmployeeAgent getByUser(User user) throws Exception;
	public List<EmployeeAgent> getByType(Organization organization, EmployeeAgentType employeeAgentType) throws Exception;
	 
}