package org.independent.xlsreader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Slf4j

@Component
public class CmdRunner implements CommandLineRunner{

    @Override
    public void run(String[] args) throws Exception {
      log.info("Enter to cmdRunner.");

      if (args.length > 0) 
      {
        log.info( "Argument <{}>", args[0] );  
        XlsProcessor.processExcelFile(args[0]);
      }
      log.info("Exit from cmdRunner.");
    }
}
