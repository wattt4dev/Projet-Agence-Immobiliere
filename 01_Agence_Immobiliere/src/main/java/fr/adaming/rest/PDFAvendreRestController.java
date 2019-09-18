package fr.adaming.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;

import fr.adaming.entity.Aacheter;
import fr.adaming.entity.Alouer;
import fr.adaming.service.IAAcheterService;

@RestController
@RequestMapping("/pdf")
@CrossOrigin(origins= {"http://localhost:4200"})
public class PDFAvendreRestController {
	
	@Autowired
	private IAAcheterService aService;
	
		//@RequestMapping(value = "/achat", method = RequestMethod.GET)
		@RequestMapping(value = "/achat/{pId}", method = RequestMethod.GET)
		protected void handleRequestInternal(HttpServletRequest request, HttpServletResponse response,@PathVariable("pId") int vendreId) throws Exception {
	    //protected void handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

			 Aacheter l = aService.getAacheterById(vendreId);
			
				

			// ____________________________________PDF___________________________________________

			// Chemin pour recupérer le pdf vide
			String masterPath = request.getServletContext().getRealPath("/WEB-INF/FactureAchat.pdf");
			// Spécifier que la reponse sera de type pdf
			response.setContentType("application/pdf");
		
			
			try (
					// Note : les outils ouverts dans ce try seront automatiquement fermés

					// Ouvrir le pdf vide à modifier à partir du chemin
					PdfReader reader = new PdfReader(masterPath);

					// Spécifier où sera envoyé le pdf
					PdfWriter writer = new PdfWriter(response.getOutputStream());

					// Créer le nouveau document pdf
					PdfDocument document = new PdfDocument(reader, writer)) {

				// Définire la page sur laquelle on écrit
				PdfPage page = document.getPage(1);

				// Instancier l'outil pour écrir dans le pdf
				PdfCanvas canvas = new PdfCanvas(page);

				// Définire le font de l'écriture
				FontProgram fontProgram = FontProgramFactory.createFont();
				PdfFont font = PdfFontFactory.createFont(fontProgram, "ISO-8859-1", true);
				// Pour changer la couleur du font =>
				// https://itextpdf.com/en/resources/examples/itext-7/colored-text

				canvas.setFontAndSize(font, 12);

				// Commencer l'écriture dans le pdf
				canvas.beginText();

//				 canvas.setTextMatrix(0, 0);
//				 canvas.showText("origine");

				// --------------------CE-----------------------------
				
				//Facture numero
				canvas.setTextMatrix(178, 758);
				canvas.showText(l.getNumeroFactureBienImmobilier());
				
				//Date 
				canvas.setTextMatrix(265, 758);
				canvas.showText(l.getDateSoumissionBienImmobilier());
				
				//IdClient
				canvas.setTextMatrix(120, 730);
				canvas.showText(Double.toString(l.getClient().getIdPersonne()));

				//Nom Client
				canvas.setTextMatrix(130, 703);
				canvas.showText(l.getClient().getNomPersonne());
				
				//Adresse client
				canvas.setTextMatrix(115, 675);
				canvas.showText(l.getClient().getAdresseClient());
				
				//Telephne client
				canvas.setTextMatrix(170, 634);
				canvas.showText(l.getClient().getTelephonePrive());
			
				//Affaire
				canvas.setTextMatrix(80, 500);
				canvas.showText(l.getNumeroAffaireBienImmobilier());
				
				//Effectuee 
				canvas.setTextMatrix(230, 500);
				canvas.showText(l.getDateFactureBienImmobilier());
				
				//Adressse du bien 
				canvas.setTextMatrix(380, 500);
				canvas.showText(l.getLocalisationBienImmobilier());
				
				//Type de bien 
				canvas.setTextMatrix(147, 415);
				canvas.showText(l.getTypeDeBienImmobilier());
				
				//Superficie minimale
				canvas.setTextMatrix(170, 399);
				canvas.showText(l.getCategorie().getSuperficieCategorie());
				
				//Nombre de pieces
				//canvas.setTextMatrix(0, 0);
				
				
				//Etat
				canvas.setTextMatrix(98, 368);
				canvas.showText(l.getEtatAAcheter());
				
				//Date de disponibilité 
				canvas.setTextMatrix(172, 352);
				canvas.showText(l.getDateDispoBienImmobilier());
				
				//Prix demander
				canvas.setTextMatrix(435, 255);
				canvas.showText(Double.toString(l.getPrixDemandeAAcheter()));
				
				
			
				
				
				
				
				
				
				
				
		//		canvas.setTextMatrix(0, 100);
		//		canvas.showText(Integer.toString(pan.getId()));


				// Finir l'écriture dans le pdf
				canvas.endText();

			}


		}

}
