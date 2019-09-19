package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Aacheter;
import fr.adaming.entity.Alouer;

public interface IALouerService {
	
	public void addAlouerService(Alouer aLouer);
	public void deleteAlouerService(int idBienImmobilier);
	public void updateAlouerService(Alouer al);
	public List<Alouer> getAllAlouerService();
	public Alouer getAlouerByIdService(int idBienImmobilier);
	public List<Alouer> getAlouerByDepartement(String departement);

}
