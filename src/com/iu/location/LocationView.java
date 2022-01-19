package com.iu.location;

import java.util.List;

public class LocationView {
	
	public void view(List<LocationDTO> ar) {
		// 모두출력
		for(int i=0; i<ar.size();i++) {
			System.out.print(ar.get(i).getLocation_id() + "\t");
			System.out.print(ar.get(i).getStreet_address() + "\t");
			System.out.print(ar.get(i).getPostal_code() + "\t");
			System.out.print(ar.get(i).getCity() + "\t");
			System.out.print(ar.get(i).getState_province() + "\t");
			System.out.print(ar.get(i).getCountry_id() + "\n");
			System.out.println("----------------------------------------------------------------------------------");
		}
		
	}

	
}
