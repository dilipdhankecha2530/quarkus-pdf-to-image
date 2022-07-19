package org.acme;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws IOException {
        File pdfFile =new File("/home/dilip/Desktop/delete/code-with-quarkus/src/main/resources/test.pdf");
        File openBadgeFile = new File("/home/dilip/Desktop/delete/code-with-quarkus/src/main/resources/test.png");
        PDDocument document = PDDocument.load(pdfFile);
        PDFRenderer pdfRenderer = new PDFRenderer(document);
        BufferedImage bImage = pdfRenderer.renderImageWithDPI(0,300, ImageType.RGB);
        ImageIO.write(bImage, "png", openBadgeFile);
        return "Hello RESTEasy";
    }

}