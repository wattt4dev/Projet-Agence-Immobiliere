package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Visite;

public interface IVisiteService {

	public void addVisite(Visite v,String type,int idImmo);
	public void deleteVisite(int idVisite);
	public void updateVisite(Visite v);
	public List<Visite> getAllVisite();
	public Visite getVisiteById(int idVisite);
	
}
