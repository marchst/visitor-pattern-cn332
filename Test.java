import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test {

  public static void main(String[] args) {
    File file1 = new File("AIS_(.*).tar.gz");
    File file2 = new File("TrueMoveH_(.*).tar.gz");
    File file3 = new File("Dtac_(.*).tar.gz");
    List<File> listOfFiles = new ArrayList<File>();
    listOfFiles.add(file1);
    listOfFiles.add(file2);
    listOfFiles.add(file3);
    DynamicLineDataVisitor dynamicLineDataVisitor = new DynamicLineDataVisitor(
      listOfFiles
    );
    SystemDataVisitor systemDataVisitor = new SystemDataVisitor(listOfFiles);
    CommunicationProvider ais = new AIS();
    CommunicationProvider truemoveh = new TrueMoveH();
    CommunicationProvider dtac = new Dtac();
    ais.accept(dynamicLineDataVisitor);
    truemoveh.accept(systemDataVisitor);
    dtac.accept(dynamicLineDataVisitor);
  }
}
