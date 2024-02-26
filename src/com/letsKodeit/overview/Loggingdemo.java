package com.letsKodeit.overview;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Loggingdemo {
	private static final Logger log = LogManager.getLogger(Loggingdemo.class.getName());
	public static void main(String args[]){
		log.trace("Trace Message Prited");
		log.debug("Debug Message Printed");
		log.info("Info Message Printed");
		log.error("Error Message Printed");
		log.fatal("Fatal Message Printed");
	}
}
