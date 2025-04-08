package dev.courses.controller;

import dev.courses.model.DataBaseSequence;
import dev.courses.model.Student;
import dev.courses.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@RestController
public class MainController {

@Autowired
StudentRepo studentRepo;
@Autowired
private MongoOperations mongoOperations;


    public long generateSequence(String seqName) {
        DataBaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                DataBaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }

    @PostMapping("/addStudent")//adding to a database is called posting
    public void addStudent(@RequestBody Student student){
        Student student1 = new Student();
        student1.setRno(generateSequence(student.SEQUENCE_NAME));
        student1.setAddress(student.getAddress());
        student1.setName(student.getName());
        studentRepo.save(student1);
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
        Student data = studentRepo.findById((int) student.getRno()).orElse(null);
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
