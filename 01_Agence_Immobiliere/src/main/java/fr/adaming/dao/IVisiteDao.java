package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Visite;

public interface IVisiteDao {
	
	public Visite addVisite(Visite v, Agent a);
	public void deleteVisite(int idVisite, Agent a);
	public void updateVisite(Visite v, Agent a);
	public List<Visite> getAllVisite(Agent a);
	public Visite getVisiteById(int idVisite, Agent a);

}
