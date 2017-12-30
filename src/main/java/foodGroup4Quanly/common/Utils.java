package foodGroup4Quanly.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;

import org.springframework.web.multipart.MultipartFile;

public class Utils {

	public static void saveImage(MultipartFile file, ServletContext context, String directory) {
		try{
	    		byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String uploadPath = context.getRealPath("") + File.separator
						+ directory;
				File dir = new File(uploadPath);

				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				System.out.println("Server File Location="
						+ serverFile.getAbsolutePath());
				String filepath = "/" + directory + "/"
						+ file.getOriginalFilename();
		}catch(Exception e){

    		}
	}
}
