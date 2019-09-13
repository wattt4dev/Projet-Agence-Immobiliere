package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Aacheter;
import fr.adaming.entity.Agent;

public interface IAcheterDao {
	
	public Aacheter addAacheter(Aacheter achat, Agent a);
	public void deleteAacheter(int idCategorie, Agent a);
	public void updateAacheter(Aacheter achat, Agent a);
	public List<Aacheter> getAllAacheter(Agent a);
	public Aacheter getAacheterById(int idCategorie, Agent a);

}
