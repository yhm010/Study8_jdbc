package com.iu.s1.deprtment;

import java.util.List;

public class DepartmentView {
	
	public void view(DeprtmentDTO deprtmentDTO) {
			System.out.print(deprtmentDTO.getDepartment_id() + "\t");
			System.out.print(deprtmentDTO.getDepartment_name() + "\t");
			System.out.print(deprtmentDTO.getManager_id() + "\t");
			System.out.println(deprtmentDTO.getLocation_id());
			System.out.println("---------------------------------------");
		}
	

	public void view(List<DeprtmentDTO> ar) {
		// 모두 출력
		for (int i = 0; i < ar.size(); i++) {
			this.view(ar.get(i));
		}
	}

}
