package com.jsp.pharma.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jsp.pharma.entity.Admin;
import com.jsp.pharma.exception.AdminNotFoundByIdException;
import com.jsp.pharma.exception.AdminNotFoundException;
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
	
	public AdminResponse findAdminById(String adminId) {
		return adminRepository.findById(adminId)
							.map(adminMapper::mapToAdminResponse)
							.orElseThrow(()->new AdminNotFoundByIdException("Admin Not Found"));
	}
	
	public AdminResponse updateAdminById(AdminRequest adminRequest, String adminId) {
		return adminRepository.findById(adminId)
							.map(exAdmin->{
								adminMapper.mapToAdmin(adminRequest, exAdmin);
								return adminRepository.save(exAdmin);
							})
							.map(adminMapper::mapToAdminResponse)
							.orElseThrow(()->new AdminNotFoundByIdException("Admin not Found To Update"));
	}
	
	public List<AdminResponse> findAll(){
		List<Admin> admins = adminRepository.findAll();
		if(admins.isEmpty()) {
			throw new AdminNotFoundException("Admins Not Found");
		}
		return admins.stream()
					.map(adminMapper::mapToAdminResponse)
					.toList();
	}
	
}
