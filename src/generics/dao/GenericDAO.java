package generics.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import generics.domain.GenericDomain;

public abstract class GenericDAO<ID, T extends GenericDomain<ID>> {

    private final List<T> db = new ArrayList<>();

    private T save(T domain) {
        db.add(domain);
        return domain;
    }

    public boolean save(int batch, T... domains) {
        System.out.printf("Salvando em lote (%s)\n",batch);
        return db.addAll(Arrays.stream(domains).toList());
    }

    public T update(T domain) {
        var stored = db.stream().filter(d -> d.getId().equals(domain.getId())).findFirst().orElseThrow();
        db.remove(stored);
        return save(domain);
    }

    public boolean delete(T domain) {
        return db.remove(domain);
    }

    public Optional<T> find(Predicate<T> predicateCallback) {
        return db.stream().filter(predicateCallback).findFirst();
    }

    public List<T> findAll() {
        return db;
    }

    public int count() {
        return db.size();
    }

}
