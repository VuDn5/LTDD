package com.example.hw08;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.example.hw08.Adapter.ItemChannelAdapter;
import com.example.hw08.Data.ItemChannel;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DownloadRssFeed extends AsyncTask<String, Void, ArrayList<ItemChannel>> {

    private String urlAddress;
    private Channel callerContext;
    ProgressDialog dialog = null;

    public DownloadRssFeed(Channel callerContext) {
        this.callerContext = (Channel) callerContext;
        dialog = new ProgressDialog(callerContext);
    }

    @Override
    protected void onPostExecute(ArrayList<ItemChannel> result) {
        super.onPostExecute(result);
        callerContext.arrItem = result;
        ItemChannelAdapter dds = new ItemChannelAdapter(callerContext, R.layout.item, result);
        callerContext.lv_item.setAdapter(dds);
        //dialog.dismiss();
    }

//    @Override
//    protected void onPreExecute() {
//        dialog.setMessage("Please wait\nReading RSS ...");
//        dialog.setCancelable(false);
//        dialog.show();
//    }

    @Override
    protected ArrayList<ItemChannel> doInBackground(String... params) {
        ArrayList<ItemChannel> newsList = new ArrayList<ItemChannel>();
        urlAddress = params[0];

        URL url = null;
        try {
            url = new URL(urlAddress);
            URLConnection connection;

            connection = url.openConnection();
            HttpURLConnection httpConnection = (HttpURLConnection) connection;
            int resCode = httpConnection.getResponseCode();
            if(resCode == HttpURLConnection.HTTP_OK){
                InputStream in = httpConnection.getInputStream();

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = factory.newDocumentBuilder();

                Document doc = db.parse(in);
                Element root = doc.getDocumentElement();

                newsList.clear();
                NodeList nodeList = root.getElementsByTagName("item");
                if(nodeList != null){
                    for(int i = 0; i < nodeList.getLength(); i++){
                        newsList.add(DissectItemNode(nodeList, i));
                    }
                }

            }
            httpConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return newsList;
    }

    public ItemChannel DissectItemNode (NodeList nodeList, int i){

        Element entry = (Element) nodeList.item(i);
        Element title = (Element) entry.getElementsByTagName("title").item(0);
        Element description = (Element) entry.getElementsByTagName("description").item(0);
        Element link = (Element) entry.getElementsByTagName("link").item(0);

        String titleValue = title.getTextContent();
        String descriptionValue = description.getTextContent();
        String linkValue = link.getTextContent();

        ItemChannel item = new ItemChannel(titleValue, "detail", linkValue);
        item.setDescription(descriptionValue);
        return item;
    }
}
