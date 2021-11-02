package com.haromerop.crudApi.ApiRestCrud.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class UsuarioRequest {

    @ApiModelProperty(notes = "{user.entity.firstname.apimodelproperty}", name="nombre", required=true, value="{user.entity.firstname.apimodelproperty}")
    @NotEmpty(message = "{user.entity.firstname.empty}")
    @Length(min = 3, max = 15, message = "{user.entity.firstname.length}")
    @Pattern(regexp = "[A-Za-z\\s]+", message = "{user.entity.firstname.pattern}")
    private String nombresUsuario;

    @ApiModelProperty(notes = "{user.entity.lastname.apimodelproperty}",name="apellidos",required=true,value="{user.entity.lastname.apimodelproperty}")
    @NotEmpty(message = "{user.entity.lastname.empty}")
    @Length(min = 3, max = 25, message = "{user.entity.lastname.length}")
    @Pattern(regexp = "[A-Za-z\\s]+", message = "{user.entity.lastname.pattern}")
    private String apellidosUsuario;

    @ApiModelProperty(notes = "{user.entity.telephone.apimodelproperty}",name="telefono",required=true,value="{user.entity.telephone.apimodelproperty}")
    @NotEmpty(message = "{user.entity.telephone.empty}")
    @Length(min = 7, max = 15, message = "{user.entity.telephone.length}")
    @Pattern(regexp = "[0-9]+", message = "{user.entity.telephone.pattern}")
    private String telefono;

    @ApiModelProperty(notes = "{user.entity.address.apimodelproperty}",name="direccion",required=true,value="{user.entity.address.apimodelproperty}")
    @NotEmpty(message = "{user.entity.address.empty}")
    @Length(min = 9, max = 30, message = "{user.entity.address.length}")
    private String direccion;
}
