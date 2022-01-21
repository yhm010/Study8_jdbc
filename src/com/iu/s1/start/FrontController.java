package com.iu.s1.start;

import java.util.Scanner;

import javax.swing.text.StyleConstants.FontConstants;

import com.iu.s1.deprtment.DepartmentView;
import com.iu.s1.deprtment.DeprtmentController;

public class FrontController {

	private Scanner sc;
	private DeprtmentController deprtmentController;
	//로케이션 컨트롤러
	//인플로이 컨트롤러 똑같이 선언하면 됨.
	
	public FrontController() {
		sc = new Scanner(System.in);
		deprtmentController = new DeprtmentController();
	}
	
	public void mainStart() throws Exception {
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 직원 관리");
			System.out.println("2. 부서 관리");
			System.out.println("3. 지역 관리");
			System.out.println("4. 프로그램 종료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				// 인플로이의 스타트 메서드 호출
				break;
			case 2:
				deprtmentController.start(); // 예외처리 했음
				break;
			case 3:
				// 로케이션의 스타트 메서드 호출
				break;
				default :
					flag = false;
			}
		}
	}
	
}
