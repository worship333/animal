package com.animal.search.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.animal.commons.pojo.DwItemChild;
import com.animal.dubbo.service.DwItemCatDubboService;
import com.animal.dubbo.service.DwItemDescDubboService;
import com.animal.dubbo.service.DwItemDubboService;
import com.animal.pojo.DwItem;
import com.animal.pojo.DwItemCat;
import com.animal.pojo.DwItemDesc;
import com.animal.search.service.DwItemService;


@Service
public class DwItemServiceImpl implements DwItemService{
	@Reference
	private DwItemDubboService dwItemDubboServiceImpl;
	@Reference
	private DwItemCatDubboService dwItemCatDubboServiceImpl;
	@Reference
	private DwItemDescDubboService dwItemDescDubboServiceImpl;
	
	@Resource
	private CloudSolrClient solrClient;
	@Override
	public void init() throws SolrServerException, IOException {
		solrClient.deleteByQuery("*:*");
		solrClient.commit();
		//查询所有正常的商品
		List<DwItem> listItem = dwItemDubboServiceImpl.selAllByStatus((byte)1);
		for (DwItem item : listItem) {
			//商品对应的类目信息
			DwItemCat cat = dwItemCatDubboServiceImpl.selById(item.getCid());
			//商品对应的描述信息
			DwItemDesc desc = dwItemDescDubboServiceImpl.selByItemid(item.getId());
			SolrInputDocument doc = new SolrInputDocument();
			
			doc.setField("id", item.getId());
			doc.setField("item_title", item.getTitle());
			doc.setField("item_point", item.getPoint());
			doc.setField("item_image", item.getImage());
			doc.setField("item_category_name", cat.getName());
			doc.setField("item_desc", desc.getItemDesc());
			doc.setField("item_updated", item.getUpdated());
			solrClient.add(doc);
		}
		solrClient.commit();
	}
	@Override
	public Map<String, Object> selByQuery(String query,int page,int rows) throws SolrServerException, IOException {
		SolrQuery params = new SolrQuery();
		//设置分页条件
		params.setStart(rows*(page-1));
		params.setRows(rows);
		//设置条件
		params.setQuery("item_keywords:"+query);
		//设置高亮
		params.setHighlight(true);
		params.addHighlightField("item_title");
		params.setHighlightSimplePre("<span style='color:red'>");
		params.setHighlightSimplePost("</span>");
		//添加排序
		params.setSort("item_updated", ORDER.desc);
		
		QueryResponse response = solrClient.query(params);
		
		List<DwItemChild> listChild = new ArrayList<>();
		//未高亮内容
		SolrDocumentList listSolr = response.getResults();
		//高亮内容
		Map<String, Map<String, List<String>>> hh = response.getHighlighting();
		
		for (SolrDocument doc : listSolr) {
			DwItemChild  child = new DwItemChild();
			
			child.setId(Long.parseLong(doc.getFieldValue("id").toString()));
			List<String> list = hh.get(doc.getFieldValue("id")).get("item_title");
			if(list!=null&&list.size()>0){
				child.setTitle(list.get(0));
			}else{
				child.setTitle(doc.getFieldValue("item_title").toString());
			}
			Object image = doc.getFieldValue("item_image");
			child.setImages(image==null||image.equals("")?new String[1]:image.toString().split(","));
			child.setPoint(doc.getFieldValue("item_point").toString());
			
			listChild.add(child);
		}
		
		
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("itemList", listChild);
		resultMap.put("totalPages", listSolr.getNumFound()%rows==0?listSolr.getNumFound()/rows:listSolr.getNumFound()/rows+1);
		
		
		return resultMap;
	}
	@Override
	public int add(Map<String,Object> map,String desc) throws SolrServerException, IOException {
		SolrInputDocument doc = new SolrInputDocument();
		doc.setField("id", map.get("id"));
		doc.setField("item_title", map.get("title"));
		doc.setField("item_point", map.get("Point"));
		doc.setField("item_image", map.get("image"));
		doc.setField("item_category_name", dwItemCatDubboServiceImpl.selById((Integer)map.get("cid")).getName());
		doc.setField("item_desc", desc);
		UpdateResponse response = solrClient.add(doc);
		solrClient.commit();
		if(response.getStatus()==0){
			return 1;
		}
		return 0;
	}
}
