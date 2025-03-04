package com.exam.common.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.exam.common.exception.CustomException;

@Component
public class Mapper {

	@Autowired
	private ModelMapper modelMapper;

	public <T> T convert(Object srcObject, Class<T> targetClass) {
		T response = null;

		try {
			response = modelMapper.map(srcObject, targetClass);
		} catch (Exception ex) {
			throw new CustomException("Entity Not Convert properly.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	public <S, T> List<T> convertToList(List<S> srcObjects, Class<T> targetClass) {
		List<T> response = null;

		try {
			response = srcObjects.stream().map(i -> modelMapper.map(i, targetClass)).collect(Collectors.toList());
		} catch (Exception e) {
			throw new CustomException("Entity Not Convert properly.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

}
