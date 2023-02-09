package dat3.experiment;
//Never use anything in here for real
public class SimpleSanitizer {
  public static String simpleSanitize(String s){
    String pattern= "<b>(.*?)</b>";
    return s.replaceAll(pattern, "World");
  }
}
