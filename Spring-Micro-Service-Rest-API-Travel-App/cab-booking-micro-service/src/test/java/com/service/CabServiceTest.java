package com.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Cab;
import com.repository.CabRepository;

class CabServiceTest {
	
	@Autowired
	CabService cabService;
	
	@Autowired
	CabRepository cabRepository;
	
	
	@Test
	void testStoreCab() {
	Cab	 cab = new Cab();
	        cab.setCid(1);
	        cab.setCompany(" mahindra");
	        cab.setFare(2000);
	        cab.setSeatcapacity(6);
	        cab.setTypeofcab("xuv");
	        when(cabRepository.save(cab)).thenReturn(cab);

	        // Call the store method
	        String result = cabService.storeCab(cab);

	        // Validate the result
	        assertNotNull(result);
	        assertEquals(1, result.getClass());
	       
	}

	@Test
	@Disabled
	void testUpdateCab() {
		fail("Not yet implemented");
	}

	@Test
	void testDeletecab() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAllCabs() {
		fail("Not yet implemented");
	}

	@Test
	void testFindCabById() {
		fail("Not yet implemented");
	}

	@Test
	void testFindFareByCabId() {
		fail("Not yet implemented");
	}

}
