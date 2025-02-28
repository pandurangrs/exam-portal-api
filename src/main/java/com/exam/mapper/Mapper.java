package com.exam.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.exam.exception.ResourceNotFoundException;

public class Mapper {

	@Autowired
	private ModelMapper modelMapper;

	public <T> T convertToEntity(Object srcObj, Class<T> targetClass) {
		T response = null;

		try {
			response = modelMapper.map(srcObj, targetClass);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Error arrving to convert dto", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	public <S, T> List<T> convertToList(List<S> srcObj, Class<T> targetClass) {
		List<T> response = null;

		try {
			response = srcObj.stream().map(i -> modelMapper.map(i, targetClass)).collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResourceNotFoundException("Error arrving convert to List", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}
}
