package com.iu.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iu.s1.utll.DBConnector;

public class LocationDAO {
// DB 접근
	private DBConnector dbConnector;
	
	public LocationDAO() {
		dbConnector = new DBConnector();
	}

	public List<LocationDTO> geList() throws Exception {
		ArrayList<LocationDTO> ar = new ArrayList();
		// SELECT * FROM LOCATIONS;
		// 1. DB에 로그인
		Connection con = dbConnector.getConnect();
		// 2. Sql Query문 작성
		String spl = "SELECT * FROM LOCATIONS";
		// 3. 미리 전송
		PreparedStatement st = con.prepareStatement(spl);
		// 4. ? 세팅 통과

		// 5. 최종 전송후 결과 처리
		ResultSet rs = st.executeQuery();
		// cursor가 한 줄 읽는 메서드 next() 리턴은 데이터가 있으면 true, 없으면 false
		while (rs.next()) {
			LocationDTO locationDTO = new LocationDTO();

			locationDTO.setLocation_id(rs.getInt("location_id"));
			locationDTO.setStreet_address(rs.getNString("street_address"));
			locationDTO.setPostal_code(rs.getNString("postal_code"));
			locationDTO.setCity(rs.getString("city"));
			locationDTO.setState_province(rs.getString("state_province"));
			locationDTO.setCountry_id(rs.getString("country_id"));
			
			//arryList
			ar.add(locationDTO);
			
		}
		//6. 자원 해제
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
}