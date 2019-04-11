package hx.insist.dao;

import hx.insist.pojo.Fitting;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository("FittingDao")
public class FittingDaoImpl implements FittingDao {

    @Autowired
    private SolrServer solrServer;


    @Override
    public List queryOverall(String str) {
        //创建一个query对象
        SolrQuery query = new SolrQuery();
        //设置查询条件
        query.setQuery("fitting_fname:"+str);
        //设置默认搜索域
        query.set("df", "product_keywords");
        //执行查询
        QueryResponse queryResponse = null;
        try {
            queryResponse = solrServer.query(query);
        } catch (SolrServerException e) {
            System.out.println("FittingDaoImpl:queryOverall方法发生异常:queryResponse = solrServer.query(query);");
            e.printStackTrace();
        }
        //取查询结果
        SolrDocumentList solrDocumentList = queryResponse.getResults();
        List list = new ArrayList();
        //共查询到商品数量
        //System.out.println("共查询到商品数量:" + solrDocumentList.getNumFound());
        //遍历查询的结果
        for (SolrDocument solrDocument : solrDocumentList) {
             System.out.println(solrDocument.get("id"));
            System.out.println(solrDocument.get("fitting_fname"));
            System.out.println(solrDocument.get("fitting_fprice"));
            System.out.println(solrDocument.get("fitting_fimg"));

            Fitting fitting = new Fitting();
            fitting.setFid((String) solrDocument.get("id"));
            fitting.setFname((String)solrDocument.get("fitting_fname"));
            Float f = (Float) solrDocument.get("fitting_fprice");
            //String s = (String) solrDocument.get("fitting_fprice");
            fitting.setFprice(new BigDecimal(f));
            fitting.setFimg((String) solrDocument.get("fitting_fimg"));

            list.add(fitting);
        }
        return list;
    }
}
