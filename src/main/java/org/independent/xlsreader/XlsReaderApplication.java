package org.independent.xlsreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

@Slf4j

@SpringBootApplication
public class XlsReaderApplication {
	public static void main(String[] args) {
		log.info("Hello!");
		SpringApplication.run(XlsReaderApplication.class, args);
	}
}
