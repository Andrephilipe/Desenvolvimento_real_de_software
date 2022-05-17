package com.acc.twootr;

import java.util.Optional;

public interface AbstractRepository {

    void add(T value);

    Optional<T> get(String id);

    void update(T value);

    void delete(T value);
}
