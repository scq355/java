package com.coding.java.lambda.part01;

import com.coding.java.model.Employee;

public class FilterEmployeeForAge implements MyPredicate<Employee>{

	@Override
	public boolean test(Employee t) {
		return t.getAge() <= 35;
	}

}
