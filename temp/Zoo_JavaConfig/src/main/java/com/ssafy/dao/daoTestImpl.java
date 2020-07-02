package com.ssafy.dao;

import org.springframework.stereotype.Repository;

@Repository
public class daoTestImpl implements daoTest {
	@Override
	public void print() {
		System.out.println("check");
	}
}
