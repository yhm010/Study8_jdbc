package com.iu.location;

import java.util.List;
import java.util.Scanner;

import com.iu.s1.deprtment.DeprtmentDTO;

public class LocationController {
	
	private LocationDAO locationDAO;
	private LocationView locationView;
	private Scanner sc;
	
	public LocationController() {
		locationDAO = new LocationDAO();
		locationView = new LocationView();
		sc = new Scanner(System.in);
		
	}
	
	public void start()throws Exception {
		boolean flag=true;
		while(flag) {
			System.out.println("1. 직원 리스트 출력");
			System.out.println("2. 부서 번호 검색");
			System.out.println("3. 종료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1 :
				List<LocationDTO> ar= locationDAO.getList();
				locationView.view(ar);
				break;
			case 2 :
				System.out.println("검색할 직원 번호를 입력");
				LocationDTO locationDTO = new LocationDTO();
				locationDTO.setLocation_id(sc.nextInt());
				locationDTO = locationDAO.getList();
				locationView.view(ar);
				break;
				default:
				flag=false;
				
			}
		}
		
	}

}
