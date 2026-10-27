package br.com.dio.singleton;

/**
 * Singleton "preguiçoso" com Holder (subclasse responsável por criar a instância)
 * 
 * Referência: <a href="http://stackoverflow.com/a/24018148">Link</a>
 */
public class SingletonLazyHolder {

    public static class InstanceHolder {
        public static SingletonLazyHolder instancia = new SingletonLazyHolder();
    }

    private SingletonLazyHolder() {
        super();
    }

    public static SingletonLazyHolder getInstancia() {
        return InstanceHolder.instancia;
    }

    

}
