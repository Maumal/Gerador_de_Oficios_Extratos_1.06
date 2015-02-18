package pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class GeraOficioxxxx {

    static String Oficio = "";
    static String AOF = "";
    static String Data;
    static String Processo;
    static String Inquerito;
    static String OficioN;
    static String Autor;
    static String Reu;
    static String Envolvido;   

    static String Corpo;
    static String Destinatário;
    static String Endereco;
    static String Abc;

    /* public GeraOficioxxxx(Oficio of) {      
            
     }*/
    public void Gerar(Oficio of) throws FileNotFoundException, IOException, DocumentException, InterruptedException {
        Oficio = of.getOficio();
    //    AOF = of.getAof();
    //    Data = of.getAof();
        Processo = of.getProcesso();
   //     Inquerito = of.getInquerito();
   //     OficioN = of.getOficion();
  //      Autor = of.getAutor();
        Reu = of.getReu();
   //     Envolvido = of.getEnvolvido();
        Corpo = of.getCorpo();
        Destinatário = of.getDestinario();
        Endereco = of.getEndereco();
        Abc = of.getAbc();
        Data = of.getData();

        Document documento = null;
        OutputStream os = null;
        
     //  JOptionPane.showMessageDialog(null,"dentro da funcção" +  of.getOficio());
        
     //    File fg = new File("OficioSemLogo.pdf");  
     //    fg.delete(); 
        
        

        try {
            //FONTES        
            FontFactory.register("c:\\windows\\fonts\\arial.ttf");
            FontFactory.register("c:\\windows\\fonts\\arialbd.ttf");

            //Arial 8   
            Font Arial8 = new Font(FontFactory.getFont("arial"));
            Arial8.setSize(8);

            //Arial 10   
            Font Arial10 = new Font(FontFactory.getFont("arial"));
            Arial10.setSize(10);

            Font Arial10N = new Font(FontFactory.getFont("arial"));
            Arial10N.setSize(10);
            Arial10N.setStyle("bold");

            //Arial 12   
            Font Arial12 = new Font(FontFactory.getFont("arial"));
            Arial12.setSize(12);

            Font Arial12N = new Font(FontFactory.getFont("arial"));
            Arial12N.setSize(12);
            Arial12N.setColor(BaseColor.BLACK);
            Arial12N.setStyle("bold");

            //Arial 14   
            Font Arial14 = new Font(FontFactory.getFont("arial"));
            Arial14.setSize(14);

            Font Arial14N = new Font(FontFactory.getFont("arial"));
            Arial14N.setSize(14);
            Arial14N.setStyle("bold");

            //Arial 16   
            Font Arial16 = new Font(FontFactory.getFont("arial"));
            Arial16.setSize(16);

            Font Arial16N = new Font(FontFactory.getFont("arial"));
            Arial16N.setSize(16);
            Arial16N.setStyle("bold");

            documento = new Document(PageSize.A4, 72, 36, 80, 50);            
            
            PdfWriter writer = PdfWriter.getInstance(documento,               
                      new FileOutputStream("c:\\temp\\OficioSemLogo.pdf"));
        //--            new FileOutputStream("OficioSemLogo.pdf"));

            //CABEÇALHO E RODAPÉ
            //  Rectangle rct = new Rectangle(36, 54, 559, 788);
            Rectangle rct = new Rectangle(50, 50, 180, 800);
            //Definimos un nombre y un tamaño para el PageBox los nombres posibles son: “crop”, “trim”, “art” and “bleed”.
            writer.setBoxSize("art", rct);
            HeaderFooter event = new HeaderFooter();
            writer.setPageEvent(event);

            //abre o documento
            documento.open();

            Paragraph LinhaBranca = new Paragraph("                                             ");

            documento.add(LinhaBranca);
            documento.add(LinhaBranca);

            //Insere Processo no PDF            
            Paragraph processo = new Paragraph("Processo Nº            : " + of.getProcesso(), Arial12N);
            processo.setAlignment(Element.ALIGN_LEFT);

            if (!"".equals(Processo)) {//Se vazio não grava
                documento.add(processo);
            }

            //////////////////////////
            //Insere INQUERITO no PDF            
            Paragraph inquerito = new Paragraph("Inquerito Policial Nº : " + of.getCorpo(), Arial12N);
            inquerito.setAlignment(Element.ALIGN_LEFT);

            if (!"".equals(Inquerito)) {//Se vazio não grava
                documento.add(inquerito);
            }

            //////////////////////////
            //Insere OFICION no PDF            
            Paragraph oficion = new Paragraph("Ofício Nº                  : " + of.getAbc(), Arial12N);
            oficion.setAlignment(Element.ALIGN_LEFT);
            if (!"".equals(OficioN)) {//Se vazio não grava
                documento.add(oficion);
            }

            //////////////////////////
            //Insere AUTOR no PDF            
            Paragraph autor = new Paragraph("Autor                        : " + of.getAbc(), Arial12N);
            oficion.setAlignment(Element.ALIGN_LEFT);
            if (!"".equals(Autor)) {//Se vazio não grava
                documento.add(autor);
            }
            //////////////////////////
            //Insere RÉU no PDF            
            Paragraph reu = new Paragraph("Réu                          : " + of.getReu(), Arial12N);
            oficion.setAlignment(Element.ALIGN_LEFT);
            if (!"".equals(Reu)) {//Se vazio não grava
                documento.add(reu);
            }

            //////////////////////////
            //Insere ENVOLVIDO no PDF            
            Paragraph envolvido = new Paragraph("Envolvido                 : " + of.getAbc(), Arial12N);
            oficion.setAlignment(Element.ALIGN_LEFT);
            if (!"".equals(Envolvido)) {//Se vazio não grava
                documento.add(envolvido);
            }
            //////////////////////////  
            documento.add(LinhaBranca);
            documento.add(LinhaBranca);
            //////////////////////////////////
            //////////////////////////////////
            /////////////////////////////////
            String[] dadosJavaSplit = of.getCorpo().split("\\\n");
            
            for (String t : dadosJavaSplit) {                
                Paragraph p7 = new Paragraph(tabulacaoDoTexto(t), Arial12);
                p7.setSpacingBefore(00);
                p7.setSpacingAfter(5);
                p7.setTabSettings(new TabSettings(56f));
                p7.setAlignment(Element.ALIGN_JUSTIFIED);
                documento.add(p7);
            }
//            //INSERE O CORPO DO PDF
//            Paragraph Corpo = new Paragraph(tabulacaoDoTexto(of.getCorpo()), Arial12);
//            Corpo.setAlignment(Element.ALIGN_JUSTIFIED);
//            Corpo.setSpacingBefore(50);
//            Corpo.setSpacingAfter(50);
//            documento.add(Corpo);
            ////////////////////////////////////////////////////////////////
            documento.add(LinhaBranca);
            documento.add(LinhaBranca);          

            //////////////////////////////////
            //////////////////////////////////
            /////////////////////////////////
            /////////////////////////////////
            Paragraph p8 = new Paragraph("BANCO DO BRASIL S.A.", Arial14N);
            p8.setAlignment(Element.ALIGN_CENTER);
            documento.add(p8);
            Paragraph p9 = new Paragraph("CENOP SERVIÇOS SÃO PAULO/SP", Arial12);
            p9.setAlignment(Element.ALIGN_CENTER);
            documento.add(p9);

            int linhas;            
    //        System.out.println("");
            
            linhas = of.getLinhas();            
            
            for (int i = 0; i < linhas; i++) {
                documento.add(LinhaBranca);
            }           
            documento.add(LinhaBranca);
            //INSERE O DESTINATARIO DO PDF
            Paragraph destinatario = new Paragraph(of.getDestinario(), Arial10);
            destinatario.setAlignment(Element.ALIGN_LEFT);
            documento.add(destinatario);
            ////////////////////////////////////////////////
        //    documento.add(LinhaBranca);

            //INSERE O ENDERECO DO PDF
            Paragraph endereco = new Paragraph(of.getEndereco(), Arial10);
            endereco.setAlignment(Element.ALIGN_LEFT);
            documento.add(endereco);
            //////////////////////////////////////////////////

       //     documento.add(LinhaBranca);//
           // 
        } finally {
            if (documento != null) {
                //fechamento do documento
                documento.close();
            }
            if (os != null) {
                //fechamento da stream de saída
                os.close();
            }              
        }

//INSERE O LOGO DO BANCO--CÓDIGO DE COLOCAR MARCA D AGUA       
        try {
              PdfReader Read_PDF_To_Watermark = new PdfReader("c:\\temp\\OficioSemLogo.pdf");
         //--   PdfReader Read_PDF_To_Watermark = new PdfReader("OficioSemLogo.pdf");
            int number_of_pages = Read_PDF_To_Watermark.getNumberOfPages();
              PdfStamper stamp = new PdfStamper(Read_PDF_To_Watermark, new FileOutputStream("c:\\temp\\OficioComLogo.pdf"));
   //--         PdfStamper stamp = new PdfStamper(Read_PDF_To_Watermark, new FileOutputStream("OficioComLogo.pdf"));  
            int i = 0;
            Image watermark_image = Image.getInstance("c:\\temp\\LogoRetangular.png");           
            
            //--Image watermark_image = Image.getInstance("LogoRetangular.png");
            watermark_image.setAbsolutePosition(72, 775);
            PdfContentByte add_watermark;
            while (i < number_of_pages) {
                i++;
                add_watermark = stamp.getUnderContent(i);
                add_watermark.addImage(watermark_image);
            }           
           stamp.close();       
           Read_PDF_To_Watermark.close();           
        } catch (DocumentException | IOException i1) {                       
        }          
        
   //     Process p = Runtime.getRuntime().exec("cmd.exe /C c:\\temp\\OficioComLogo.pdf"); 
        
        
//         try {
//            Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start", "/temp/OficiSemLogo.pdf"});
//        } catch (IOException ex) {  
//            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
//    public void colocaLogo() throws IOException, DocumentException {
//                  //INSERE O LOGO DO BANCO--CÓDIGO DE COLOCAR MARCA D AGUA       
//        try {
//            //   PdfReader Read_PDF_To_Watermark = new PdfReader("c:\\temp\\OficioSemLogo.pdf");
//            PdfReader Read_PDF_To_Watermark = new PdfReader("OficioSemLogo.pdf");
//            int number_of_pages = Read_PDF_To_Watermark.getNumberOfPages();
//            //  PdfStamper stamp = new PdfStamper(Read_PDF_To_Watermark, new FileOutputStream("c:\\temp\\OficioComLogo.pdf"));
//            PdfStamper stamp = new PdfStamper(Read_PDF_To_Watermark, new FileOutputStream("OficioComLogo.pdf"));  
//            int i = 0;
//            //Image watermark_image = Image.getInstance("c:\\temp\\LogoRetangular.png");
//            Image watermark_image = Image.getInstance("LogoRetangular.png");
//            watermark_image.setAbsolutePosition(72, 775);
//            PdfContentByte add_watermark;
//            while (i < number_of_pages) {
//                i++;
//                add_watermark = stamp.getUnderContent(i);
//                add_watermark.addImage(watermark_image);
//            }
//           
//           stamp.close();          
//           
//        } catch (DocumentException | IOException i1) {
//                       
//        }       
//    }


    public void GerarAR(Oficio of) throws FileNotFoundException, IOException, DocumentException {
        // TODO code application logic here
        //FONTES        
        FontFactory.register("c:\\windows\\fonts\\arial.ttf");
        FontFactory.register("c:\\windows\\fonts\\arialbd.ttf");

        //Arial 8   
        Font Arial8 = new Font(FontFactory.getFont("arial"));
        Arial8.setSize(8);

        //Arial 10   
        Font Arial10 = new Font(FontFactory.getFont("arial"));
        Arial10.setSize(10);

        Font Arial10N = new Font(FontFactory.getFont("arial"));
        Arial10N.setSize(10);
        Arial10N.setStyle("bold");

        //Arial 12   
        Font Arial12 = new Font(FontFactory.getFont("arial"));
        Arial12.setSize(12);

        Font Arial12N = new Font(FontFactory.getFont("arial"));
        Arial12N.setSize(12);
        Arial12N.setColor(BaseColor.BLACK);
        Arial12N.setStyle("bold");

        //Arial 14   
        Font Arial14 = new Font(FontFactory.getFont("arial"));
        Arial14.setSize(14);

        Font Arial14N = new Font(FontFactory.getFont("arial"));
        Arial14N.setSize(14);
        Arial14N.setStyle("bold");

        //Arial 16   
        Font Arial16 = new Font(FontFactory.getFont("arial"));
        Arial16.setSize(16);

        Font Arial16N = new Font(FontFactory.getFont("arial"));
        Arial16N.setSize(16);
        Arial16N.setStyle("bold");

        // Create output PDF
        
      
    // Document document = new Document(PageSize.A4);
         Document document = new Document(PageSize.A4, 115, 20, 80, 50);
        
        PdfWriter writer = PdfWriter.getInstance(document,
             //--   new FileOutputStream("ARF.pdf"));
                
                new FileOutputStream("c:\\temp\\ARF.pdf"));

        document.open();
        PdfContentByte cb = writer.getDirectContent();

      // Load existing PDF
      //--  PdfReader reader = new PdfReader("AR.pdf");
        
   PdfReader reader = new PdfReader("c:\\temp\\AR.pdf");        
      
         
        PdfImportedPage page = writer.getImportedPage(reader, 1);

        document.newPage();
        cb.addTemplate(page, 0, -30);

        Paragraph linhaBranca = new Paragraph("                                  ");
        // Setando o alinhamento p/ o centro
        linhaBranca.setAlignment(Paragraph.ALIGN_LEFT);

       Paragraph p = new Paragraph("OFÍCIO CENOP SJ N.º " + of.getOficio()+" BACENJUD SOL ", Arial10N);
        // Setando o alinhamento p/ o centro
        p.setAlignment(Paragraph.ALIGN_LEFT);

        System.out.println(of.getDestinario());

        Paragraph pdestinatario = new Paragraph( of.getEndereco(), Arial8);
        // Setando o alinhamento p/ o centro
        pdestinatario.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph p1 = new Paragraph("ENDEREÇO PARA DEVOLUÇÃO DO AR ", Arial10N);
        // Setando o alinhamento p/ o centro
        p1.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph p2 = new Paragraph("Banco do Brasil S.S\n"
                + "Serviços Judiciais – Ofícios\n"
                + "Rua Boa Vista, 254 – 14º andar\n"
                + "CEP: 01014-907\n"
                + "São Paulo - SP", Arial8);
        // Setando o alinhamento p/ o centro
        p2.setAlignment(Paragraph.ALIGN_LEFT);

        String endereco;
        endereco = of.getEndereco();
        endereco = tabulacaoDoTexto(endereco);

        Paragraph pdendereco = new Paragraph("" + endereco, Arial8);
        // Setando o alinhamento p/ o centro
        pdendereco.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(linhaBranca);
        document.add(linhaBranca);
        document.add(linhaBranca);
        document.add(linhaBranca);
        document.add(linhaBranca);
        document.add(p);
        document.add(pdestinatario);

        document.add(linhaBranca);
        document.add(p1);
        document.add(p2);
        document.add(linhaBranca);
        document.add(linhaBranca);
        document.add(linhaBranca);
        document.add(linhaBranca);
        document.add(linhaBranca);
        document.add(linhaBranca);
        document.add(linhaBranca);
        document.add(linhaBranca);
        document.add(linhaBranca);
        document.add(linhaBranca);

        document.add(p);

        document.add(pdestinatario);

        document.close();          
     
    //        Process k = Runtime.getRuntime().exec("cmd.exe /C c:\\temp\\ARF.pdf");        

    }

    private String tabulacaoDoTexto(String line) {
        String[] tokens = line.split("\t");
        String correctionString = "";
        for (int i = 0; i < tokens.length - 1; i++) {
            correctionString += tokens[i];

            if (tokens[i].trim().equals("")) {
                correctionString += emptyString(8);
            } else {
                correctionString += emptyString(8 - (tokens[i].length() % 8));
            }
        }
        correctionString += tokens[tokens.length - 1];
        System.out.println(correctionString);
        return correctionString;
    }

    private String emptyString(int size) {
        String format = "";
        for (int i = 0; i < size; i++) {
            format += " ";
        }
        return format;
    }

    static class HeaderFooter extends PdfPageEventHelper {

        public void onEndPage(PdfWriter writer, Document document) {

            //FONTES
            FontFactory.register("c:\\windows\\fonts\\arial.ttf");
            FontFactory.register("c:\\windows\\fonts\\arialbd.ttf");

            //Arial 6
            Font Arial6 = new Font(FontFactory.getFont("arial"));
            Arial6.setSize(6);

            //Arial 8
            Font Arial8 = new Font(FontFactory.getFont("arial"));
            Arial8.setSize(8);

            Font Arial8N = new Font(FontFactory.getFont("arial"));
            Arial8N.setSize(8);
            Arial8N.setStyle("bold");

            //Arial 10
            Font Arial10 = new Font(FontFactory.getFont("arial"));
            Arial10.setSize(10);

            Font Arial10N = new Font(FontFactory.getFont("arial"));
            Arial10N.setSize(10);
            Arial10N.setStyle("bold");

            //Arial 12
            Font Arial12 = new Font(FontFactory.getFont("arial"));
            Arial12.setSize(12);

            Font Arial12N = new Font(FontFactory.getFont("arial"));
            Arial12N.setSize(12);
            Arial12N.setColor(BaseColor.BLACK);
            Arial12N.setStyle("bold");

            //Arial 14
            Font Arial14 = new Font(FontFactory.getFont("arial"));
            Arial14.setSize(14);

            Font Arial14N = new Font(FontFactory.getFont("arial"));
            Arial14N.setSize(14);
            Arial14N.setStyle("bold");

            //Arial 16
            Font Arial16 = new Font(FontFactory.getFont("arial"));
            Arial16.setSize(16);

            Font Arial16N = new Font(FontFactory.getFont("arial"));
            Arial16N.setSize(16);
            Arial16N.setStyle("bold");

            Rectangle rect = writer.getBoxSize("art");

            //Cabeçalho
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_RIGHT, new Phrase("OFICIO CENOP SJ N.º : " + Oficio, Arial10N),
                    rect.getRight() + 370, rect.getTop(), 0);

            System.out.println(Oficio);
            System.out.println(AOF);

            if ("".equals(AOF)) {
                ColumnText.showTextAligned(writer.getDirectContent(),
                        Element.ALIGN_RIGHT, new Phrase(Data, Arial10),
                        rect.getRight() + 370, rect.getTop() - 15, 0);
            } else {
                ColumnText.showTextAligned(writer.getDirectContent(),
                        Element.ALIGN_RIGHT, new Phrase("AOF :" + AOF, Arial10N),
                        rect.getRight() + 370, rect.getTop() - 15, 0);
                ColumnText.showTextAligned(writer.getDirectContent(),
                        Element.ALIGN_RIGHT, new Phrase(Data, Arial10),
                        rect.getRight() + 370, rect.getTop() - 30, 0);
            }

            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_RIGHT, new Phrase("  ", Arial12),
                    rect.getRight() + 200, rect.getTop() - 45, 0);
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_RIGHT, new Phrase("  ", Arial12),
                    rect.getRight() + 200, rect.getTop() - 60, 0);
//Rodapé            
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase("______________________________________________"
                            + "________________________________", Arial10N),
                    (rect.getLeft() + rect.getRight()) + 65, rect.getBottom() - 0, 0);
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase("CENOP SERVIÇOS Judiciais SÃO PAULO/SP", Arial8N),
                    (rect.getLeft() + rect.getRight()) + 70, rect.getBottom() - 15, 0);
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase("Rua Boa Vista, 254, 14º andar - Centro - CEP 01014-000 - São Paulo-SP", Arial8),
                    (rect.getLeft() + rect.getRight()) + 80, rect.getBottom() - 28, 0);
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase(Abc.toUpperCase(), Arial6),
                    (rect.getLeft() + rect.getRight()) + 300, rect.getBottom() - 32, 0);
        }
    }
}
