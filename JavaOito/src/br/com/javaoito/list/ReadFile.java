package br.com.javaoito.list;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.javaoito.list.vo.Person;

public class ReadFile {
	
	private final static String PATH_FILE = "resource/input.csv";
	
	public List<Person> readFile() throws IOException {
		
		Path path = Path.of(PATH_FILE);
		
		Stream<String> linhas = Files.lines(path, StandardCharsets.ISO_8859_1);
		
		List<String> peopleList = linhas.collect(Collectors.toList());
		
		return populatePerson(peopleList);
	}
	
	private List<Person> populatePerson(List<String> personList) {
		
		Iterator it = personList.listIterator();
		
        String str = null;
        
        List<Person> people = new ArrayList<Person>();
        
        while (it.hasNext()) {

        	Person person = new Person();
        	
        	str = (String) it.next();

            String info[]  = str.split(",");
            
            person.setName(info[0]);
            person.setAge(Integer.valueOf(info[1]));
            person.setEmail(info[2]);
            person.setCity(info[3]);
			
            people.add(person);
		}
		
		return people;
	}

}
