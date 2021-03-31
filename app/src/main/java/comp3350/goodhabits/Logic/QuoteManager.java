package comp3350.goodhabits.Logic;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteManager {

    public String quoteOfTheDay="";
    public ArrayList<String> allQuotes = new ArrayList<>();
    private Context quoteContext;

    // Constructor
    public QuoteManager(Context context){
        this.quoteContext = context;
        loadQuoteList();
    }

    public ArrayList<String> loadQuoteList(){

        AssetManager am = quoteContext.getAssets();

        try {
            InputStream is = am.open("Quotes.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            while ((line = reader.readLine()) != null)
                allQuotes.add(line);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return allQuotes;
    }

    public void setQuoteOfTheDay()
    {
        Random rand=new Random();
        int index=rand.nextInt(allQuotes.size());
        quoteOfTheDay=allQuotes.get(index);
    }

    public String getQuoteOfTheDay()
    {
        if (quoteOfTheDay.equals(""))
        {
            setQuoteOfTheDay();
        }
        return quoteOfTheDay;

    }

    public void setUpNotificationSystem()
    {
        Notifier qNotify= new Notifier(quoteContext);
        setQuoteOfTheDay();
        qNotify.setQuoteNotification(quoteOfTheDay);
    }


}