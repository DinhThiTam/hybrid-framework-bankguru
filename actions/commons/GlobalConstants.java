package commons;

import java.io.File;

public class GlobalConstants {
	public static final String DEV_APP_URL = "https://demo.nopcommerce.com";
	public static final String STAGING_APP_URL = "https://staging.nopcommerce.com";
	public static final String TESTING_APP_URL = "https://test.nopcommerce.com";

	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FOLDER_PATH = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FOLDER_PATH = PROJECT_PATH + "\\downloadFiles";

	public static final String EMAIL_ADDRESS_ADMIN_NOPCOMERCE = "admin@yourstore.com";
	public static final String PASSWORD_ADMIN_NOPCOMERCE = "admin";

	public static final String AUTOMATE_USERNAME = "tamdinh_bcXWjn";
	public static final String AUTOMATE_ACCESS_KEY = "Ug5xcrECBCcQKozVfRBL";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";
	
	public static final String SAUCELAB_USERNAME = "oauth-dinhtamk53thb-ca7cf";
	public static final String SAUCELAB_ACCESS_KEY = "7436ff62-7c4c-4131-98f8-312df034ae37";
	public static final String SAUCELAB_URL = "https://" + SAUCELAB_USERNAME + ":" + SAUCELAB_ACCESS_KEY + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";

}
