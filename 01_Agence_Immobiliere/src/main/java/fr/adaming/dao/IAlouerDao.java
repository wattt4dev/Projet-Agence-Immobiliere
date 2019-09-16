package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Agent;
import fr.adaming.entity.Alouer;

public interface IAlouerDao {
	
	public void addAlouer(Alouer aLouer);
	public void deleteAlouer(int idBienImmobilier);
	public void updateAlouer(Alouer al);
	public List<Alouer> getAllAlouer();
	public Alouer getAlouerById(int idBienImmobilier);

}
