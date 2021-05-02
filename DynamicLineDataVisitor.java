import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DynamicLineDataVisitor implements Visitor {

  public List<File> listOfFile;

  public DynamicLineDataVisitor(List<File> listOfFile) {
    super();
    this.listOfFile = listOfFile;
  }

  @Override
  public void sendFiles(TrueMoveH truemoveh) {
    Pattern pattern = truemoveh.getPattern();
    for (File file : listOfFile) {
      Matcher matcher = pattern.matcher(file.getName());
      if (matcher.find()) {
        System.out.println("Sending truemoveh files");
      }
    }
  }

  @Override
  public void sendFiles(AIS ais) {
    Pattern pattern = ais.getPattern();
    for (File file : listOfFile) {
      Matcher matcher = pattern.matcher(file.getName());
      if (matcher.find()) {
        System.out.println("Sending ais files");
      }
    }
  }

  @Override
  public void sendFiles(Idea idea) {
    Pattern pattern = idea.getPattern();
    for (File file : listOfFile) {
      Matcher matcher = pattern.matcher(file.getName());
      if (matcher.find()) {
        System.out.println("Sending Idea files");
      }
    }
  }
}
