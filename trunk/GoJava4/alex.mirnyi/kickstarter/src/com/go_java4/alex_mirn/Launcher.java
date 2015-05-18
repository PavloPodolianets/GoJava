package com.go_java4.alex_mirn;

import java.io.IOException;


import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.data.Quote;
import com.go_java4.alex_mirn.data_containers.CategoriesContainer;
import com.go_java4.alex_mirn.data_containers.ProjectsContainer;
import com.go_java4.alex_mirn.data_containers.QuotesContainer;
import com.go_java4.alex_mirn.input_output.printers.ConsolePrinter;
import com.go_java4.alex_mirn.input_output.printers.Printer;
import com.go_java4.alex_mirn.input_output.readers.ConsoleReader;
import com.go_java4.alex_mirn.input_output.readers.Reader;
import com.go_java4.alex_mirn.logic.CategoriesLogic;


public class Launcher {
	public static void main(String[] args) throws IOException {
		QuotesContainer quotes = new QuotesContainer();
		quotes.add(new Quote("Impossible is nothing"));
		quotes.add(new Quote("Smile makes you better"));
		quotes.add(new Quote("Impossible is nothing"));

		Category medicine = new Category("Medicine");
		Category music = new Category("Music");
		CategoriesContainer categories = new CategoriesContainer();
		categories.add(medicine);
		categories.add(music);

		Project alcoTester = new Project(medicine, "Alco Tester",
				"Phenomenal alco test just by scanning your eyes", 50000,
				23000, 15);
		alcoTester.setHistory("Far-far away...");
		alcoTester.setVideoLink("verbohlest.narod.ru");
		alcoTester.setQuestions("what?");
		Project eyes = new Project(medicine, "Eyes training device",
				"Get 100% sight", 100000, 15000, 24);
		Project melody = new Project(music, "Sing Melody",
				"Sing melody and hear how it sounds in "
						+ "different musical instruments", 15000, 22000, 110);
		ProjectsContainer projects = new ProjectsContainer();
		projects.add(alcoTester);
		projects.add(eyes);
		projects.add(melody);

		CategoriesLogic categoriesLogic = new CategoriesLogic(new ConsolePrinter(),
				new ConsoleReader(), quotes, categories, projects); 
		categoriesLogic.run();
	}

}