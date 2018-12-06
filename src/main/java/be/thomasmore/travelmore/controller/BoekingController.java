package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.SessionUtils;
import be.thomasmore.travelmore.domain.Boeking;
import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.domain.Klant;
import be.thomasmore.travelmore.domain.Reis;
import be.thomasmore.travelmore.service.BoekingService;
import be.thomasmore.travelmore.service.GebruikerService;
import be.thomasmore.travelmore.service.KlantService;


import be.thomasmore.travelmore.service.ReisService;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.mail.smtp.SMTPTransport;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

@ManagedBean
@SessionScoped
public class BoekingController {

    @Inject
    private BoekingService boekingService;
    @Inject
    private KlantService klantService;
    @Inject
    private ReisService reisService;
    @Inject
    GebruikerService gebruikerService;

    private Boeking nieuweBoeking;

    private Boeking boeking;

    public Boeking getNieuweBoeking() {
        return nieuweBoeking;
    }

    public void setNieuweBoeking(Boeking nieuweBoeking) {
        this.nieuweBoeking = nieuweBoeking;
    }

    public Boeking getBoeking() {
        return boeking;
    }

    public void setBoeking(Boeking boeking) {
        this.boeking = boeking;
    }

    public String boeken(Reis reis) {
        nieuweBoeking = new Boeking();
        nieuweBoeking.setReis(reis);
        HttpSession session = SessionUtils.getSession();
        nieuweBoeking.setKlant(klantService.findKlantById(Integer.parseInt(session.getAttribute("id").toString() )));
        return "boeken";
    }

    public String boekingAanmaken() {
        boekingService.insertBoeking(nieuweBoeking);
        nieuweBoeking.getReis().setAantalPlaatsen(nieuweBoeking.getReis().getAantalPlaatsen() - nieuweBoeking.getAantalPersonen());
        reisService.refreshReis(nieuweBoeking.getReis());
        System.out.println("Boeking " + nieuweBoeking.getReis().getNaam() + " aangemaakt");
        System.out.println("Aantal beschikbare plaatsen voor reis aangepast");
        boekingMessage();
        return "boekingen";
    }

    public double berekenPrijs(int personen) {
        return Math.floor(nieuweBoeking.getReis().getPrijsPerPersoon() * personen);
    }

    public String toonBevestiging( ) {

        return "bevestiging";
    }

    public String getAangemeldeGebruikerSoort() {
        HttpSession session = SessionUtils.getSession();
        Gebruiker gebruiker = gebruikerService.findGebruikerById(Integer.parseInt(session.getAttribute("id").toString() ));
        return gebruiker.getClass().getSimpleName();
    }

    public double berekenPrijsBoeking(int personen) {
        return Math.floor(boeking.getReis().getPrijsPerPersoon() * personen);
    }

    public String detailsBoeking(Boeking boeking) {
        this.boeking = boeking;
        return "detailsBoeking";
    }

    public String wijzigStatusBetaald() {
        boekingService.updateStatusBetaald(boeking.getId());
        System.out.println("Boeking " + boeking.getReis().getNaam() + " is betaald");
        this.toonBevestiging();

        final String username = "travelmoreG11@gmail.com";
        final String password = "TravelmoreG.11";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(boeking.getKlant().getEmail()));
            message.setSubject("Boeking reis " + boeking.getReis().getNaam());
            message.setText("Beste meneer/mevrouw " + boeking.getKlant().getNaam() + ","
                    + "\n\n Uw betaling is goed ontvangen."
                    + "\n\n Details:"
                    + "\n Periode: " + boeking.getReis().getStartDatum() + " - " + boeking.getReis().getEindDatum()
                    + "\n Locatie: " + boeking.getReis().getAankomstLocatie().getLandEnStadNaam()
                    + "\n Aantal personen: " + boeking.getAantalPersonen()
                    + "\n Totaal prijs: " + berekenPrijsBoeking(boeking.getAantalPersonen())
                    + "\n\n Voor eventuele vragen contacteer " + username + ".");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return "boekingen";
    }

    public String wijzigStatusBetaaldMetPdf() {
        boekingService.updateStatusBetaald(boeking.getId());
        System.out.println("Boeking " + boeking.getReis().getNaam() + " is betaald");
        this.toonBevestiging();

        final String username = "travelmoreG11@gmail.com";
        final String password = "TravelmoreG.11";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        ByteArrayOutputStream outputStream = null;

        try {
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("Beste meneer/mevrouw " + boeking.getKlant().getNaam() + ","
                    + "\n\n Uw betaling is goed ontvangen."
                    + "\n\n Details:"
                    + "\n Periode: " + boeking.getReis().getStartDatum() + " - " + boeking.getReis().getEindDatum()
                    + "\n Locatie: " + boeking.getReis().getAankomstLocatie().getLandEnStadNaam()
                    + "\n Aantal personen: " + boeking.getAantalPersonen()
                    + "\n Totaal prijs: " + berekenPrijsBoeking(boeking.getAantalPersonen())
                    + "\n\n Voor eventuele vragen contacteer " + username + ".");

            outputStream = new ByteArrayOutputStream();
            generatePdf(outputStream);
            byte[]  bytes = outputStream.toByteArray();

            DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
            MimeBodyPart pdfBodyPart = new MimeBodyPart();
            pdfBodyPart.setDataHandler(new DataHandler(dataSource));
            pdfBodyPart.setFileName("bevestiging.pdf");

            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart);

            /* -------------------------------------------------------------- */

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(boeking.getKlant().getEmail()));
            message.setSubject("Boeking reis " + boeking.getReis().getNaam());
            message.setContent(mimeMultipart);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        betalingMessage();
        return "boekingen";
    }

    public String returnDetail() {
        return "detailsBoeking";
    }

    public void generatePdf(OutputStream outputStream) throws Exception {
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);

        document.open();

        document.addTitle("Test PDF");
        document.addSubject("Testing email PDF");
        document.addKeywords("iText, email");
        document.addAuthor("Jee Vang");
        document.addCreator("Jee Vang");

        Paragraph paragraph = new Paragraph();
        paragraph.add(new Chunk(this.returnDetail()));
        document.add(paragraph);

        document.close();
    }

    public void boekingMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Succesvol",  "De reis is geboekt.") );
    }

    public void betalingMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Succesvol",  "De reis is betaald.") );
    }
}
