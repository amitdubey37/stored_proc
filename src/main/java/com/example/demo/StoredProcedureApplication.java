package com.example.demo;

import com.example.demo.db.ExecuteProcedure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.sql.SQLException;

@SpringBootApplication
public class StoredProcedureApplication {

	public static void main(String[] args) throws SQLException, FileNotFoundException {
		SpringApplication.run(StoredProcedureApplication.class, args);
		ExecuteProcedure ex = new ExecuteProcedure();
		//ex.executeSelect();
		//ex.createProcedure();
		ex.executeProcedure();
	}
}
