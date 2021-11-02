package com.haromerop.crudApi.ApiRestCrud.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserLoginRequest {
	
	@ApiModelProperty(notes = "{userlogin.entity.username.apimodelproperty}", name="nombre", required=true, value="{userlogin.entity.firstname.apimodelproperty}")
    @NotEmpty(message = "{userlogin.entity.username.empty}")
    @Length(min = 3, max = 15, message = "{userlogin.entity.username.length}")
    @Pattern(regexp = "[A-Za-z]+", message = "{userlogin.entity.username.pattern}")
	private String user;
	
	@ApiModelProperty(notes = "{userlogin.entity.pass.apimodelproperty}", name="nombre", required=true, value="{userlogin.entity.pass.apimodelproperty}")
	@NotEmpty(message = "{userlogin.entity.pass.empty}")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])([A-Za-z\\d$@$!%*?&]|[^ ]){8,15}$", message = "{userlogin.entity.pass.pattern}")
	private String pass;
	
	@ApiModelProperty(notes = "{userlogin.entity.rol.apimodelproperty}", name="nombre", required=true, value="{userlogin.entity.rol.apimodelproperty}")
	private byte rol;
}
