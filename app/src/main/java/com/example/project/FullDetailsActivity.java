package com.example.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

import androidx.appcompat.app.AppCompatActivity;

public class FullDetailsActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.viewfull_info);

            Bundle bundle = getIntent().getExtras();
            String name = bundle.getString("name");
                        try {
                            // Load the XML file
                            InputStream inputStream = getAssets().open("data.xml");
                            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                            DocumentBuilder builder = factory.newDocumentBuilder();
                            Document doc = builder.parse(inputStream);

                            // Get the root element
                            Element root = doc.getDocumentElement();

                            // Get the <Name15> element
                            Element name15Element = (Element) root.getElementsByTagName(name).item(0);

                            // Get the values of <uName> and <USN> elements within <Name15> element
                            String uName = getElementValue(name15Element, "uName");
                            String usn = getElementValue(name15Element, "USN");

                            // Print the extracted values
                            System.out.println("name");
                            System.out.println("uName: " + uName);
                            System.out.println("USN: " + usn);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
        }
    private static String getElementValue(Element parentElement, String tagName) {
        NodeList nodeList = parentElement.getElementsByTagName(tagName);
        if (nodeList != null && nodeList.getLength() > 0) {
            Element element = (Element) nodeList.item(0);
            if (element != null) {
                Node textNode = element.getFirstChild();
                if (textNode != null) {
                    return textNode.getNodeValue();
                }
            }
        }
        return "";
    }

}
