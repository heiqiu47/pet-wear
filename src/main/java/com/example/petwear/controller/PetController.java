package com.example.petwear.controller;

import com.example.petwear.pojo.model.Pet;
import com.example.petwear.service.Impl.PetServiceImpl;
import com.example.petwear.utils.Result;
import com.example.petwear.utils.ResultGenerator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qiu
 */
@RestController
@RequestMapping
public class PetController {

    private final PetServiceImpl petService;

    public PetController(PetServiceImpl petService) {
        this.petService = petService;
    }

    @GetMapping("{userId}/pet")
    public Result<Object> selPetList(@PathVariable int userId, @RequestHeader String token) {
        Result<Object> result;
        List<Pet> pets = petService.selPetList(userId, token);
        if (pets != null) {
            result = ResultGenerator.genSuccessResult("查询成功", pets);
        } else {
            result = ResultGenerator.genErrorResult("查询失败");
        }
        return result;
    }

    @GetMapping("{userId}/pet/{petId}")
    public Result<Object> selPetInfo(@PathVariable int userId, @PathVariable int petId, @RequestHeader String token) {
        Result<Object> result;
        Pet pet = petService.selPetInfo(userId, petId, token);
        if (pet != null) {
            result = ResultGenerator.genSuccessResult("查询成功", pet);
        } else {
            result = ResultGenerator.genErrorResult("查询失败");
        }
        return result;
    }

    @PatchMapping("{userId}/pet/{petId}")
    public Result<Object> updatePet(@PathVariable int userId, @PathVariable int petId, Pet pet, @RequestHeader String token) {
        Result<Object> result;
        pet.setPetId(petId);
        pet.setMasterId(userId);
        int i = petService.updatePet(pet, token);
        if (i != 0) {
            result = ResultGenerator.genSuccessResult("更新成功");
        } else {
            result = ResultGenerator.genErrorResult("更新失败");
        }
        return result;
    }

    @PostMapping("{userId}/pet/add")
    public Result<Object> addPet(@PathVariable int userId,Pet pet, @RequestHeader String token) {
        Result<Object> result;
        pet.setMasterId(userId);
        int i = petService.addPet(pet, token);
        if (i != 0) {
            result = ResultGenerator.genSuccessResult("创建成功");
        } else {
            result = ResultGenerator.genErrorResult("创建失败");
        }
        return result;
    }

}
