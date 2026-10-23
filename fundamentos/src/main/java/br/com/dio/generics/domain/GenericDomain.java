package br.com.dio.generics.domain;

public interface GenericDomain<T> {

    T getId();

    void setId(T id);
    
}
