package utils;

import java.util.Date;

public class commonUtils {
	
	
        public static final int IMPLICITE_WAIT_TIME=10;	
        public static final int PAGE_LOAD_TIME=15;
		public static String  getEmailWithTimeStamp() {
		
		Date date = new Date();
		return "amotoori"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
		
	}

}
