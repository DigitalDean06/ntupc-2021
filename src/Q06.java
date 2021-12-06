import java.util.*;

public class Q06 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] ics = scanner.nextLine().split(";");
    List<String> priorities = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      priorities.add(scanner.nextLine());
    }
    scanner.close();

    List<IC> icList = new ArrayList<>();
    for (String ic : ics) {
      icList.add(new IC(ic));
    }
    icList.sort((o1, o2) -> {
      for (String priority : priorities) {
        int comparison;
        if ((comparison = IC.comparators.get(priority).compare(o1, o2)) != 0) return comparison;
      }
      return 0;
    });
    icList.forEach(System.out::println);
  }

  private static class IC {
    public static final Map<String, Comparator<IC>> comparators = new HashMap<>();
    private static final Comparator<IC> birthYearComparator = Comparator.comparingInt(o -> o.year);
    private static final Comparator<IC> birthMonthComparator = Comparator.comparingInt(o -> o.month);
    private static final Comparator<IC> birthDayComparator = Comparator.comparingInt(o -> o.day);
    private static final Comparator<IC> birthdateComparator = (o1, o2) -> {
      int comparison;
      if ((comparison = birthYearComparator.compare(o1, o2)) != 0) return comparison;
      if ((comparison = birthMonthComparator.compare(o1, o2)) != 0) return comparison;
      if ((comparison = birthDayComparator.compare(o1, o2)) != 0) return comparison;
      return 0;
    };
    private static final Comparator<IC> maleComparator = (o1, o2) -> {
      if (o1.male == o2.male) return 0;
      return o1.male ? -1 : 1;
    };
    private static final Comparator<IC> femaleComparator = (o1, o2) -> {
      if (o1.male == o2.male) return 0;
      return o1.male ? 1 : -1;
    };
    private static final List<String> months = new ArrayList<>();

    static {
      months.add("January");
      months.add("February");
      months.add("March");
      months.add("April");
      months.add("May");
      months.add("June");
      months.add("July");
      months.add("August");
      months.add("September");
      months.add("October");
      months.add("November");
      months.add("December");

      comparators.put("Birthdate", birthdateComparator);
      comparators.put("Birth Year", birthYearComparator);
      comparators.put("Birth Month", birthMonthComparator);
      comparators.put("Birth Day", birthDayComparator);
      comparators.put("Gender with Male first", maleComparator);
      comparators.put("Gender with Female first", femaleComparator);
    }

    public final String ic;
    public final int year;
    public final int month;
    public final int day;
    public final boolean male;

    public IC(String ic) {
      this.ic = ic;
      int year = Integer.parseInt(ic.substring(0, 2));
      year += year >= 41 ? 1900 : 2000;
      this.year = year;
      month = Integer.parseInt(ic.substring(2, 4));
      day = Integer.parseInt(ic.substring(4, 6));
      male = Integer.parseInt(String.valueOf(ic.charAt(ic.length() - 1))) % 2 == 1;
    }

    public String getMonth() {
      return months.get(month - 1);
    }

    @Override
    public String toString() {
      return String.format("%s %s %s %s %s", ic, "0".repeat(2 - String.valueOf(day).length()) + day, getMonth(), year, male ? "Male" : "Female");
    }
  }
}
