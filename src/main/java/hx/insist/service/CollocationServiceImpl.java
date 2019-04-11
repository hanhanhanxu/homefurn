package hx.insist.service;

import hx.insist.Vo.CollocationVo;
import hx.insist.mapper.CollocationMapper;
import hx.insist.mapper.FittingMapper;
import hx.insist.mapper.SuitMapper;
import hx.insist.pojo.Collocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CollocationServiceImpl implements CollocationService {

    @Autowired
    private CollocationMapper collocationMapper;
    @Autowired
    private SuitMapper suitMapper;
    @Autowired
    private FittingMapper fittingMapper;

    @Override
    public void addCollocation(Collocation collocation) {
        collocation.setCid(UUID.randomUUID().toString());
        collocationMapper.insert(collocation);
        suitMapper.updateSprice(collocation.getSid(),collocation.getFprice());//将Suit表总价增加
    }

    @Override
    public void delCollocation(String cid) {
        Collocation collocation = collocationMapper.selectByPrimaryKey(cid);
        BigDecimal fprice1 = collocation.getFprice();
        System.out.println("原价:"+fprice1);
        BigDecimal fprice = fprice1.subtract(fprice1.multiply(new BigDecimal(2)));
        System.out.println("参数价格:"+fprice);
        suitMapper.updateSprice(collocation.getSid(),fprice);
        collocationMapper.deleteByPrimaryKey(cid);

    }

    //查找出来的是CollocationVo  比Collocation多了一个img可以正常当Collocation使用，增强版Collocation，所以这个方法对以前的需求还是正常使用
    @Override
    public List findCollocationBySid(String sid) {
        List<Collocation> list = collocationMapper.selectCollocationBySid(sid);
        if(list.isEmpty())
            return null;
        else{
            List<CollocationVo> voList = new ArrayList<>();
            for(Collocation collocation:list){
                String fimg = fittingMapper.selectFimgByFid(collocation.getFid());
                CollocationVo collocationVo = new CollocationVo();
                collocationVo.setCid(collocation.getCid());
                collocationVo.setSid(collocation.getSid());
                collocationVo.setFid(collocation.getFid());
                collocationVo.setFname(collocation.getFname());
                collocationVo.setFimg(fimg);
                collocationVo.setFprice(collocation.getFprice());
                voList.add(collocationVo);
            }
            return voList;
        }

    }
}
