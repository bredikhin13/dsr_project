package unit;

import com.vsu.dsrproject.MainConf;
import com.vsu.dsrproject.service.TextParser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainConf.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParsingTest {
    @Autowired
    private TextParser parser;

    @Test
    public void parsingSimpleTest(){
        String s1 = "Hello word";
        String s2 = parser.parseInputText(s1);
        Assert.assertEquals("Hello. word",s2);
    }

    @Test
    public void parsingWithSymbTest(){
        String s1 = "!1@H#el^lo w*o(r)(d!";
        String s2 = parser.parseInputText(s1);
        Assert.assertEquals("Hello. word",s2);
    }

}
