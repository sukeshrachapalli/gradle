package com.javatpoint.controllers;   
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;   
import com.javatpoint.beans.Student;  
import com.javatpoint.dao.StudDao;  
@Controller  
public class StudController {  
    @Autowired  
    StudDao dao;//will inject dao from xml file  
      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/studform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Student());
    	return "studform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("stud") Student stud){  
        dao.save(stud);  
        return "redirect:/viewstud";//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewstud")  
    public String viewstud(Model m){  
        List<Student> list=dao.getStudents();  
        m.addAttribute("list",list);
        return "viewstud";  
    }  
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editstud/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Student stud=dao.getStudById(id);  
        m.addAttribute("command",stud);
        return "studeditform";  
    }  
    /* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("stud") Student stud){  
        dao.update(stud);  
        return "redirect:/viewstud";  
    }  
    /* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deletestud/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/viewstud";  
    }   
}  