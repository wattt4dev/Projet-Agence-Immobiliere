package AgentTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.dao.IContratDao;
import fr.adaming.entity.Agent;
import fr.adaming.entity.Contrat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class ContratDaoImplTest {
	
	@Autowired
	IContratDao contratDao;

	@Test
	public void addContratTestId() {
		Agent a = new Agent("Robert", "0606060606", "aaa");
		Contrat c = new Contrat(125, "septembre");
		contratDao.addContrat(c);
		int idContratExpected = 1;
		int idContratObtenu = contratDao.addContrat(c).getIdContrat();
		assertEquals(idContratExpected, idContratObtenu);
	}
	
	@Test
	public void addContratTestPrixContrat() {
		Agent a = new Agent("Robert", "0606060606", "aaa");
		Contrat c = new Contrat(125, "septembre");
		contratDao.addContrat(c);
		double prixContratExpected = 125;
		double prixContratObtenu = contratDao.addContrat(c).getPrixContrat();
		assertEquals(prixContratExpected, prixContratObtenu);
	}
	
	@Test
	public void addContratTestDateTransaction() {
		Agent a = new Agent("Robert", "0606060606", "aaa");
		Contrat c = new Contrat(125, "septembre");
		contratDao.addContrat(c);
		String dateContratExpected = "septembre";
		String dateContratObtenu = contratDao.addContrat(c).getDateTransactionContrat();
		assertEquals(dateContratExpected, dateContratObtenu);
	}
	
	@Test
	public void addContratTestIdAgent() {
		Agent a = new Agent("Robert", "0606060606", "aaa");
		Contrat c = new Contrat(125, "septembre");
		contratDao.addContrat(c);
		int idAgentExpected = 1;
		int idAgentObtenu = contratDao.addContrat(c).getBienImmobilier().getAgent().getIdPersonne();
		assertEquals(idAgentExpected, idAgentObtenu);
	}
	
	@Test
	public void addContratTestNomAgent() {
		Agent a = new Agent("Robert", "0606060606", "aaa");
		Contrat c = new Contrat(125, "septembre");
		contratDao.addContrat(c);
		String nomAgentExpected = "Robert";
		String nomAgentObtenu = contratDao.addContrat(c).getBienImmobilier().getAgent().getNomPersonne();
		assertEquals(nomAgentExpected, nomAgentObtenu);
	}
	
	@Test
	public void addContratTestTelephoneAgent() {
		Agent a = new Agent("Robert", "0606060606", "aaa");
		Contrat c = new Contrat(125, "septembre");
		contratDao.addContrat(c);
		String telephoneAgentExpected = "0606060606";
		String telephoneAgentObtenu = contratDao.addContrat(c).getBienImmobilier().getAgent().getTelephonePrive();
		assertEquals(telephoneAgentExpected, telephoneAgentObtenu);
	}
	
	@Test
	public void addContratTestMdpAgent() {
		Agent a = new Agent("Robert", "0606060606", "aaa");
		Contrat c = new Contrat(125, "septembre");
		contratDao.addContrat(c);
		String mdpAgentExpected = "aaa";
		String mdpAgentObtenu = contratDao.addContrat(c).getBienImmobilier().getAgent().getMdpAgent();
		assertEquals(mdpAgentExpected, mdpAgentObtenu);
	}
	
	/*=========================================================
	 ====================Test GetAll Contrat===================
	 ==========================================================*/
	
	
	
	
}
