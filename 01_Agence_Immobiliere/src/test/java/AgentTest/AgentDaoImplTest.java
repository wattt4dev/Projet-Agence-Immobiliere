package AgentTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.entity.Agent;
import fr.adaming.service.IAgentService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/applicationContext.xml"})

public class AgentDaoImplTest {

	@Autowired
	IAgentService aService;
	
	@Test
	public void testIsExist1() {
		Agent a = new Agent("toto", "465789", "a");
		Agent a1= new Agent("2", "2", "2");

		int idExpected= 1;
		int idObtenu = aService.isExist(a).getIdAgent();
		
		assertEquals(idExpected, idObtenu);

	}
	
	@Test
	public void testIsExist2() {
		Agent a = new Agent("toto", "456789", "a");
		String mdpExpected= "a";
		String mdpObtenu = aService.isExist(a).getMdpAgent();
		
		assertEquals(mdpExpected,mdpObtenu);

	}

}
