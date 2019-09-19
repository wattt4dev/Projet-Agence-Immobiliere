package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Aacheter;
import fr.adaming.entity.Alouer;

public interface IAAcheterService {
	
	public void addAacheter(Aacheter achat);
	public void deleteAacheter(int idBienImmobilier);
	public void updateAacheter(Aacheter achat);
	public List<Aacheter> getAllAacheter();
	public Aacheter getAacheterById(int idBienImmobilier);
	public List<Aacheter> getAacheterByRegion(String region);


}
