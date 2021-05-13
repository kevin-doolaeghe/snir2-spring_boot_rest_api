package fr.kevin.spring.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    TeacherRepository teachersRepo;

    @RequestMapping(method = RequestMethod.GET, path = "/teacher/list")
    public List getTeacher(){
        return teachersRepo.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/teacher/create")
    public void create(Teacher t){
        if(!teachersRepo.existsById(t.id)) {
            teachersRepo.save(t);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/teacher/delete")
    public void delete(Teacher t){
        if(teachersRepo.existsById(t.id)) {
            teachersRepo.delete(t);
        }
    }

    @RequestMapping(method = RequestMethod.PATCH, path = "/teacher/update")
    public void update(Teacher t){
        if(teachersRepo.existsById(t.id)) {
            teachersRepo.save(t);
        }
    }
}