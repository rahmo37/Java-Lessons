import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.swing.ImageIcon;

public class GoogleApi {
	public void downloadMap(String location) {
		try {
			String imageURL = "https://maps.googleapis.com/maps/api/staticmap?center="
		+ URLEncoder.encode(location, "UTF-8") 
		+ "&zoom=15&size=623x623&maptype=roadmap&markers=color:red%7Clabel:S%7C" + URLEncoder.encode(location, "UTF-8") +
		"&key=AIzaSyBfMk0sJN3rHdP0qRwTk_LRhSn0g2jTc8I";
			URL url = new URL(imageURL);
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream(location);
			byte[] b = new byte[2048];
			int length;
			while((length = is.read(b)) !=-1) {
				os.write(b,0,length);
			}
			is.close();
			os.close();
		} catch(Exception e) {
			
		}
	}
	
	public ImageIcon getMap(String location) {
		return new ImageIcon((new ImageIcon(location))
				.getImage()
				.getScaledInstance(612, 612, java.awt.Image.SCALE_SMOOTH));
	}
	
	public void fileDelete(String fileName) {
		File f = new File(fileName);
		f.delete();
	}
}
