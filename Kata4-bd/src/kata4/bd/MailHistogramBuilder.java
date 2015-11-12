package kata4.bd;

import java.util.ArrayList;

public class MailHistogramBuilder {
    public static Histogram <String> buil (ArrayList<String> mailList) {
        Histogram<String> histogram = new Histogram <>();
        for (String mail : mailList) {
            Mail domi = new Mail(mail);
            histogram.increment(domi.getDominio());
        }
        return histogram;
    }
}
