package com.lg.exception;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class DatabaseConnectionRefuseExceptionTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	void test() {
		thrown.expect(DatabaseConnectionRefuseException.class);
		thrown.expectMessage("Connection Refused");
		DatabaseConnectionRefuseException obj = new DatabaseConnectionRefuseException("Connection Refused");
		assertNotNull(obj);
	}

}
