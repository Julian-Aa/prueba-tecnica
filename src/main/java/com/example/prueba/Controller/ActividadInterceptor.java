package com.example.prueba.Controller;

import com.example.prueba.model.ActividadRegistro;
import com.example.prueba.respository.ActividadRegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import java.time.LocalDateTime;

/**
 * Interceptor que registra la actividad del usuario en la aplicación.
 */
@Component
public class ActividadInterceptor implements HandlerInterceptor {

    @Autowired
    private ActividadRegistroRepository actividadRegistroRepository;

    /**
     * Método ejecutado antes de manejar la solicitud HTTP.
     *
     * @param request  El objeto HttpServletRequest que representa la solicitud HTTP.
     * @param response El objeto HttpServletResponse que representa la respuesta HTTP.
     * @param handler  El objeto Handler (manejador) que maneja la solicitud.
     * @return true si la solicitud debe continuar hacia el controlador; de lo contrario, false.
     * @throws Exception Si ocurre una excepción durante la ejecución del método.
     */
    @Override
    public boolean preHandle(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        String tipoAccion = "Acción realizada";
        String usuario = "Usuario actual";

        // Crear un objeto ActividadRegistro y establecer sus propiedades
        ActividadRegistro actividad = new ActividadRegistro();
        actividad.setTipoAccion(tipoAccion);
        actividad.setFechaHora(LocalDateTime.now());
        actividad.setUsuario(usuario);

        // Guardar el objeto ActividadRegistro en la base de datos
        actividadRegistroRepository.save(actividad);


        // Devolver true para permitir que la solicitud continúe hacia el controlador
        return true;
    }
}
