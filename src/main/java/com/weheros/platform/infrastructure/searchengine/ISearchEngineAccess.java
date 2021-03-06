/*
* Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
*
*
*/
package com.weheros.platform.infrastructure.searchengine;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

/**
 * @ClassName: ISearchEngineAccess
 * @Description: define the common interface to access search engin. 
 * @author Administrator
 * @date 2013年10月31日 下午4:14:08
 * @TODO:
 *    编写通用的封装查询条件的类 SolrInputDocument
 *    把查询条件封装成 SolrQuery
 */
public interface ISearchEngineAccess {
	/**
	  * 插入索引数据
	  * @author Yang
	  * @param document
	  * @return UpdateResponse
	  * @throws SolrServerException
	  * @throws IOException 
	  * @throws
	 */
    public UpdateResponse insert(SolrInputDocument document) throws SolrServerException, IOException; 
    /**
     *  根据id删除索引数据
      * @author Administrator
      * @param id
      * @return
      * @throws SolrServerException
      * @throws IOException UpdateResponse
      * @throws
     */
    public UpdateResponse delete(String id) throws SolrServerException, IOException;
    /**
     * 
      * 根据查询条件查询需要的数据
      * @author Administrator
      * @param query
      * @return SolrDocumentList
      * @throws SolrServerException 
      * 
      *
     */
    public SolrDocumentList query(SolrQuery query) throws SolrServerException;
    /**
     *  根据查询条件，查询需要的数据。
     *  把查询结果分析，封装成需要的对象。
      * @author Administrator
      * @param query
      * @param entityClass
      * @return List<T>
      * @throws SolrServerException 
      * 
      *
     */
    public <T> List<T> query(SolrQuery query,Class<T> entityClass) throws SolrServerException;
}
