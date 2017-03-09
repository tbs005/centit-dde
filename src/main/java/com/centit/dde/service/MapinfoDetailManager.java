package com.centit.dde.service;

import java.util.List;
import java.util.Map;



import com.alibaba.fastjson.JSONArray;
import com.centit.dde.po.MapinfoDetail;
import com.centit.dde.po.MapinfoDetailId;
import com.centit.framework.core.service.BaseEntityManager;
import com.centit.framework.staticsystem.po.DatabaseInfo;

public interface MapinfoDetailManager extends BaseEntityManager<MapinfoDetail,MapinfoDetailId> {
    public List<Map<String, String>> getGoalTableStruct(DatabaseInfo DatabaseInfo, String tableName);

    public List<Map<String, String>> getSourceTableStruct(DatabaseInfo DatabaseInfo, String tableName);

    public List<String> getTables(DatabaseInfo databaseInfo);

    public void deleteMapinfoDetails(Long mapinfoId);

    public void updateExchangeMapinfo(Long mapinfoId, String soueceTableName, String goalTableName, String createSql);

    public List<Map<String, String>> getSourceTableStructFromDatabase(Long mapinfoId);

    public List<Map<String, String>> getGoalTableStructFromDatabase(Long mapinfoId);

    public void updateSourceColumnSentence(Map<String, Object> structs, String mapinfoId);

    public List<Object> getTable(DatabaseInfo databaseInfo);

    public Long getMapinfoId();

    public List<String> getGoalColumnStrut(Long mapinfoId);

    public void saveMapinfoDetails(MapinfoDetail mapinfoDetail);
    
    public List<MapinfoDetail> listByMapinfoId(Long mapinfoId);
    
}
