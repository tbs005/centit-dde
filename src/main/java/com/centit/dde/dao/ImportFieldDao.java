package com.centit.dde.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.centit.core.dao.BaseDaoImpl;
import com.centit.core.dao.CodeBook;
import com.centit.dde.po.ImportField;

public class ImportFieldDao extends BaseDaoImpl<ImportField> {
    private static final long serialVersionUID = 1L;
    public static final Log log = LogFactory.getLog(ImportFieldDao.class);

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();

            filterField.put("columnNo", CodeBook.EQUAL_HQL_ID);

            filterField.put("importId", CodeBook.EQUAL_HQL_ID);


            filterField.put("sourceFieldName", CodeBook.LIKE_HQL_ID);

            filterField.put("destFieldName", CodeBook.LIKE_HQL_ID);

            filterField.put("destFieldType", CodeBook.LIKE_HQL_ID);

            filterField.put("isPk", CodeBook.LIKE_HQL_ID);

            filterField.put("destFieldDefault", CodeBook.LIKE_HQL_ID);

            filterField.put("isNull", CodeBook.LIKE_HQL_ID);

        }
        return filterField;
    }
}
