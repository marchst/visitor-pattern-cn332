import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SystemDataVisitor implements Visitor {

  public List<File> listOfFile;

  public SystemDataVisitor(List<File> listOfFile) {
    super();
    this.listOfFile = listOfFile;
  }

  @Override
  public void sendFiles(TrueMoveH truemoveh) {
    Pattern pattern = truemoveh.getPattern();
    for (File file : listOfFile) {
      Matcher matcher = pattern.matcher(file.getName());
      if (matcher.find()) {
        System.out.println("Sending TrueMoveH files");
      }
    }
  }

  @Override
  public void sendFiles(AIS ais) {
    Pattern pattern = ais.getPattern();
    for (File file : listOfFile) {
      Matcher matcher = pattern.matcher(file.getName());
      if (matcher.find()) {
        System.out.println("Sending AIS files");
      }
    }
  }

  @Override
  public void sendFiles(Dtac dtac) {
    Pattern pattern = dtac.getPattern();
    for (File file : listOfFile) {
      Matcher matcher = pattern.matcher(file.getName());
      if (matcher.find()) {
        System.out.println("Sending Dtac files");
      }
    }
  }
}
