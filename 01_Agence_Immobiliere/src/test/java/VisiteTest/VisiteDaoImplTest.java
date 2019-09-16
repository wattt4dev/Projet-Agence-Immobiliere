package VisiteTest;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.entity.Visite;
import fr.adaming.service.IVisiteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/applicationContext.xml"})

public class VisiteDaoImplTest {
	
	@Autowired
	IVisiteService vService;
	
//	@Test
//	public void testGetAllVisite() {
//		int sizeExpected=1;
//		int sizeObtenue = vService.getAllVisite().size();
//		
//		assertEquals(sizeExpected, sizeObtenue);
//	}
//	
//	@Test
//	public void testAddVisite() throws ParseException {
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		Visite v= new Visite(simpleDateFormat.parse("25/12/2010"));
//		
//		 vService.addVisite(v);
//		
//			int sizeExpected=2;
//			int sizeObtenue = vService.getAllVisite().size();
//		assertEquals(sizeExpected, sizeObtenue);
//	}
	
	@Test
	public void testDeleteVisite() throws ParseException {
		
		
		int idVisite = 1;
		
		 vService.deleteVisite(idVisite);
		
			int sizeExpected=1;
			int sizeObtenue = vService.getAllVisite().size();
		assertEquals(sizeExpected, sizeObtenue);
	}
	
	
	

}
