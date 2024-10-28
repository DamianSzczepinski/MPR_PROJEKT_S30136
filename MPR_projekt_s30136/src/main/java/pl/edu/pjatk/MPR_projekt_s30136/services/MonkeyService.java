package pl.edu.pjatk.MPR_projekt_s30136.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjatk.MPR_projekt_s30136.model.Monkey;
import pl.edu.pjatk.MPR_projekt_s30136.repository.MonkeyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MonkeyService {

    private final MonkeyRepository monkeyRepository;
    private final StringUtilsService stringUtilsService;

    @Autowired
    public MonkeyService(MonkeyRepository repository, StringUtilsService stringUtilsService) {
        this.monkeyRepository = repository;
        this.stringUtilsService = stringUtilsService;


        this.monkeyRepository.save(new Monkey("Wladziu", "gray"));
        this.monkeyRepository.save(new Monkey("Damian", "green"));
        this.monkeyRepository.save(new Monkey("Kuba", "blue"));
    }

    public void addMonkey(Monkey monkey) {
        monkey.setName(stringUtilsService.toUpperCase(monkey.getName()));
        monkey.setColor(stringUtilsService.toUpperCase(monkey.getColor()));
        this.monkeyRepository.save(monkey);
    }

    public List<Monkey> getAllMonkeys() {
        List<Monkey> monkeys = new ArrayList<>();
        monkeyRepository.findAll().forEach(monkey -> {
            monkey.setName(stringUtilsService.toCapitalized(monkey.getName()));
            monkey.setColor(stringUtilsService.toCapitalized(monkey.getColor()));
            monkeys.add(monkey);
        });
        return monkeys;
    }

    public Optional<Monkey> getMonkey(Integer id) {
        Optional<Monkey> monkey = monkeyRepository.findById(id);
        monkey.ifPresent(m -> {
            m.setName(stringUtilsService.toCapitalized(m.getName()));
            m.setColor(stringUtilsService.toCapitalized(m.getColor()));
        });
        return monkey;
    }

    public void deleteMonkey(int id) {
        this.monkeyRepository.deleteById(id);
    }

    public List<Monkey> getbyName(String name) {
        return monkeyRepository.findByName(name);
    }
}
