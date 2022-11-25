package controller;


import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;
import repositories.UserRepository;
import java.util.List;
import java.util.Optional;

@RestController
public class TicketBookingController {

    //Ticket Booking System
    //Create,Find,Update,Delete
    @Autowired
    MongoTemplate mongoTemplate;

    //new line added here.

    @Autowired
    private UserRepository userRepository;

    //Create Ticket
    @PostMapping(value="/Tickets")
    public String CreateYourTicket(@RequestBody User user)
    {
        try
        {
            userRepository.save(user);
            return "Your Ticket Created "+user.getId();
        }
        catch(Exception e)
        {
            return "Your Ticket Not Created Yet Please Check Your System"+e;
        }


    }

    //Get All Tickets
    @GetMapping(value="/Tickets")
    public List<User> FindAllYourTickets()
    {
        List<User> users=null;
        try
        {
            users= userRepository.findAll();
            return users;
        }
        catch(Exception e)
        {
            return users;
        }

    }

    //Get Your Ticket
    @GetMapping(value="/Tickets/{id}")
    public Optional<User> FindYourTicket(@PathVariable String id)
    {
        Optional<User> userValue=null;
        try
        {
             userValue=userRepository.findById(id.trim());
            return userValue;
        }
        catch(Exception e)
        {
            return userValue;
        }

    }

    //Delete Your Ticket
    @DeleteMapping(value="/Tickets/{id}")
    public String DeleteYourTicket(@PathVariable String id)
    {
          try
           {
            userRepository.deleteById(id);
            return "Your Ticket Deleted";
           }
          catch(Exception e)
           {
               return "Your Ticket Not Deleted Yet Please Check Your System"+e;
           }

    }

    /*@GetMapping(value = "/api/{id}")
    public String Disp(@RequestHeader("disp") String val, @PathVariable int id, @RequestParam(value = "dispparam") String dispparam){
        System.out.println("Controller Start");
       if(userRepository.findAll().isEmpty())
        {
            userRepository.save(new User("Vivek","Sample"));
            userRepository.save(new User("Raghu","Sample1"));
        }
        for(User user:userRepository.findAll())
        {
            System.out.println("dbdata"+user);
        }


        return val+""+id+""+dispparam;
    }*/


}
