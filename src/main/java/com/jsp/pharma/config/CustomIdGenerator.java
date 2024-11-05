package com.jsp.pharma.config;

import java.time.Year;
import java.util.UUID;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

@SuppressWarnings("serial")
public class CustomIdGenerator implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor arg0, Object arg1) {
		String uuid = UUID.randomUUID().toString();
		return Year.now().toString()+uuid;
		
	}

}
