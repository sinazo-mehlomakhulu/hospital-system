package za.ac.cput.service;

import java.util.Optional;
/*
    IService.java
    Service Implementation for Services package
    Author: Fayaad Abrahams (218221630)
    Date: 12 August 2022
*/
public interface IService <T,ID>{
    T save (T t);
    T read(ID id);
    boolean delete(ID id);
}
