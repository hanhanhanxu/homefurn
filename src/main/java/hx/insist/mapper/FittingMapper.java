package hx.insist.mapper;

import hx.insist.Vo.FittingDetail;
import hx.insist.pojo.Fitting;
import hx.insist.pojo.FittingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FittingMapper {
    int countByExample(FittingExample example);

    int deleteByExample(FittingExample example);

    int deleteByPrimaryKey(String fid);

    int insert(Fitting record);

    int insertSelective(Fitting record);

    List<Fitting> selectByExample(FittingExample example);

    Fitting selectByPrimaryKey(String fid);

    int updateByExampleSelective(@Param("record") Fitting record, @Param("example") FittingExample example);

    int updateByExample(@Param("record") Fitting record, @Param("example") FittingExample example);

    int updateByPrimaryKeySelective(Fitting record);

    int updateByPrimaryKey(Fitting record);

    List selectAll();

    List fingByFtype(String type);

    List fingByFstyle(String fstyle);

    List fingByCondition(String type, String style);

    String selectFimgByFid(String fid);

    int updateFsvolumeBySid(String fid);

    List selectForRank();

    List selectByFname(String fname);

    List selectTop(int num);

    FittingDetail connSelectByFid(String fid);

    int updateFsignByFid(String fid);
}