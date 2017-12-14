package com.web.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.web.dao.EmployeeDao;
import com.web.model.Employee;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	@Mock
	EmployeeDao mockEmployeeDao;

	@InjectMocks
	private EmployeeServiceImpl service;

	@Test
	public void isEmployeeSsnUniqueTrueTest() {
		Employee test = new Employee();
		test.setId(1);
		when(mockEmployeeDao.findEmployeeBySsn("test")).thenReturn(test);

		boolean result = service.isEmployeeSsnUnique(1, "test");
		assertTrue(result);
	}
	
	@Test
	public void isEmployeeSsnUniqueFalseTest() {
		Employee test = new Employee();
		test.setId(2);
		when(mockEmployeeDao.findEmployeeBySsn("test")).thenReturn(test);

		boolean result = service.isEmployeeSsnUnique(1, "test");
		assertTrue(!result);
	}

}
