package com.example.petwear.mapper;

import com.example.petwear.pojo.model.Pet;
import com.example.petwear.pojo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qiu
 */
@Mapper
@Repository
public interface PetMapper {

    /**
     * 获取宠物列表
     *
     * @param masterId 主人id
     * @return 宠物列表
     */
    List<Pet> selPetList(int masterId);

    /**
     * 宠物信息
     *
     * @param masterId 主人id
     * @param petId    宠物id
     * @return 宠物信息
     */
    Pet selPetInfo(int masterId, int petId);


    int updatePet(Pet pet);

}
