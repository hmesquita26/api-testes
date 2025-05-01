package com.testesapi.api_testes.controllers.exceptions;

import com.testesapi.api_testes.services.exceptions.DataIntegrityViolationException;
import com.testesapi.api_testes.services.exceptions.ObjectNotFoundException;
import com.testesapi.api_testes.services.exceptions.ObjectOptimisticLockingFailureException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ControllerExceptionHandlerTest {

    public static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";
    public static final String E_MAIL_JA_CADASTRADO_NO_SISTEMA = "E-mail já cadastrado no sistema";
    public static final String RECURSO_NAO_DISPONIVEL = "O recurso que você está tentando modificar não existe ou foi alterado por outro usuário. Atualize os dados e tente novamente.";

    @InjectMocks
    private ControllerExceptionHandler exceptionHandler;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void whenObjectNotFoundThenReturnAResponseEntity() {
        ResponseEntity<StandardError> response = exceptionHandler.objectNotFound(
                        new ObjectNotFoundException(OBJETO_NAO_ENCONTRADO), new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals(OBJETO_NAO_ENCONTRADO, response.getBody().getError());
        assertEquals(404, response.getBody().getStatus());
        assertNotEquals("/user/2", response.getBody().getPath());
        assertNotEquals(LocalDateTime.now(), response.getBody().getTimestamp());
    }

    @Test
    void whenDataIntegrityViolationThenReturnAResponseEntity() {
        ResponseEntity<StandardError> response = exceptionHandler.dataIntegrityViolation(
                new DataIntegrityViolationException(E_MAIL_JA_CADASTRADO_NO_SISTEMA), new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals(E_MAIL_JA_CADASTRADO_NO_SISTEMA, response.getBody().getError());
        assertEquals(400, response.getBody().getStatus());
    }

    @Test
     void whenObjectOptimisticLockingFailureExceptionThenReturnAResponseEntity() {
        ObjectOptimisticLockingFailureException ex = new ObjectOptimisticLockingFailureException(RECURSO_NAO_DISPONIVEL);

        ResponseEntity<StandardError> response = exceptionHandler.ObjectOptimisticLockingFailureException(
                ex, new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals(RECURSO_NAO_DISPONIVEL, response.getBody().getError());
        assertEquals(409, response.getBody().getStatus());
    }
}