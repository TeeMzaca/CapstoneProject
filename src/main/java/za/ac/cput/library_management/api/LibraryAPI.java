package za.ac.cput.library_management.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.library_management.domain.Library;
import za.ac.cput.library_management.factory.LibraryFactory;
import za.ac.cput.library_management.service.LibraryService;
import za.ac.cput.library_management.service.impl.LibraryServiceImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Component
public class LibraryAPI {

    private LibraryServiceImpl libraryService;

    @Autowired
    LibraryAPI(LibraryServiceImpl libraryService) {
        this.libraryService = libraryService;
    }

    //Get Names
    public List<String> getLibraryNames() {

        List<Library> libraries = libraryService.getAll();
        List<String> names = new LinkedList<>();

        for (Library library : libraries) {names.add(library.getName());}

        if (names.isEmpty()) {return null;}
        else {return names;}
    }

    //Get All
    public List<Library> getLibraries() {return libraryService.getAll();}

    //Add library to DB
    public void addLibrary(String id, String name, String address, String tel) {
        Library library = LibraryFactory.createLibrary(id, name, address, tel);
        libraryService.save(library);
    }

    //Remove library from DB
    public Boolean deleteLibraryById(String id) {
        return libraryService.delete(id);
    }

    //Find library by name
    public Library getLibraryByName(String name) {
        List<Library> libraries = libraryService.getAll();
        Library result = null;

        for (Library library : libraries) {if (Objects.equals(library.getName(), name)) {result = library;}}

        return result;
    }
}
