package hx.insist.mapper;

import hx.insist.pojo.FittingStock;
import hx.insist.pojo.FittingStockExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FittingStockMapper {
    int countByExample(FittingStockExample example);

    int deleteByExample(FittingStockExample example);

    int insert(FittingStock record);

    int insertSelective(FittingStock record);

    List<FittingStock> selectByExample(FittingStockExample example);

    int updateByExampleSelective(@Param("record") FittingStock record, @Param("example") FittingStockExample example);

    int updateByExample(@Param("record") FittingStock record, @Param("example") FittingStockExample example);

    int updateFsnumByFid(String fid);
}