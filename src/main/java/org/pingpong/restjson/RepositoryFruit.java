package org.pingpong.restjson;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class RepositoryFruit implements PanacheRepository<Fruit> {

    public Set<Fruit> fruits = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public RepositoryFruit() {
        // CDI
    }

    public Set<Fruit> list() {
        return this.fruits;
    }

    public void add(Fruit fruit) {
        this.fruits.add(fruit);
    }

    public void remove(String name) {
        this.fruits.removeIf(existingFruit -> existingFruit.getName().contentEquals(name));
    }

    public Optional<Fruit> get(String name) {
        return this.fruits.stream().filter(f -> f.getName().equalsIgnoreCase(name)).findFirst();
    }
}
