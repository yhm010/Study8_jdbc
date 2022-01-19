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
