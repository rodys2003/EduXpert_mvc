package com.rersdev.eduxpert.controllers;

import com.rersdev.eduxpert.config.advice.user.UserNotFoundException;
import com.rersdev.eduxpert.dto.users.teacher.*;
import com.rersdev.eduxpert.services.ITeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@Tag(name = "Profesores", description = "Maneja todos los endpoints de profesores")
@RequiredArgsConstructor

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final ITeacherService teacherService;

    @Operation(
            summary = "Registrar profesor",
            description = "Permite registrar un profesor en el sistema si la informacion enviada " +
                    "cumple con los requerimientos establecidos, devuelve una URI con el id del profesor registrado",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Profesor registrado exitosamente",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Los datos enviados no son validos",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "409",
                            description = "Ocurrio un conflicto al intentar registrar al profesor, ya existe un usuario" +
                                    " con el numero de documento ingresado",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Un error inesperado a ocurrido. Estamos trabajando para resolver el problema.",
                            content = {@Content}

                    )
            }
    )
    @PostMapping
    public ResponseEntity<URI> saveNewTeacher(@RequestBody @Valid TeacherDto teacherDto)
            throws URISyntaxException {
        UUID id = teacherService.save(teacherDto);
        return ResponseEntity.created(new URI("/eduxpert/api/v1/endpoints/teachers/" + id)).build();
    }

    @Operation(summary = "Obtener todos los profesores paginados",
            description = "Obtine todos los profesores ordenados por sus apellidos, permite filtrar profesores por " +
                    "su estado: activo, licencia o retirado y a su vez si su usuario esta activo o inactivo",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Operacion realizada con exito",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = TeacherInfoDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "El estado enviado es invalido",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Un error inesperado a ocurrido. Estamos trabajando para resolver el problema.",
                            content = {@Content}
                    )
            },
            parameters = {
                    @Parameter(name = "status", description = "Estado del profesor: activo, licencia o retirado", example = "activo"),
                    @Parameter(name = "isActive", description = "El profesor tiene un usuario activo en el sistema: true o flase", example = "true"),
                    @Parameter(name = "page", description = "Numero de pagina", example = "0"),
                    @Parameter(name = "size", description = "Numero de elementos por pagina", example = "10"),
                    @Parameter(name = "sort", description = "Tipo de ordenamiento por defecto: ordenar por apellido", example = "person.lastName")
            })
    @GetMapping
    public ResponseEntity<Page<TeacherInfoDto>> getAllTeachers(
            @RequestParam(required = false) String status,
            @RequestParam boolean isActive,
            @PageableDefault(sort = "person.lastName")
            Pageable pageable) {
        return ResponseEntity.ok().body(teacherService.findAll(status, isActive, pageable));
    }

    @Operation(
            summary = "Obtener un profesor por su id",
            description = "Recupera un profesor registrado en el sistema por su identificador unico: id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Operacion realizada con exito",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = TeacherPartialInfoDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No se ha encontrado un profesor con el id ingresado",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Un error inesperado a ocurrido. Estamos trabajando para resolver el problema.",
                            content = {@Content}
                    )
            },
            parameters = {
                    @Parameter(name = "id", description = "Id del profesor a buscar")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<TeacherPartialInfoDto> getTeacherById(@PathVariable UUID id) {
        return teacherService.findById(id).map(ResponseEntity::ok)
                .orElseThrow(() -> new UserNotFoundException("No se ha encontrado el profesor con id: " + id));
    }

    @Operation(
            summary = "Actualizar datos basicos de un profesor",
            description = "Actualiza los datos basicos de un profesor tales como su numero de telefono" +
                    " ,correo electronico y direccion",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Operacion realizada con exito",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = TeacherPartialInfoDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Los datos enviados no son validos",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No se ha encontrado un profesor con el id ingresado",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Un error inesperado a ocurrido. Estamos trabajando para resolver el problema.",
                            content = {@Content}
                    )
            },
            parameters = {
                    @Parameter(name = "id", description = "Id del profesor a actualizar")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<TeacherPartialInfoDto> updateTeacherPartial(
            @PathVariable UUID id,
            @RequestBody @Valid TeacherPartialUpdateDto teacherUpdated) {
        return ResponseEntity.ok().body(teacherService.partialUpdate(id, teacherUpdated));
    }

    @Operation(
            summary = "Actualizar datos de un profesor",
            description = "Actualiza la mayoria de datos que contiene un profesor",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Operacion realizada con exito",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = TeacherInfoDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Los datos enviados no son validos",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No se ha encontrado un profesor con el id ingresado",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Un error inesperado a ocurrido. Estamos trabajando para resolver el problema.",
                            content = {@Content}
                    )
            },
            parameters = {
                    @Parameter(name = "id", description = "Id del profesor a actualizar")
            }
    )
    @PutMapping("/{id}/")
    public ResponseEntity<TeacherInfoDto> updateTeacherInfo(@PathVariable UUID id,
                                                            @RequestBody @Valid TeacherUpdateDto teacherUpdated) {
        return ResponseEntity.ok().body(teacherService.updateByAdmin(id, teacherUpdated
        ));
    }

    @Operation(
            summary = "Actualizar el estado de un profesor",
            description = "Actualiza el estado de un profesor en el sistema",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Operacion realizada con exito",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "El estado enviado es invalido",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No se ha encontrado un profesor con el id ingresado",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Un error inesperado a ocurrido. Estamos trabajando para resolver el problema.",
                            content = {@Content}
                    )
            },
            parameters = {
                    @Parameter(name = "id", description = "Id del profesor que se le actualizara el estado"),
                    @Parameter(name = "status", description = "Estados: activo, licencia o retirado", example = "licencia")
            }
    )
    @PatchMapping("/{id}/status")
    public ResponseEntity<String> updateTeacherStatus(
            @RequestParam String status,
            @PathVariable UUID id) {
        teacherService.updateStatus(status, id);
        return ResponseEntity.ok().body("Status updated successfully");
    }

    @Operation(
            summary = "Eliminar un profesor",
            description = "Elimina a un profesor del sistema",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Profesor eliminado exitosamente",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "No se ha encontrado un profesor con el id ingresado",
                            content = {@Content}
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Un error inesperado a ocurrido. Estamos trabajando para resolver el problema.",
                            content = {@Content}
                    )
            },
            parameters = {
                    @Parameter(name = "id", description = "Id del profesor a eliminar")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacherById(@PathVariable UUID id) {
        teacherService.deleteByAdmin(id);
        return ResponseEntity.noContent().build();
    }
}
