package com.iu.s1.deprtment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iu.s1.utll.DBConnector;

public class DeprtmentDAO {
	//DAO : Date Access Object (DB에 접근하는 역할)
	private DBConnector dbConnector;
	
	public DeprtmentDAO () {
		dbConnector = new DBConnector();
	}
	
	// 부서번호로 조회 DB-> 부서번호로 하나의 데이터를 가져오는 것
	
	public DeprtmentDTO getOne(Integer departments_id) throws Exception {
		DeprtmentDTO deprtmentDTO=null;
		// 1. DB 로그인
		Connection con = dbConnector.getConnect();
		// 2. 쿼리문 작성
		String sql = "SELECT *FROM departments WHERE department_id = " + departments_id ;
		// 3. 쿼리문을 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		// 4. ? 값을 세팅
		// 5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		//1개의 row가 있거나 없거나 둘 중 하나
		if(rs.next()) {
			// 데이터가 있을 때
			deprtmentDTO = new DeprtmentDTO();
			deprtmentDTO.setDepartment_name(rs.getString("department_name"));
			deprtmentDTO.setDepartment_id(rs.getInt("department_id"));
			deprtmentDTO.setManager_id(rs.getInt("manager_id"));
			deprtmentDTO.setLocation_id(rs.getInt("location_id"));
			
		}
		
		// 6. 자원 해제
		rs.close();
		st.close();
		con.close();
		return deprtmentDTO;
	}
	
	
	// 전체 조회
	public List<DeprtmentDTO> getList() throws Exception {
		
		ArrayList<DeprtmentDTO> ar = new ArrayList<>();
		
		// SELECT * FROM DEPARTMENTS;
		// 1. DB 로그인
		Connection con = dbConnector.getConnect();
		// 2. SQL Query 문 작성
		//    java에서는 ; 안씀
		String sql = "SELECT * FROM DEPARTMENTS";
		
		// 3. 작성한 SQL Query 일 부분을 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		// 4. ? 값을 세팅, 없으면 통과
		
		// 5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery(); // 쿼리를 실행하겠다는 뜻
		
		//cursor가 한 줄 읽는 메서드 next() 리턴은 데이터가 있으면 true, 없으면 false
		while(rs.next()) {
			DeprtmentDTO deprtmentDTO = new DeprtmentDTO();
			
			deprtmentDTO.setDepartment_name(rs.getString("department_name"));
			deprtmentDTO.setDepartment_id(rs.getInt("department_id"));
			deprtmentDTO.setManager_id(rs.getInt("manager_id"));
			deprtmentDTO.setLocation_id(rs.getInt("location_id"));
			
			// ArryList
			ar.add(deprtmentDTO);
			
		}
		
		// 6. 외부 연결 해제
		// 연결된 순서의 역순
		rs.close();
		st.close();
		con.close();
		
		return ar;
		
	}
	

}
