package iText;
import java.io.File;
import com.itextpdf.licensing.base.LicenseKey;
import com.itextpdf.licensing.base.exceptions.LicenseKeyException;
import com.itextpdf.pdf2data.Pdf2DataExtractor;
import com.itextpdf.pdf2data.result.ParsingResult;
import com.itextpdf.pdf2data.template.Template;

public class iText {
	public static void main(String[] args) {
		try {
		// Make sure to load license file before invoking any code
		File info = new File("iTextPdf2Data-License.json");
		LicenseKey.loadLicenseFile(info);
		// Parse template into an object that will be used later on
		Template template = Pdf2DataExtractor.parseTemplateFromPDF("GitHub-InvoiceTemplate.pdf");
		// Create an instance of Pdf2DataExtractor for the parsed template
		Pdf2DataExtractor extractor = new Pdf2DataExtractor(template);
		// Feed file to be parsed against the template. Can be called multiple times for different files
		ParsingResult result = extractor.recognize("GitHub-Invoice1.pdf");
		// Save result to XML or explore the ParsingResult object to fetch information programmatically
		result.saveToXML("result.xml");
		} catch(Exception | LicenseKeyException e) {
			e.printStackTrace();
		}
	}
	
}
