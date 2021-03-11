package com.example.teach_me.controller;

import java.util.List;

public interface ICRUD<T> {

    public boolean incluir(T o);

    public boolean alterar(T o);

    public boolean deletar(int id);

    public List<T> listar();
}
