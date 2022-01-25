package com.iu.s1.department;

import java.util.Scanner;

public class Department_Input {
	
	private Scanner sc;
	
	private Department_Input() {
		sc = new Scanner(System.in);
	}
	
	//setinsert
	public DepartmentDTO setInsert() {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		System.out.println("DEPARTMENT_ID를 입력");
		departmentDTO.setDepartment_id(sc.nextInt());
		System.out.println("DEPARTMENT_NAME을 입력");
		departmentDTO.setDepartment_name(sc.next());
		System.out.println("MANAGER_ID를 입력");
		departmentDTO.setManager_id(sc.nextInt());
		System.out.println("LOCATION_ID를 입력");
		departmentDTO.setLocation_id(sc.nextInt());
		
		return departmentDTO;
	}
	
	//setDelete
	public DepartmentDTO setDelete() {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		System.out.println("삭제할 DEPARTMENT_ID를 입력");
		departmentDTO.setDepartment_id(sc.nextInt());

		return departmentDTO;
		
	}
	
	

}
