package edu.birzeit.cocacola.application.controller;

import edu.birzeit.cocacola.application.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping("/coca-cola/git")
public class GitController {

    @RequestMapping(value = "/pull")
    public String refreshGit() {
        String result = null;
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "git pull");
        processBuilder.redirectErrorStream(true);
        processBuilder.directory(new File("C:\\Users\\dell\\Desktop\\CocaCola\\CocaCola"));
        try {
            Process process = processBuilder.start();
            BufferedReader inStreamReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line = inStreamReader.readLine();
            while(line != null){
                if(result == null)
                    result = line;
                else
                    result += line;
                line = inStreamReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

}
