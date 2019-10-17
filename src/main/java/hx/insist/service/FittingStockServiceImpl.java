package hx.insist.service;

import hx.insist.mapper.FittingStockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FittingStockServiceImpl implements FittingStockService {
    @Autowired
    private FittingStockMapper fittingStockMapper;

    @Override
    public void reduceByFid(String fid) {
        fittingStockMapper.updateFsnumByFid(fid);
    }
}
