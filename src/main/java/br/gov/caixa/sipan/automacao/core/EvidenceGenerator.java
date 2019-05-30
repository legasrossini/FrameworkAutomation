package br.gov.caixa.sipan.automacao.core;

import java.io.ByteArrayOutputStream;
import java.io.File;
//import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class EvidenceGenerator {
	
	private static BaseColor person = new BaseColor(13, 84, 191);
	private static Font fontDescricao = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.NORMAL, person);
	private static Font fontError = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, BaseColor.RED);
	private static Font fonteBold = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD, person);
	private static Font fontTitle = new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.BOLD, person);	
	private static Font fontLbl = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, person);
	private static Font fontTxt = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, person);
	
	private WebDriver driver;
	public static Document doc;
	
	public static Image print;
	public static PdfWriter writer;
	
	public EvidenceGenerator(WebDriver driver) throws Throwable {	
		this.driver = driver;
		criarDoc();
		criarCapa();		
	}
	
	public void criarDoc() throws Throwable {
		doc = new Document(PageSize.A4);
		File os = new File("C:\\Users\\f626282\\eclipse-workspace\\AutomacaoSipan\\evidencias\\"+pegarHora().replace(":", "")+"PJ.pdf");
		FileOutputStream pdfFileout = new FileOutputStream(os);
		writer = PdfWriter.getInstance(doc, pdfFileout);
		doc.open();	
	}

	public void criarCapa() throws DocumentException, InterruptedException, MalformedURLException, IOException {		

		Image image2 = Image.getInstance("C:\\Users\\f626282\\eclipse-workspace\\AutomacaoSipan\\images\\caixa.jpg");		
		image2.setAlignment(Element.ALIGN_CENTER);
		image2.scalePercent(10,10);
		image2.setSpacingBefore(270);
		doc.add(image2);
		
		Paragraph title = new Paragraph("Evidência de Testes Selenium", fontTitle);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(250);
		doc.add(title);

		PdfPTable tableheader = new PdfPTable(new float[] { 0.17f, 0.17f, 0.17f, 0.20f, 0.16f, 0.13f });
		tableheader.setSpacingBefore(300);

		PdfPCell header = new PdfPCell(new Paragraph("DESCRIÇÃO", fonteBold));
		PdfPCell lblCT = new PdfPCell(new Paragraph("CT",fontLbl));
		PdfPCell txtCT = new PdfPCell(new Paragraph("CTACPJ000001: Cadastro de conta PJ",fontTxt));		
		PdfPCell lblSistema = new PdfPCell(new Paragraph("Sistema",fontLbl));
		PdfPCell txtSistema = new PdfPCell(new Paragraph("Portal de Atendimento e Negócios",fontTxt));		
		PdfPCell lblProjeto = new PdfPCell(new Paragraph("Projeto",fontLbl));
		PdfPCell txtProjeto = new PdfPCell(new Paragraph("NEGOCIOS.CAIXA",fontTxt));		
		PdfPCell lblNavegador = new PdfPCell(new Paragraph("Navegador",fontLbl));
		PdfPCell txtNavegador = new PdfPCell(new Paragraph(pegarNavegador(),fontTxt));
		PdfPCell lblVersao = new PdfPCell(new Paragraph("Versão",fontLbl));
		PdfPCell txtVersao = new PdfPCell(new Paragraph(pegarNavegadorVersao(),fontTxt));
		PdfPCell lblExecutor = new PdfPCell(new Paragraph("Executor",fontLbl));
		PdfPCell txtExecutor = new PdfPCell(new Paragraph(pegarExecutor(),fontTxt));
		PdfPCell lblData = new PdfPCell(new Paragraph("Data",fontLbl));
		PdfPCell txtData = new PdfPCell(new Paragraph(pegarData(),fontTxt));
		PdfPCell lblHora = new PdfPCell(new Paragraph("Horário",fontLbl));
		PdfPCell txtHora = new PdfPCell(new Paragraph(pegarHora(),fontTxt));
		
		header.setUseBorderPadding(true);
		header.setBorderColor(person);
		header.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		lblCT.setBorderColor(person);
		lblCT.setHorizontalAlignment(Element.ALIGN_TOP);
		txtCT.setBorderColor(person);
		
		lblSistema.setBorderColor(person);
		lblSistema.setHorizontalAlignment(Element.ALIGN_TOP);
		txtSistema.setBorderColor(person);
		
		lblProjeto.setBorderColor(person);
		lblProjeto.setHorizontalAlignment(Element.ALIGN_TOP);
		txtProjeto.setBorderColor(person);
		
		lblNavegador.setBorderColor(person);
		lblNavegador.setHorizontalAlignment(Element.ALIGN_TOP);
		txtNavegador.setBorderColor(person);
		
		lblVersao.setBorderColor(person);
		lblVersao.setHorizontalAlignment(Element.ALIGN_TOP);
		txtVersao.setBorderColor(person);
		
		lblExecutor.setBorderColor(person);
		lblExecutor.setHorizontalAlignment(Element.ALIGN_TOP);
		txtExecutor.setBorderColor(person);
		
		lblData.setBorderColor(person);
		lblData.setHorizontalAlignment(Element.ALIGN_TOP);
		txtData.setBorderColor(person);
		
		lblHora.setBorderColor(person);
		lblHora.setHorizontalAlignment(Element.ALIGN_TOP);
		txtHora.setBorderColor(person);
		
		header.setColspan(6);
		txtCT.setColspan(5);
		txtSistema.setColspan(5);
		txtProjeto.setColspan(5);
		txtNavegador.setColspan(2);
		txtVersao.setColspan(2);

		tableheader.addCell(header);
		tableheader.addCell(lblCT);
		tableheader.addCell(txtCT);
		tableheader.addCell(lblSistema);
		tableheader.addCell(txtSistema);
		tableheader.addCell(lblProjeto);
		tableheader.addCell(txtProjeto);
		tableheader.addCell(lblNavegador);
		tableheader.addCell(txtNavegador);
		tableheader.addCell(lblVersao);
		tableheader.addCell(txtVersao);
		tableheader.addCell(lblExecutor);
		tableheader.addCell(txtExecutor);
		tableheader.addCell(lblData);
		tableheader.addCell(txtData);
		tableheader.addCell(lblHora);
		tableheader.addCell(txtHora);		
		
		doc.add(tableheader);
		doc.newPage();		
	}
	
	public Image printPage() throws IOException, BadElementException {
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ImageIO.write(fpScreenshot.getImage(),"PNG", outputStream);
		Image img = Image.getInstance(outputStream.toByteArray());	
		img.setAlignment(Element.ALIGN_CENTER);		
		img.scalePercent(25,25);
		return img;
	}	
	
	public void logError(String mensagem) throws IOException, DocumentException {
		print = printPage();
		
		Paragraph mensagemAdd = new Paragraph(mensagem, fontError);		
		doc.add(mensagemAdd);
		
		doc.add(print);
		doc.newPage();
	}
	
	public void logInfo(String mensagem, Boolean tirarPrint) throws IOException, DocumentException {
		
		Paragraph mensagemAdd = new Paragraph(mensagem, fontDescricao);		
		doc.add(mensagemAdd);
		
		if(tirarPrint) {			
			print = printPage();
			doc.add(print);
			doc.newPage();
		}
	}
	
	public void logInfo(String mensagem) throws IOException, DocumentException {
		Paragraph mensagemAdd = new Paragraph(mensagem, fontDescricao);		
		doc.add(mensagemAdd);
	}
	
	public String pegarExecutor() {
		return System.getProperty("user.name");
	}
	
	public String pegarData() {		
        //Obtém LocalDate de hoje
        LocalDate hoje = LocalDate.now();    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String hojeFormatado = hoje.format(formatter);
        return hojeFormatado;
	}
	
	public String pegarHora() {
        //Obtém LocalDateTime de agora
        LocalTime agora = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String agoraFormatado = agora.format(formatter);
        return agoraFormatado;
	}
	
	public String pegarNavegador() {
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		return caps.getBrowserName();
	}
	
	public String pegarNavegadorVersao() {
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		return caps.getVersion();			
	}
}
