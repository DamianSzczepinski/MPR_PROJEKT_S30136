package pl.edu.pjatk.MPR_projekt_s30136.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.MPR_projekt_s30136.model.Monkey;
import pl.edu.pjatk.MPR_projekt_s30136.services.MonkeyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/monkey")
public class MyRestController {

    private final MonkeyService monkeyService;

    @Autowired
    public MyRestController(MonkeyService monkeyService) {
        this.monkeyService = monkeyService;
    }

    @GetMapping("/name/{name}")
    public List<Monkey> getMonkeyByName(@PathVariable String name) {
        return this.monkeyService.getbyName(name);
    }

    @GetMapping("/all")
    public List<Monkey> getAll() {
        return this.monkeyService.getAllMonkeys();
    }

    @GetMapping("/{id}")
    public Optional<Monkey> get(@PathVariable Integer id) {
        return this.monkeyService.getMonkey(id);
    }

    @PostMapping
    public void addMonkey(@RequestBody Monkey monkey) {
        this.monkeyService.addMonkey(monkey);
    }

    @DeleteMapping("/{id}")
    public void deleteMonkey(@PathVariable int id) {
        this.monkeyService.deleteMonkey(id);
    }
}
