package gob.imss.necesaif.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthCheck")
public class AppController {
	
private final static Logger logger = Logger.getLogger(AppController.class);
	
	@GetMapping()
	public String healthz () {
		logger.info("Active");
		return "ok";
	}

}
