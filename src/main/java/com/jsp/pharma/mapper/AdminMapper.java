package com.jsp.pharma.mapper;

import org.springframework.stereotype.Component;

import com.jsp.pharma.entity.Admin;
import com.jsp.pharma.requestdtos.AdminRequest;
import com.jsp.pharma.responsedtos.AdminResponse;

@Component
public class AdminMapper {
	
	public Admin mapToAdmin(AdminRequest adminRequest,Admin admin) {
		admin.setEmail(adminRequest.getEmail());
		admin.setPhoneNumber(adminRequest.getPhoneNumber());
		admin.setPassword(adminRequest.getPassword());
		
		return admin;
	}
	
	public AdminResponse mapToAdminResponse(Admin admin) {
		AdminResponse response = new AdminResponse();
		response.setAdminId(admin.getAdminId());
		response.setEmail(admin.getEmail());
		response.setPhoneNumber(admin.getPhoneNumber());
		
		return response;
	}

}
