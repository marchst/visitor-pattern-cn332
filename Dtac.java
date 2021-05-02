import java.util.regex.Pattern;

public class Dtac implements CommunicationProvider {

  private Pattern pattern = Pattern.compile("Dtac_(.*).tar.gz");

  public Pattern getPattern() {
    return pattern;
  }

  public void setPattern(Pattern pattern) {
    this.pattern = pattern;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.sendFiles(this);
  }
}
