package test.test;

import org.testng.AssertJUnit;
import org.testng.annotations.ExpectedExceptions;
import org.testng.annotations.Test;
import project.File;
import project.FileStorage;
import project.exception.FileNameAlreadyExistsException;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class FileModTest {

    @Test
    public void File()   {
         String fileName = "TEST.txt";
         String contentTest = "0123456789";
         File fileTest = new File(fileName,contentTest);
         fileTest.getSize();
    };

   };



