package com.iu.s1.start;

import java.util.List;
import com.iu.location.LocationDAO;
import com.iu.location.LocationDTO;
import com.iu.location.LocationView;
import com.iu.s1.deprtment.DepartmentView;
import com.iu.s1.deprtment.DeprtmentController;
import com.iu.s1.deprtment.DeprtmentDAO;
import com.iu.s1.deprtment.DeprtmentDTO;
import com.iu.s1.utll.DBConnector;

public class StartMain {

	public static void main(String[] args) {
		System.out.println("DB 연동 테스트 시작");
		

//		DeprtmentDAO deprtmentDAO = new DeprtmentDAO();
////		DepartmentView dapDepartmentView = new DepartmentView();
//		try {
//			DeprtmentDTO deprtmentDTO = new DeprtmentDTO();
//			deprtmentDTO.setDepartment_id(20);
//			 deprtmentDTO = deprtmentDAO.getOne(deprtmentDTO);
//			System.out.println(deprtmentDTO.getDepartment_name());
////			List<DeprtmentDTO> ar = deprtmentDAO.getList();
////			dapDepartmentView.view(ar);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		LocationDAO locationDAO = new LocationDAO();
//		LocationView locationView = new LocationView();
//		try {
//			List<LocationDTO> ar = locationDAO.getList();
//			locationView.view(ar);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		DeprtmentController deprtmentController = new DeprtmentController();

		try {
			DeprtmentDTO deprtmentDTO = new DeprtmentDTO();
			deprtmentDTO.setDepartment_id(20);
			 deprtmentController.start();
			
			System.out.println(deprtmentDTO.getDepartment_id());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("DB 연동 테스트 끝");

	}

}
