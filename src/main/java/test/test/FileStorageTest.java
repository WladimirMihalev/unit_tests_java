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


public class FileStorageTest {

    @Test
    public void writeNoExistentFileTest() throws FileNameAlreadyExistsException {
        FileStorage testStorage = new FileStorage();
        String filename = "TEST.txt";
        String content = "TESTETSTERTTY";
        File fileToTest = new File(filename, content);

        boolean result = testStorage.write(fileToTest);
        assertTrue(result);
    };

    @Test
    public void writeEmptyContentTest() throws FileNameAlreadyExistsException {
        FileStorage testStorage = new FileStorage();
        String filename = "TEST.txt";
        String content = "TESTETSTERTTY";
        File fileToTest = new File(filename, content);

        boolean result = testStorage.write(fileToTest);
        assertTrue(result);
    };


    @Test(expectedExceptions = FileNameAlreadyExistsException.class)
    public void writeExistentFileTest() throws FileNameAlreadyExistsException {
        FileStorage testStorage = new FileStorage();
        String filename = "TEST.txt";
        String content = "TESTETSTERTTY";

        String filenameToAdd = "TEST.txt";
        String contentToAdd = "TESTER";


        File fileToTest = new File(filenameToAdd, contentToAdd);
        File sameNameFileToTest = new File(filename, content);

        testStorage.write(fileToTest);
        testStorage.write(sameNameFileToTest);
    };


    @Test
    public void isExistTest() throws FileNameAlreadyExistsException {
        FileStorage testStorage = new FileStorage();
        String filename = "TEST.txt";
        String content = "TESTupTEST";

        File file = new File(filename,content);
        testStorage.write(file);

        boolean result = testStorage.isExists(filename);
        assertTrue(result);

    };


    @Test
    public void isExistTestContains() throws FileNameAlreadyExistsException {
        FileStorage testStorage = new FileStorage();
        String filename = "TEST.txt";
        String content = "TESTupTEST";
        String filenameTestContains = "TES";

        File file = new File(filename,content);
        testStorage.write(file);

        boolean result = testStorage.isExists(filenameTestContains);
        assertTrue(result);

    };


    @Test(expectedExceptions = NullPointerException.class)
    public void isExistTestNull() throws FileNameAlreadyExistsException {
        FileStorage testStorage = new FileStorage();
        String filename = null;
        String content = "TESTupTEST";

        File file = new File(filename,content);
        testStorage.write(file);

        testStorage.isExists(filename);


    };


    @Test
    public void isNotExistTest() throws FileNameAlreadyExistsException {
        FileStorage testStorage = new FileStorage();
        String filename = "TEST.txt";
        String content = "TESTupTEST";
        String filenameNotExist = "TEST_not_EXIST.txt";

        File file = new File(filename,content);
        testStorage.write(file);

        boolean result = testStorage.isExists(filenameNotExist);
        assertFalse(result);
    };


    @Test
    public void deleteTest() throws FileNameAlreadyExistsException  {
        FileStorage testStorage = new FileStorage();
        String filename = "TEST.txt";
        String content = "TESTupTEST";

        File file = new File(filename,content);
        testStorage.write(file);

        boolean result = testStorage.delete(filename);
        assertTrue(result);
    };


   @Test
   public void getFileTest() throws FileNameAlreadyExistsException {
       FileStorage testStorage = new FileStorage();
       String filename = "TEST.txt";
       String content = "TESTupTEST";

       File file = new File(filename, content);
       testStorage.write(file);
       boolean result = file.getFilename().equals(filename);
       assertTrue(result);
   };

       @Test
       public void getFileTestNull() throws FileNameAlreadyExistsException {
           FileStorage testStorage = new FileStorage();
           String filename = "TEST.txt";
           String filenameNotExist = "ZTESTNOTES.txt";
           String content = "TESTupTEST";

           File file = new File(filename,content);
           testStorage.write(file);
           boolean result = file.getFilename().equals(filenameNotExist);
           assertFalse(result);

      };

   }



