package com.example.petwear.service;

import com.example.petwear.pojo.model.Pet;
import com.example.petwear.pojo.model.User;

import java.util.List;

/**
 * @author qiu
 */
public interface PetService {

    List<Pet> selPetList(int userId, String token);

    Pet selPetInfo(int userId, int petId, String token);

    int updatePet(Pet pet, String token);

    int addPet(Pet pet, String token);

}
