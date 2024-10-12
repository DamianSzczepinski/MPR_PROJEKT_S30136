package pl.edu.pjatk.MPR_projekt_s30136.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.MPR_projekt_s30136.model.Monkey;
import pl.edu.pjatk.MPR_projekt_s30136.services.MonkeyService;

import java.util.List;
@RestController

public class MyRestController {
    private MonkeyService monkeyService;

    @Autowired
    public MyRestController(MonkeyService monkeyService) {
        this.monkeyService = monkeyService;
    }

    @GetMapping("monkey/all")
    public List<Monkey> getAll() {
        return this.monkeyService.getMonkeyList();
    }

    @GetMapping("monkey/{id}")
    public Monkey get(@PathVariable Integer id) {
        return this.monkeyService.getMonkey(id);
    }

    @PostMapping("monkey")
    public void addMonkey(@RequestBody Monkey monkey) {
        this.monkeyService.add(monkey);
    }

    @DeleteMapping("monkey/{id}")
        public void deleteMonkey(@PathVariable int id){
            this.monkeyService.delete(id);
    }
    @PutMapping("monkey/{id}")
    public void updateMonkey(@PathVariable int id, @RequestBody Monkey monkey){
        this.monkeyService.update(id,monkey);
    }

}
