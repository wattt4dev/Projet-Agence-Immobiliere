package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Alouer;

public interface IAlouerDao {
	
	public Alouer addAlouer(Alouer l, Agent a);
	public void deleteAlouer(int idCategorie, Agent a);
	public void updateAlouer(Alouer l, Agent a);
	public List<Alouer> getAllAlouer(Agent a);
	public Alouer getAlouerById(int idCategorie, Agent a);

}
