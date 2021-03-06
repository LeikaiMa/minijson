package org.minijson.parser.impl;

import static org.junit.Assert.fail;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minijson.builder.IndentedJsonBuilder;
import org.minijson.builder.JsonBuilderException;
import org.minijson.mini.MiniJsonBuilder;
import org.minijson.parser.JsonParserException;
import org.minijson.parser.RichJsonParser;
import org.minijson.type.JsonNode;


public class AbstractRichJsonParserTest
{

    private RichJsonParser jsonParser;
    
    @Before
    public void setUp() throws Exception
    {
        jsonParser = new AbstractRichJsonParser() {};
    }

    @After
    public void tearDown() throws Exception
    {
    }

    // @Test
    public void testParseString()
    {
        fail("Not yet implemented");
    }

    @Test
    public void testParseJsonString()
    {
        // String jsonStr = "{\"a\":[3, 5, 7]}";
        String jsonStr = "[31, {\"a\":[3, false, true], \"b\":null}, \"ft\", null]";

        try {
            JsonNode node = jsonParser.parseJson(jsonStr);
            System.out.println("node = " + node);

        } catch (JsonParserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testParseJsonReader()
    {
        // String filePath = "C:\\Projects\\gitprojects\\glass\\app\\appengine\\minijson\\extra\\fastjson-bug.json";
        // String filePath = "C:\\Projects\\gitprojects\\glass\\app\\appengine\\minijson\\extra\\random-json1.json";
        // String filePath = "C:\\Projects\\gitprojects\\glass\\app\\appengine\\minijson\\extra\\random-json2.json";
        // String filePath = "C:\\Projects\\gitprojects\\glass\\app\\appengine\\minijson\\extra\\random-json3.json";
        String filePath = "C:\\Projects\\gitprojects\\glass\\app\\appengine\\minijson\\extra\\sample.json";
        
        Object node = null;
        try {
            Reader reader = new FileReader(filePath);
            
            node = jsonParser.parseJson(reader);
            System.out.println("node = " + node);
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JsonParserException e) {
            e.printStackTrace();
            
            String context = e.getContext();
            System.out.println("context = " + context);
            
        }
        
        
        // format the jsonStr
        IndentedJsonBuilder jsonBuilder = new MiniJsonBuilder();
        String jsonStr = null;
        try {
            jsonStr = jsonBuilder.build(node, 4);
        } catch (JsonBuilderException e) {
            e.printStackTrace();
        }
        System.out.println("jsonStr = " + jsonStr);
        

    }

}
