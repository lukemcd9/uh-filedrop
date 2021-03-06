package edu.hawaii.its.filedrop.type;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class FileSetTest {

    private FileSet fileSet;

    @Before
    public void setUp() {
        fileSet = new FileSet();
    }

    @Test
    public void accessors() {
        assertNull(fileSet.getId());
        assertNull(fileSet.getFileName());
        assertNotNull(fileSet.getComment());

        fileSet.setId(666);
        assertThat(fileSet.getId(), equalTo(666));

        fileSet.setComment(null);
        assertThat(fileSet.getComment(), equalTo(""));

        fileSet.setComment("");
        assertThat(fileSet.getComment(), equalTo(""));

        fileSet.setComment("top");
        assertThat(fileSet.getComment(), equalTo("top"));
    }

    @Test
    public void testToString() {
        System.out.println("aaa");
        System.out.println(">>>>>>>>>>>>>>>>> fileSet: " + fileSet);
        System.out.println("bbb");

        assertThat(fileSet.toString(), containsString("FileSet [id=null,"));
        fileSet.setId(1);
        assertThat(fileSet.toString(), containsString("FileSet [id=1,"));
        fileSet.setId(12);
        assertThat(fileSet.toString(), containsString("FileSet [id=12,"));
        fileSet.setId(123);
        assertThat(fileSet.toString(), containsString("FileSet [id=123,"));
        fileSet.setId(1234);
        assertThat(fileSet.toString(), containsString("FileSet [id=1234,"));
    }
}
