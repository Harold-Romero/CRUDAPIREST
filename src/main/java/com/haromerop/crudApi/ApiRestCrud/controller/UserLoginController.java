package com.haromerop.crudApi.ApiRestCrud.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haromerop.crudApi.ApiRestCrud.dto.UserLoginRequest;
import com.haromerop.crudApi.ApiRestCrud.model.UserLogin;
import com.haromerop.crudApi.ApiRestCrud.service.UserLoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "{userlogin.controller.api}", tags = "{userlogin.controller.api}")
@RestController
@RequestMapping("/create_auth")
public class UserLoginController {
	
	private UserLoginService userLoginService;
	
	public UserLoginController(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}
	
	@ApiOperation(value = "{userlogin.controller.apioperation.create}", response = ResponseEntity.class, tags = "{userlogin.controller.apioperation.tags.create}")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "{user.controller.response.200}"),
			@ApiResponse(code = 401, message = "{user.controller.response.401}"),
			@ApiResponse(code = 403, message = "{user.controller.response.403}"),
			@ApiResponse(code = 404, message = "{user.controller.response.404}")
	})
	@PostMapping
	public ResponseEntity<UserLogin> createUserLogin(@Valid @RequestBody UserLoginRequest user) throws Exception{
		return ResponseEntity.ok().body(this.userLoginService.createUserLogin(user));
	}
}