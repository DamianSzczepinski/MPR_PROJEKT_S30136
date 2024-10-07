package pl.edu.pjatk.MPR_projekt_s30136.services;

import org.springframework.stereotype.Component;
import pl.edu.pjatk.MPR_projekt_s30136.model.Monkey;

import java.util.ArrayList;
import java.util.List;

@Component
public class MonkeyService {
    List<Monkey> monkeys = new ArrayList<>();

    public MonkeyService() {
        this.monkeys.add(new Monkey("Damian", "bialy"));
        this.monkeys.add(new Monkey("Kuba", "czarny"));
        this.monkeys.add(new Monkey("Michal", "zielony"));
    }


    public List<Monkey> getMonkeyList() {
        return this.monkeys;
    }

    public void add(Monkey monkey) {
        this.monkeys.add(monkey);
    }

    public Monkey getMonkey(int id) {
        return this.monkeys.get(id);
    }
}
