package com.zzyl.mapper;

import com.zzyl.entity.Bed;
import com.zzyl.vo.BedVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BedMapper {

    List<BedVo> getBedsByRoomId(Long roomId);

    void createBed(Bed bed);

    /**
     * 根据id删除单个床位
     * @param id
     */
    @Delete("delete from bed where id=#{id}")
    void deleteBedById(Integer id);

    /**
     * 根据id查询单个床位
     * @param id
     * @return
     */
    @Select("select * from bed where id=#{id}")
    Bed findBedById(Integer id);

    /**
     * 根据id更新单个床位
     * @param bed
     */
    void updateBedById(Bed bed);
}

