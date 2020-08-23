package com.example.demo;

import java.util.ArrayList;
import java.util.List;

interface Testdefault{
	void xyz();
	default void printInLoop(List<String> listData) {
		for (String s:listData) {
			System.out.println(s);
		}
	}
}

public class DefaltMethod implements Testdefault {
	public static void main(String[] args) {
		Testdefault test= new DefaltMethod();
		List listdata= new ArrayList<>();
		listdata.add("a");
		test.printInLoop(listdata);
	}
	@Override
	public void xyz() {
		System.out.println("xyz");	
	}
}
