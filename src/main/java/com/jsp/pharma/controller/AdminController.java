package com.jsp.pharma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.pharma.exception.AdminNotFoundByIdException;
import com.jsp.pharma.requestdtos.AdminRequest;
import com.jsp.pharma.responsedtos.AdminResponse;
import com.jsp.pharma.service.AdminService;
import com.jsp.pharma.util.AppResponseBuilder;
import com.jsp.pharma.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
public class AdminController {

	private final AdminService adminService;
	private final AppResponseBuilder responseBuilder;

	public AdminController(AdminService adminService,AppResponseBuilder responseBuilder) {
		super();
		this.adminService = adminService;
		this.responseBuilder = responseBuilder;
	}

	@Operation(description = "This Endpoint can be used to Save Admin With Required Information",
			responses = {
					@ApiResponse(responseCode = "202",description = "Admin Saved",
							content = {
									@Content(schema = @Schema(implementation = AdminResponse.class))
					})
	})
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<AdminResponse>> addAdmin(@RequestBody @Valid AdminRequest adminRequest){
		AdminResponse adminResponse = adminService.addAdmin(adminRequest);
		return responseBuilder.success(HttpStatus.ACCEPTED,"Admin Saved", adminResponse);

	}
	
	@Operation(description = "This Endpoint can be used to Find Admin With Requested Id",
			responses = {
					@ApiResponse(responseCode = "202",description = "Admin Found",
							content = {
									@Content(schema = @Schema(implementation = AdminResponse.class))
					}),
					@ApiResponse(responseCode = "404",description = "Admin Not Found",
					content = {
							@Content(schema = @Schema(implementation = AdminNotFoundByIdException.class))
			})
	})
	@GetMapping("admin/{adminId}")
	public ResponseEntity<ResponseStructure<AdminResponse>> findAdminById(@PathVariable String adminId) {
		AdminResponse response = adminService.findAdminById(adminId);
		return responseBuilder.success(HttpStatus.FOUND, "Admin Found", response);
	}
}
