package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.databind.*;

public class BeanDescriptionTest extends BaseMapTest
{
    private final ObjectMapper MAPPER = objectMapper();

    private final static String CLASS_DESC = "Description, yay!";
    
    @JsonClassDescription(CLASS_DESC)
    static class DocumentedBean {
        public int x;
    }
    
    public void testClassDesc() throws Exception
    {
        BeanDescription beanDesc = ObjectMapperTestAccess.beanDescriptionForDeser(MAPPER, DocumentedBean.class);
        assertEquals(CLASS_DESC, beanDesc.findClassDescription());
    }
}
