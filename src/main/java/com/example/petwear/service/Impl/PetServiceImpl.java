package com.example.petwear.service.Impl;

import cn.dev33.satoken.stp.StpUtil;
import com.example.petwear.mapper.PetMapper;
import com.example.petwear.pojo.model.Pet;
import com.example.petwear.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 */
@Service
public class PetServiceImpl implements PetService {

    private final PetMapper petMapper;

    public PetServiceImpl(PetMapper petMapper) {
        this.petMapper = petMapper;
    }

    @Override
    public List<Pet> selPetList(int userId, String token) {
        List<Pet> pets = null;
        Object tokenId = StpUtil.getLoginIdByToken(token);
        if (tokenId != null && tokenId.equals(String.valueOf(userId))) {
            pets = petMapper.selPetList(userId);
        }
        return pets;
    }

    @Override
    public Pet selPetInfo(int userId, int petId, String token) {
        Pet pet = null;
        Object tokenId = StpUtil.getLoginIdByToken(token);
        if (tokenId != null && tokenId.equals(String.valueOf(userId))) {
            pet = petMapper.selPetInfo(userId, petId);
        }
        return pet;
    }

}
