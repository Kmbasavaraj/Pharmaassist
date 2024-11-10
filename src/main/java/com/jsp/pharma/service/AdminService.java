package com.jsp.pharma.service;

import org.springframework.stereotype.Service;

import com.jsp.pharma.entity.Admin;
import com.jsp.pharma.mapper.AdminMapper;
import com.jsp.pharma.repository.AdminRepository;
import com.jsp.pharma.requestdtos.AdminRequest;
import com.jsp.pharma.responsedtos.AdminResponse;

@Service
public class AdminService {
	private final AdminRepository adminRepository;
	private final AdminMapper adminMapper;

	public AdminService(AdminRepository adminRepository,AdminMapper adminMapper) {
		super();
		this.adminRepository = adminRepository;
		this.adminMapper = adminMapper;
	}
	
	public AdminResponse addAdmin(AdminRequest adminRequest) {
		Admin admin = adminRepository.save(adminMapper.mapToAdmin(adminRequest, new Admin()));
		return adminMapper.mapToAdminResponse(admin);
	}
	
}
