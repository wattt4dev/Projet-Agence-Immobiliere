package fr.adaming.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

import fr.adaming.dao.IAlouerDao;
import fr.adaming.entity.Alouer;

@RestController
@RequestMapping("/pdf")
public class PDFRestController {

	@Autowired
	IAlouerDao lService;
	
	//@RequestMapping(value = "/alouer", method = RequestMethod.GET)
	@RequestMapping(value = "/alouer/{pId}", method = RequestMethod.GET)
	protected void handleRequestInternal(HttpServletRequest request, HttpServletResponse response,@PathVariable("pId") int louerId) throws Exception {
    //protected void handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

		 Alouer l = lService.getAlouerById(louerId);
		
			

		// ____________________________________PDF___________________________________________

		// Chemin pour recupérer le pdf vide
		String masterPath = request.getServletContext().getRealPath("/WEB-INF/FactureLocation.pdf");
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

		//	 canvas.setTextMatrix(0, 0);
		//	 canvas.showText("origine");

								// --------------------CE-----------------------------

			canvas.setTextMatrix(0, 0);
			canvas.showText(Double.toString(l.getCautionALouer()));
			
	//		canvas.setTextMatrix(0, 100);
	//		canvas.showText(Integer.toString(pan.getId()));


			// Finir l'écriture dans le pdf
			canvas.endText();

		}


	}
	
}
