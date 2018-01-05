package foodGroup4Quanly.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletContext;

import foodGroup4Quanly.entity.Chinhanh;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.multipart.MultipartFile;

public class Utils {

	public static void saveImage(MultipartFile file, ServletContext context, String directory) {
		try{
	    		byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String uploadPath = directory;
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

	public static Date parseDate(String str, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Chinhanh getChinhanhHienTai() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof AccountAdminUserDetails){
			Chinhanh cn = ((AccountAdminUserDetails)principal).getAccountAdmin().getChinhanh();
			return cn;
		}
		return null;
	}

	public static Calendar convertDateToCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

}
