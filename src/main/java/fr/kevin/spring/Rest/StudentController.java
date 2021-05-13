package fr.kevin.spring.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentsRepo;

    @RequestMapping(method = RequestMethod.GET, path = "/student/list")
    public List getStudents(){
        return studentsRepo.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/student/create")
    public void create(Student s){
        if(!studentsRepo.existsById(s.id)) {
            studentsRepo.save(s);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/student/delete")
    public void delete(Student s){
        if(studentsRepo.existsById(s.id)) {
            studentsRepo.delete(s);
        }
    }

    @RequestMapping(method = RequestMethod.PATCH, path = "/student/update")
    public void update(Student s){
        if(studentsRepo.existsById(s.id)) {
            studentsRepo.save(s);
        }
    }
}
