package ca.uhn.fhir.jaxrs.server.interceptor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ejb.ApplicationException;

import org.junit.Test;

import ca.uhn.fhir.rest.server.exceptions.ForbiddenOperationException;

public class JaxRsResponseExceptionTest {

	@Test
	public void testException() {
		ForbiddenOperationException wrappedException = new ForbiddenOperationException("someMessage");
		JaxRsResponseException response = new JaxRsResponseException(wrappedException);
		assertEquals(response.getMessage(), wrappedException.getMessage());
		assertEquals(response.getStatusCode(), wrappedException.getStatusCode());
		assertNotNull(response.getClass().getAnnotation(ApplicationException.class));
	}

}
