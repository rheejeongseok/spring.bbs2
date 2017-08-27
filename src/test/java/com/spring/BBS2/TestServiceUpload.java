package com.spring.BBS2;

import static org.junit.Assert.*;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.BBS2.model.ModelUploadImage;
import com.spring.BBS2.service.IServiceUpload;

import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.util.Base64;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceUpload {
    
    private static ApplicationContext context = null;
    private static IServiceUpload service = null;
    
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
        context= new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");
        service=context.getBean(IServiceUpload.class);
    }

    @Test
    public void test_insertPhoto() {   

        // convert image to byte
        
        try {
            File file = new File("src/test/resources/cafebene.png");
            BufferedImage originalImage = ImageIO.read(file.getAbsoluteFile());

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(originalImage, "jpg", baos);
            baos.flush();
            byte[] photoBytes = baos.toByteArray();
            
            ModelUploadImage fileupload = new ModelUploadImage();
            fileupload.setFileName( file.getName() );
            fileupload.setFileSize( file.length() );
            fileupload.setArticleno(619);
            fileupload.setContentType( Files.probeContentType( file.toPath() ) );
            fileupload.setImageBytes(photoBytes);
            fileupload.setImageBase64( Base64.getEncoder().encodeToString(baos.toByteArray()) );
            
            int result = service.insertPhoto(fileupload);
            
            assertNotSame(-1, result);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   /* @Test
    public void test_getImageByte() {
        
        // convert byte to image
        
        try {
            
            int attachfileno = 1;
            ModelUploadImage result = service.getImageByte(attachfileno);

            // convert byte array back to BufferedImage
            InputStream in = new ByteArrayInputStream( result.getImageBytes() );
            BufferedImage bImageFromConvert = ImageIO.read(in);

            File file = new File( "c:\\" + result.getFileName() );
            
            File dir = new File(file.getAbsolutePath());
            if (!dir.exists()) {
                dir.mkdir();
            }
           
            ImageIO.write(bImageFromConvert, FilenameUtils.getExtension(file.getName()), file );

            assertSame(1, result.getUploadImageNo() );
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    
    @Test
    public void testdeletePhoto(){
        
        int articleno = 625;
        int uploadImageNo = 2;
        
        int result = service.deletePhoto(articleno, uploadImageNo);
        
        assertEquals(result, 1);
        
        
    }
}
