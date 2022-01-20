package com.iu.s1.deprtment;

import java.util.List;
import java.util.Scanner;

public class DeprtmentController {

	private DeprtmentDAO deprtmentDAO; // 선언만 함
	private DepartmentView departmentView; // 선언만 함
	private Scanner sc;

	public DeprtmentController() { // 생성자
		deprtmentDAO = new DeprtmentDAO();
		departmentView = new DepartmentView();// 객체생성
		sc = new Scanner(System.in);
	}

	public void start() throws Exception {
		boolean flag = true;

		while (flag) {
			System.out.println("1. 부서 리스트 출력");
			System.out.println("2. 부서 번호 검색");
			System.out.println("3. 종료");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				List<DeprtmentDTO> ar = deprtmentDAO.getList();
				departmentView.view(ar);
				break;
			case 2:
				System.out.println("검색할 부서 번호를 입력");
				DeprtmentDTO deprtmentDTO = new DeprtmentDTO();
				deprtmentDTO.setDepartment_id(sc.nextInt());
				deprtmentDTO = deprtmentDAO.getOne(deprtmentDTO);

				break;

			default:
				flag = false;
			}

		}

	}

}
