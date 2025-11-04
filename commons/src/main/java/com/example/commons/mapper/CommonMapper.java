package com.example.commons.mapper;

public interface CommonMapper<RQ, RS, E> {

	RS entityToResponse(E entity);
	
	E requestToEntity(RQ request);
}
