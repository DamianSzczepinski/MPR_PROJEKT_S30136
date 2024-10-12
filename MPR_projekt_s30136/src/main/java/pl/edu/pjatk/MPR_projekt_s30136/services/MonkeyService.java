package pl.edu.pjatk.MPR_projekt_s30136.services;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import pl.edu.pjatk.MPR_projekt_s30136.model.Monkey;

import java.util.ArrayList;
import java.util.List;

@Component
public class MonkeyService {
    List<Monkey> monkeysList = new ArrayList<>();

    public MonkeyService(List<Monkey> monkeysList) {
        this.monkeysList.add(new Monkey("Damian", "bialy"));
        this.monkeysList.add(new Monkey("Kuba", "czarny"));
        this.monkeysList.add(new Monkey("Michal", "zielony"));
    }


    public List<Monkey> getMonkeyList() {
        return this.monkeysList;
    }

    public void add(Monkey monkey) {
        this.monkeysList.add(monkey);
    }

    public Monkey getMonkey(int id) {
        return this.monkeysList.get(id);
    }
    public void delete(int id){
        this.monkeysList.remove(id);
    }
    public void update(int id, Monkey monkey){
        this.monkeysList.set(id, monkey);
    }
}

