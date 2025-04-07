package dev.courses.controller;

import dev.courses.model.Student;
import dev.courses.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

@Autowired
StudentRepo studentRepo;

    @PostMapping("/addStudent")//adding to a database is called posting
    public void addStudent(@RequestBody Student student){
        studentRepo.save(student);
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentRepo.findById(id).orElse(null);
    }

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    @PutMapping("/updateStudent")//adding to a database is called posting
    public void updateStudent(@RequestBody Student student){
        //fetch student by id
        Student data = studentRepo.findById(student.getRno()).orElse(null);
        System.out.println(data);

        //check if null
        if (data != null){

            //update with the requested data

            data.setName(student.getName());
            data.setAddress(student.getAddress());
            studentRepo.save(data);
        }
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Integer id){
        studentRepo.deleteById(id);
    }

    @PostMapping("/addManyStudent")//adding to a database is called posting
    public void addManyStudent(@RequestBody List<Student> student){
        studentRepo.saveAll(student);
    }
}
