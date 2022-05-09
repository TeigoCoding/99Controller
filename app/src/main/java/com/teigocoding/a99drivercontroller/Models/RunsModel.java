package com.teigocoding.a99drivercontroller.Models;

public class RunsModel {
    private int _ID;
    private String _data;
    private double _valor;
    private String _bonus;

    public RunsModel(int _ID, String _data, double _valor, String _bonus) {
        this._ID = _ID;
        this._data = _data;
        this._valor = _valor;
        this._bonus = _bonus;
    }

    @Override
    public String toString() {
        return "RunsModel{" +
                "_ID=" + _ID +
                ", _data='" + _data + '\'' +
                ", _valor=" + _valor +
                ", _bonus='" + _bonus + '\'' +
                '}';
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String get_data() {
        return _data;
    }

    public void set_data(String _data) {
        this._data = _data;
    }

    public double get_valor() {
        return _valor;
    }

    public void set_valor(double _valor) {
        this._valor = _valor;
    }

    public String get_bonus() {
        return _bonus;
    }

    public void set_bonus(String _bonus) {
        this._bonus = _bonus;
    }
}

