package com.example.run;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.run.model.Employee;
import com.example.run.repository.EmpoloyeeRepository;

@SpringBootApplication
public class BackEndSpringBootApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BackEndSpringBootApplication.class, args);
	}
	
	@Autowired
	private EmpoloyeeRepository empoloyeeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Hung", "To Ngoc", "hungtn@gmail.com"));
		employees.add(new Employee("Chi", "Bac Ngoc", "hsss@gmail.com"));
		employees.add(new Employee("Bao", "Hao Ngoc", "abc@gmail.com"));
		employees.add(new Employee("Binh", "Le Ngoc", "hu2@gmail.com"));
		employees.add(new Employee("Khanh", "TL Ngoc", "hung333tn@gmail.com"));
		empoloyeeRepository.saveAll(employees);
	}

}
