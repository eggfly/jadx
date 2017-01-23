package com.aide.ui.build.android;

import com.aide.common.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import qh;

public class d {
    private DocumentBuilder DW;
    private final DocumentBuilderFactory j6;

    public d() {
        this.DW = null;
        this.j6 = DocumentBuilderFactory.newInstance();
        try {
            this.DW = this.j6.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.FH("Error creating document builder in firebase support.");
        }
    }

    public void j6(String str, String str2, String str3) {
        String j6 = j6(str);
        if (qh.VH(j6)) {
            try {
                Map j62 = j6(j6, str2);
                String str4 = str3 + "/values/google-services.xml";
                Document newDocument = this.DW.newDocument();
                j6(j62, newDocument, j6(newDocument));
                j6(str4, newDocument);
            } catch (IOException e) {
                e.FH("Error processing firebase configuration");
            }
        }
    }

    private Element j6(Document document) {
        Object createElement = document.createElement("resources");
        document.appendChild(createElement);
        return createElement;
    }

    private void j6(Map<String, String> map, Document document, Element element) {
        for (String str : map.keySet()) {
            String str2 = (String) map.get(str);
            Node createElement = document.createElement("string");
            createElement.setAttribute("name", str);
            createElement.setAttribute("translatable", "false");
            createElement.setTextContent(str2);
            element.appendChild(createElement);
        }
    }

    private void j6(String str, Document document) {
        try {
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("omit-xml-declaration", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            new File(str).getParentFile().mkdirs();
            newTransformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(str)));
        } catch (TransformerException e) {
            e.FH("Error generating xml file in firebase support");
        }
    }

    private Map<String, String> j6(String str, String str2) {
        int i = 0;
        String j6 = qh.j6(qh.FH(str));
        Map<String, String> hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(j6);
            if (jSONObject.has("project_info") && jSONObject.has("client")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("project_info");
                j6("gcm_defaultSenderId", "project_number", hashMap, jSONObject2);
                j6("firebase_database_url", "firebase_url", hashMap, jSONObject2);
                j6("google_storage_bucket", "storage_bucket", hashMap, jSONObject2);
                jSONObject = j6(jSONObject.getJSONArray("client"), str2);
                if (jSONObject.has("client_info")) {
                    j6("google_app_id", "mobilesdk_app_id", hashMap, jSONObject.getJSONObject("client_info"));
                }
                if (jSONObject.has("services")) {
                    j6("ga_trackingID", "analytics_property", hashMap, jSONObject.getJSONObject("services"));
                }
                if (jSONObject.has("api_key")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("api_key");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                        if (jSONObject3.has("current_key")) {
                            hashMap.put("google_api_key", jSONObject3.getString("current_key"));
                            hashMap.put("google_crash_reporting_api_key", jSONObject3.getString("current_key"));
                            break;
                        }
                    }
                }
                if (jSONObject.has("oauth_client")) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("oauth_client");
                    while (i < jSONArray2.length()) {
                        jSONObject = jSONArray2.getJSONObject(i);
                        if (jSONObject.has("client_type") && jSONObject.getInt("client_type") == 3 && jSONObject.has("client_id")) {
                            hashMap.put("default_web_client_id", jSONObject.getString("client_id"));
                            break;
                        }
                        i++;
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    private JSONObject j6(JSONArray jSONArray, String str) {
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject.has("client_info")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("client_info");
                if (jSONObject2.has("android_client_info")) {
                    jSONObject2 = jSONObject2.getJSONObject("android_client_info");
                    if (jSONObject2.has("package_name") && jSONObject2.getString("package_name").equals(str)) {
                        return jSONObject;
                    }
                }
                continue;
            }
        }
        e.FH("No matching client_info found in google-service.json for package: " + str);
        return new JSONObject();
    }

    private void j6(String str, String str2, Map<String, String> map, JSONObject jSONObject) {
        if (jSONObject.has(str2)) {
            map.put(str, jSONObject.getString(str2));
        }
    }

    private String j6(String str) {
        return str + "/google-services.json";
    }
}
