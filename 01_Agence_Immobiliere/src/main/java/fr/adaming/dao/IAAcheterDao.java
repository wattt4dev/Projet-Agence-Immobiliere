package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Aacheter;

public interface IAAcheterDao {
	
	public void addAacheter(Aacheter achat);
	public void deleteAacheter(int idBienImmobilier);
	public void updateAacheter(Aacheter achat);
	public List<Aacheter> getAllAacheter();
	public Aacheter getAacheterById(int idBienImmobilier);
	public List<Aacheter> getAacheterByDepartement(String departement);


}
