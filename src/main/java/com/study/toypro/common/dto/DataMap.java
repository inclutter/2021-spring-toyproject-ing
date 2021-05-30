package com.study.toypro.common.dto;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;

public class DataMap extends LinkedHashMap<String, Object> {
    private String sortKey = null;
    private int sortOrder = 1; //
    private boolean sortType = true; //

    public DataMap() {
        super();
    }

    public DataMap(Map<String, Object> map) {
        super(map);
    }

    public DataMap(String queryStr) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        String query = queryStr.substring(1, queryStr.length() - 1);
        for (String c : query.split(",")) {
            String[] m = c.split("=");
            map.put(m[0].trim(), m.length == 1 ? "" : m[1].trim());
        }
        this.putAll(map);
    }

    public DataMap get(String[] keys) {
        DataMap data = new DataMap();
        for (String key : keys) {
            data.put(key, this.get(key));
        }
        return data;
    }

    /**
     * <p>
     * 해당 Key의 String Value를 반환한다.
     * </p>
     *
     * @param key
     * @return String Value
     * @throws Exception
     */
    public String getString(String key) {
        Object object    = super.get(key);
        Object objectVal = new Object();
        String value     = "";
        if (object != null) {
            if (object.getClass().isArray()) {
                objectVal = ((Object[])object)[0];
                return String.valueOf(objectVal).trim();
            } else {
                value = String.valueOf(object);
                return value.trim();
            }
        } else {
            return "";
        }
    }

    /**
     * <p>
     * 해당 Key의 String Value를 반환한다.
     * </p>
     *
     * @param key
     * @return String Value
     * @throws Exception
     */
    public String getNString(String key) {
        Object object    = super.get(key);
        Object objectVal = new Object();
        String value     = "";
        if (object != null) {
            if (object.getClass().isArray()) {
                objectVal = ((Object[])object)[0];
                return String.valueOf(objectVal).trim();
            } else {
                value = String.valueOf(object);
                return value.trim();
            }
        } else {
            return null;
        }
    }

    /**
     * <p>
     * 해당 Key의 String Value를 반환한다.
     * </p>
     *
     * @param key
     * @return String Value
     * @throws Exception
     */
    public String[] getStringArr(String key) {
        Object object = super.get(key);
        String value  = "";
        if (object != null) {
            if (object.getClass().isArray() ){
                return (String[])object;
            } else {
                value = String.valueOf(object);
                return new String[]{value.trim()};
            }
        } else {
            return null;
        }
    }

    /**
     * <p>
     * 해당 Key의 Integer Value를 반환한다.
     * </p>
     *
     * @param key
     * @return Integer Value
     * @throws Exception
     */
    public Integer getInteger(String key) {
        Object object = super.get(key);
        if (object == null) {
            return null;
        }
        return getInt(key);
    }

    /**
     * <p>
     * 해당 Key의 Int Value를 반환한다.
     * </p>
     *
     * @param key
     * @return Int Value
     */
    public int getInt(String key) {
        Object object = super.get(key);
        if (object == null) { return 0; }

        int result = -1;
        if (object instanceof String) {
            String str = ((String)object).trim();
            result = str.isEmpty() ? 0 : Integer.parseInt(str);
        } else if (object instanceof Number) {
            result = ((Number)object).intValue();
        } else if (object instanceof java.sql.Timestamp) {
            result = (int)((java.sql.Timestamp)object).getTime();
        }
        return result;
    }

    /**
     * <p>
     * 해당 Key의 Long Value를 반환한다.
     * </p>
     *
     * @param key
     * @return long Value
     */
    public long getLong(String key) {
        Object obj = super.get(key);
        if (obj == null) { return 0; }

        if (obj instanceof Number) {
            return ((Number)obj).longValue();
        } else if (obj instanceof java.sql.Timestamp) {
            return ((java.sql.Timestamp)obj).getTime();
        } else if (obj instanceof String) {
            return Long.parseLong((String)obj);
        }
        return 0;
    }

    /**
     * <p>
     * 해당 Key의 Dobule Value를 반환한다.
     * </p>
     *
     * @param key
     * @return long Value
     */
    public double getDouble(String key) {
        Object obj = super.get(key);
        if (obj == null) { return 0; }

        if (obj instanceof Number) {
            return ((Number)obj).doubleValue();
        } else if (obj instanceof java.sql.Timestamp) {
            return ((java.sql.Timestamp)obj).getTime();
        } else if (obj instanceof String) {
            return Double.parseDouble((String)obj);
        }
        return 0;
    }

    /**
     * <p>
     * 해당 Key의 Date Value를 반환한다.
     * </p>
     *
     * @param key
     * @return Date Value
     * @throws Exception
     */
    public Date getDate(String key) {
        return (Date)(super.get(key));
    }

    public boolean getBoolean( String key ){
        String val = getString(key);
        if (val.isEmpty() ) {
            return false;
        }
        return (val.equalsIgnoreCase("true"));
    }

    /**
     *
     * <p>
     * 해당 Key의 Object Value를 반환한다.
     * </p>
     *
     * @param key
     * @return Object Value
     * @throws Exception
     */
    public Object getObject(String key) {
        return super.get(key);
    }

    /**
     * <p>
     * 해당 Key의 byte Value를 반환한다.
     * </p>
     *
     * @param key
     * @return byte Value
     * @throws Exception
     * @throws IOException
     */
    public byte[] getBinary(String key) {
        return (byte[]) (super.get(key));
    }

    /**
     * <p>
     * 해당 Key의 StreamToString Value를 반환한다.
     * </p>
     *
     * @param key
     * @return StreamToString Value
     * @throws Exception
     * @throws IOException
     */
    public String getStreamToString(String key) throws IOException {
        String result = null;
        InputStream in = null;

        StringBuffer sb = new StringBuffer();
        in = (InputStream) (super.get(key));
        byte buf[] = new byte[5];
        int readCount = 0;
        while ((readCount = in.read(buf)) != -1) {
            sb.append(new String(buf, 0, readCount));
        }
        result = sb.toString();

        return result;
    }


    /**
     * 해당 key의 data가 List형태일때 DataMap List로 변환
     * @param key
     * @return
     * List<DataMap>
     */
    @SuppressWarnings("unchecked")
    public List<DataMap> getListDataMap(String key){

        List<DataMap> dataList = new ArrayList<DataMap>();

        if(super.get(key) != null ){
            List<Map<String, Object>> listObj = (List<Map<String, Object>>)super.get(key);

            DataMap data = null;
            for (Map<String, Object> map : listObj) {
                data = new DataMap(map);
                dataList.add(data);
            }
        }

        return dataList;
    }

    /**
     * 리스트 형태의 데이타를 반환한다.
     *
     * @param key
     * @param clazz 형타입
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> getList(String key, Class<T> clazz) {
        List<T> list = null;
        if (super.get(key) != null ) {
            list = (List<T>) super.get(key);
        }
        return list;
    }

    /**
     * 해당 key의 data 가 LinkedHashedMap 형태일 경우 DataMap으로 변환
     *
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public DataMap getDataMap(String key) {
        Map<String, Object> result = null;
        if (super.get(key) != null) {
            result = (Map<String, Object>) super.get(key);
        }
        // kkk: Debug - Null pinter error
        if (result == null) return null;

        return new DataMap(result);
    }


    public DataMap getListToDataMap(String key, String putKey) {
        return getListToDataMap(key, putKey, null);
    }

    /**
     * 해당 key의 data 가 List<DataMap> 형태일 경우 DataMap으로 변환
     *
     * @param key
     * @param putKey
     * @param valueKey
     * @return
     */
    public DataMap getListToDataMap(String key, String putKey, String valueKey) {
        DataMap result = null;
        if (super.get(key) != null) {
            List<?> list = (List<?>) super.get(key);
            result = new DataMap();
            for (Object obj : list) {
                if (obj instanceof DataMap) {
                    DataMap data = (DataMap) obj;
                    if (valueKey != null) {
                        result.put(data.getString(putKey), data.get(valueKey));
                    } else {
                        result.put(data.getString(putKey), data);
                    }
                }
            }
        }
        return result;
    }

    public DataMap getListToDataMapKeyRemove(String key, String putKey) {
        DataMap result = null;
        if (super.get(key) != null) {
            List<?> list = (List<?>) super.get(key);
            result = new DataMap();
            for (Object obj : list) {
                if (obj instanceof DataMap) {
                    DataMap data = (DataMap) obj;
                    String keyVal = data.getString(putKey);
                    data.remove(putKey);
                    result.put(keyVal, data);
                }
            }
        }
        return result;
    }

    /**
     *
     * @param key
     * @param putKey
     * @param valueKey
     * @param langGroupCd
     * @return
     */
    public DataMap getListToDataMap(String key, String putKey, String valueKey, String langGroupCd) {
        DataMap result = null;
        if (super.get(key) != null) {
            List<?> list = (List<?>) super.get(key);
            result = new DataMap();
            for (Object obj : list) {
                if (obj instanceof DataMap) {
                    DataMap data = (DataMap) obj;
                    if (valueKey != null) {
                        if (data.getString("langGroupCd").equals(langGroupCd)) {
                            result.put(data.getString(putKey), data.get(valueKey));
                        }
                    } else {
                        result.put(data.getString(putKey), data);
                    }
                }
            }
        }
        return result;
    }

    /**
     * <p>
     * 해당 Key의 Object Value를 넣는다.
     * </p>
     *
     * @param key
     * @param value
     * @throws Exception
     */
    public void set(String key, Object value) {
        if (key == null || value == null) {
            return;
        }
        this.put(key, value);
    }

    /**
     * <p>
     * 해당 Key의 String Value를 넣는다.
     * </p>
     *
     * @param key
     * @param s
     */
    public void setString(String key, String s) {
        this.put(key, s);
    }

    /**
     * <p>
     * 해당 Key의 String Value를 넣는다.
     * </p>
     *
     * @param key
     * @param s
     */
    public void setStringArr(String key, String[] s) {
        this.put(key, s);
    }

    /**
     * <p>
     * 해당 Key의 int Value를 넣는다.
     * </p>
     *
     * @param key
     * @param i
     */
    public void setInt(String key, int i) {
        Integer integer = Integer.valueOf(i);
        this.put(key, integer);
    }

    /**
     * <p>
     * 해당 Key의 Double Value를 넣는다.
     * </p>
     *
     * @param key
     * @param d
     */
    public void setDouble(String key, double d) {
        Double db = new Double(d);
        this.put(key, db);
    }

    /**
     * <p>
     * 해당 Key의 Float Value를 넣는다.
     * </p>
     *
     * @param key
     * @param f
     */
    public void setFloat(String key, float f) {
        Float fl = new Float(f);
        this.put(key, fl);
    }

    /**
     * <p>
     * 해당 Key의 Long Value를 넣는다.
     * </p>
     *
     * @param key
     * @param l
     */
    public void setLong(String key, long l) {
        Long lo = Long.valueOf(l);
        this.put(key, lo);
    }

    /**
     * <p>
     * 해당 Key의 Short Value를 넣는다.
     * </p>
     *
     * @param key
     * @param st
     */
    public void setShort(String key, short st) {
        Short st2 = Short.valueOf(st);
        this.put(key, st2);
    }

    /**
     * <p>
     * 해당 Key의 Boolean Value를 넣는다.
     * </p>
     *
     * @param key
     * @param bl
     */
    public void setBoolean(String key, boolean bl) {
        Boolean bl2 = Boolean.valueOf(bl);
        this.put(key, bl2);
    }

    /**
     * <p>
     * 해당 Key의 BigDecimal Value를 넣는다.
     * </p>
     *
     * @param key
     * @param bigdecimal
     */
    public void setBigDecimal(String key, BigDecimal bigdecimal) {
        this.put(key, bigdecimal);
    }
    /**
     * @return
     */
    public String getSortKey() {
        String key = this.sortKey;
        if (key == null) {
            Iterator<?> iter = this.entrySet().iterator();
            if ( iter.hasNext()){
                key = (String)iter.next();
            }
        }
        return key;
    }

    public void setSortKey(String key, boolean typeString) {
        this.sortKey = key;
        this.sortType = typeString;
    }

    public void setSortAsc() {
        this.sortOrder = 1;
    }

    public void setSortDesc() {
        this.sortOrder = -1;
    }

    public int compareTo(Object o) {
        int result = 0;
        if (this.sortType) {
            String aKey = getSortKey();
            String bKey = ((DataMap) o).getSortKey();
            String aValue = null;
            String bValue = null;
            int order = sortOrder;
            aValue = this.getString(aKey);
            bValue = ((DataMap) o).getString(bKey);
            result = order * aValue.compareTo(bValue);
            return result;
        } else {
            String aKey = getSortKey();
            String bKey = ((DataMap) o).getSortKey();
            Integer aValue = null;
            Integer bValue = null;
            int order = sortOrder;
            aValue = this.getInteger(aKey);
            bValue = ((DataMap) o).getInteger(bKey);
            result = order * aValue.compareTo(bValue);
            return result;
        }
    }

    /**
     * @return
     */
    public Object[] toObject() {
        return this.values().toArray();
    }

    public boolean isEmpty(Object key) {
        return !this.isNotEmpty(key);
    }

    public boolean isNotEmpty(Object key) {
        boolean result = this.containsKey(key);
        if (!result) {
            return false;
        }
        return result;
    }

    public void defaultIfEmpty(String key, Object defaultObj) {
        if (isEmpty(key)) {
            this.set(key, defaultObj);
        }
    }

    public DataMap clone() {
        return this;
    }
}
