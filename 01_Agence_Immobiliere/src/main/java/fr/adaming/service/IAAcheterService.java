package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Aacheter;

public interface IAAcheterService {
	
	public void addAacheter(Aacheter achat);
	public void deleteAacheter(int idBienImmobilier);
	public void updateAacheter(Aacheter achat);
	public List<Aacheter> getAllAacheter();
	public Aacheter getAacheterById(int idBienImmobilier);

}
