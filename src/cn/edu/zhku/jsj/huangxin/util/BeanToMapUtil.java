package cn.edu.zhku.jsj.huangxin.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;




/**
 * Map ������ JavaBean ����ת������ 
 */
public class BeanToMapUtil
{
    /**
     * �� Map����ת��ΪJavaBean
     * <һ�仰���ܼ���>
     * <������ϸ����>
     * @param map
     * @param T
     * @return
     * @throws Exception
     * @see [�ࡢ��#��������#��Ա]
     */
    public static <T> T map2Bean(Map<String,Object> map, Class<T> T)
        throws Exception
    {
        if (map == null || map.size() == 0)
        {
            return null;
        }
        BeanInfo beanInfo = Introspector.getBeanInfo(T);
        T bean = (T)T.newInstance();
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0, n = propertyDescriptors.length; i < n; i++)
        {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            //            String upperPropertyName = propertyName.toUpperCase();
            if (map.containsKey(propertyName))
            {
                Object value = map.get(propertyName);
                //����������ᱨ�������Ͳ�ƥ��Ĵ���
                BeanUtils.copyProperty(bean, propertyName, value);
            }
        }
        return bean;
    }
    
    /**
     * ��һ�� JavaBean ����ת��Ϊһ�� Map 
     * <һ�仰���ܼ���>
     * <������ϸ����>
     * @param bean
     * @return
     * @throws IntrospectionException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @see [�ࡢ��#��������#��Ա]
     */
    public static Map<String, Object> bean2Map(Object bean)
        throws IntrospectionException, IllegalAccessException, InvocationTargetException
    {
        Class<? extends Object> type = bean.getClass();
        Map<String, Object> returnMap = new HashMap<String, Object>();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);
        
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++)
        {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class"))
            {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(bean, new Object[0]);
                if (result != null)
                {
                    returnMap.put(propertyName, result);
                }
                else
                {
                    returnMap.put(propertyName, null);
                }
            }
        }
        return returnMap;
    }
    
    /**
     * �� List<Map>����ת��ΪList<JavaBean>
     * <һ�仰���ܼ���>
     * <������ϸ����>
     * @param listMap
     * @param T
     * @return
     * @throws Exception
     * @see [�ࡢ��#��������#��Ա]
     */
    public static <T> List<T> listMap2ListBean(List<Map<String, Object>> listMap, Class<T> T)
        throws Exception
    {
        List<T> beanList = new ArrayList<T>();
        if (listMap != null && !listMap.isEmpty())
        {
            for (int i = 0, n = listMap.size(); i < n; i++)
            {
                Map<String, Object> map = listMap.get(i);
                T bean = map2Bean(map, T);
                beanList.add(bean);
            }
            return beanList;
        }
        else
        {
            return null;
        }
    }
    
    /**
     * �� List<JavaBean>����ת��ΪList<Map>
     * <һ�仰���ܼ���>
     * <������ϸ����>
     * @param beanList
     * @return
     * @throws Exception
     * @see [�ࡢ��#��������#��Ա]
     */
    public static <T> List<Map<String, Object>> listBean2ListMap(List<T> beanList, Class<T> T)
        throws Exception
    {
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (int i = 0, n = beanList.size(); i < n; i++)
        {
            Object bean = beanList.get(i);
            Map<String,Object> map = bean2Map(bean);
            mapList.add(map);
        }
        return mapList;
    }
}