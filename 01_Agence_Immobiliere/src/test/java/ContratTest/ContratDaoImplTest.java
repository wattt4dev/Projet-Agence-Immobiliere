package ContratTest;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.dao.IContratDao;
import fr.adaming.entity.Contrat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class ContratDaoImplTest {
	
	@Autowired
	IContratDao contratDao;
	
	@Test
	public void addContratTestId() {
		Contrat c = new Contrat(700, "septembre");
		contratDao.addContrat(c);
		int sizeExpected = 14;
		int sizeObtenu = contratDao.getAllContrat().size();
		assertEquals(sizeExpected, sizeObtenu);
	}
	
	
	

}
