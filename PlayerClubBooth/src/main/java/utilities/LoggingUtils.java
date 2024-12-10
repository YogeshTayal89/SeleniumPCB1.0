package utilities;



import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
 * Useful utility class for binary data logging (e.g. sending files to ReportPortal). You can disable console output for
 * `binary_data_logger` to avoid redundant verbose output.
 */
public class LoggingUtils {

	private static final Logger LOGGER =LoggerFactory.getLogger("logger");

	private LoggingUtils() {
		//statics only
	}

	public static void log(String message) {
		LOGGER.info(message);
	}
	
	public static void logError(String message) {
		LOGGER.error(message);
	}

	public static void logBase64(String base64, String message) {
		LOGGER.info("RP_MESSAGE#BASE64#{}#{}", base64, message);
	}

	public static void log(byte[] bytes, String message) {
		logBase64(Base64.getEncoder().encodeToString(bytes), message);
	}
}