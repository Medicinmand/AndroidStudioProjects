package mwkn.ucn.dk.earthquakefeed;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 28-02-2017.
 */

public class XMLPullParserHandler {

    private List<QuakeModel> quakeModelList;
    private QuakeModel quakeModel;
    private String text;

    XMLPullParserHandler(){
        quakeModelList = new ArrayList<QuakeModel>();
    }
    public List<QuakeModel> getQuakeModelList() {
        return quakeModelList;
    }

    public List<QuakeModel> parse(InputStream inputStream){
        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            parser = factory.newPullParser();

            parser.setInput(inputStream, null);

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("event")) {
                            // create a new instance of quakeModel
                            quakeModel = new QuakeModel();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase("event")) {
                            // add quakeModel object to list
                            quakeModelList.add(quakeModel);
                        } else if (tagname.equalsIgnoreCase("text")) {
                            quakeModel.setDescription(text);
                        } else if (tagname.equalsIgnoreCase("time")) {
                            quakeModel.setTime(Date.valueOf(text));
                        } else if (tagname.equalsIgnoreCase("longitude")) {
                            quakeModel.setLongitude(text);
                        } else if (tagname.equalsIgnoreCase("latitude")) {
                            quakeModel.setLatitude(text);
                        } else if (tagname.equalsIgnoreCase("mag")) {
                            quakeModel.setMag(text);
                        }
                        break;

                    default:
                        break;
                }
                eventType = parser.next();
            }


        }catch (XmlPullParserException xmle){
            xmle.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

        return quakeModelList;
    }
}
