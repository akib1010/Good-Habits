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

    //Fields
    public String quoteOfTheDay="Nothing is loaded";
    public ArrayList<String> allQuotes = new ArrayList<>();
    private Context quoteContext;

    // Constructor
    public QuoteManager(Context context){
        this.quoteContext = context;
        loadQuoteList();
    }

    //This method loads all the quotes into an arraylist
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

    //Sets a random quote from the list of quotes as the quote of the day
    public void setRandomQuoteOfTheDay()
    {
        Random rand=new Random();
        int index=rand.nextInt(allQuotes.size());
        quoteOfTheDay=allQuotes.get(index);
    }

    //returns quoteOfTheDay
    public String getQuoteOfTheDay()
    {
        setRandomQuoteOfTheDay();
        return quoteOfTheDay;
    }

}