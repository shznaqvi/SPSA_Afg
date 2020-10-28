package edu.aku.hassannaqvi.spsa_afg.sync;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Objects;

import edu.aku.hassannaqvi.spsa_afg.adapter.SyncListAdapter;
import edu.aku.hassannaqvi.spsa_afg.contracts.DistrictContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.ProvinceContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.UsersContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.VersionAppContract;
import edu.aku.hassannaqvi.spsa_afg.contracts.VillageContract;
import edu.aku.hassannaqvi.spsa_afg.core.DatabaseHelper;
import edu.aku.hassannaqvi.spsa_afg.core.MainApp;
import edu.aku.hassannaqvi.spsa_afg.models.SyncModel;

/**
 * Created by ali.azaz on 7/14/2017.
 */

public class GetAllData extends AsyncTask<String, String, String> {

    private HttpURLConnection urlConnection;
    private SyncListAdapter adapter;
    private List<SyncModel> list;
    private int position;
    private String TAG = "", syncClass;
    private Context mContext;
    private ProgressDialog pd;

    public GetAllData(Context context, String syncClass) {
        mContext = context;
        this.syncClass = syncClass;
        TAG = "Get" + syncClass;
    }

    public GetAllData(Context context, String syncClass, SyncListAdapter adapter, List<SyncModel> list) {
        mContext = context;
        this.syncClass = syncClass;
        this.adapter = adapter;
        this.list = list;
        TAG = "Get" + syncClass;
        switch (syncClass) {
            case "User":
                position = 0;
                break;
            case "VersionApp":
                position = 1;
                break;
            case "Provinces":
                position = 2;
                break;
            case "Districts":
                position = 3;
                break;
            case "Villages":
                position = 4;
                break;
        }
        list.get(position).settableName(syncClass);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(mContext);
        pd.setTitle("Syncing " + syncClass);
        pd.setMessage("Getting connected to server...");
//        pd.show();
        list.get(position).setstatus("Getting connected to server...");
        list.get(position).setstatusID(2);
        list.get(position).setmessage("");
        adapter.updatesyncList(list);

    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        switch (values[0]) {
            case "User":
                position = 0;
                break;
            case "VersionApp":
                position = 1;
                break;
            case "Provinces":
                position = 2;
                break;
            case "Districts":
                position = 3;
                break;
            case "Villages":
                position = 4;
                break;
        }
        list.get(position).setstatus("Syncing");
        list.get(position).setstatusID(2);
        list.get(position).setmessage("");
        adapter.updatesyncList(list);
    }

    @Override
    protected String doInBackground(String... args) {

        StringBuilder result = new StringBuilder();
        String tableName = "";

        URL url = null;
        try {
            switch (syncClass) {
                case "User":
                    url = new URL(MainApp._HOST_URL + MainApp._SERVER_GET_URL);
                    tableName = UsersContract.UsersTable.TABLE_NAME;
                    position = 0;
                    break;
                case "VersionApp":
                    url = new URL(MainApp._UPDATE_URL + VersionAppContract.VersionAppTable.SERVER_URI);
                    position = 1;
                    break;
                case "Provinces":
                    url = new URL(MainApp._HOST_URL + MainApp._SERVER_GET_URL);
                    tableName = ProvinceContract.table.TABLE_NAME;
                    position = 2;
                    break;
                case "Districts":
                    url = new URL(MainApp._HOST_URL + MainApp._SERVER_GET_URL);
                    tableName = DistrictContract.table.TABLE_NAME;
                    position = 3;
                    break;
                case "Villages":
                    url = new URL(MainApp._HOST_URL + MainApp._SERVER_GET_URL);
                    tableName = VillageContract.table.TABLE_NAME;
                    position = 4;
                    break;

            }

            urlConnection = (HttpURLConnection) Objects.requireNonNull(url).openConnection();
            urlConnection.setReadTimeout(100000 /* milliseconds */);
            urlConnection.setConnectTimeout(150000 /* milliseconds */);

            switch (syncClass) {
                case "User":
                case "Provinces":
                case "Districts":
                case "Villages":
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setDoOutput(true);
                    urlConnection.setDoInput(true);
                    urlConnection.setRequestProperty("Content-Type", "application/json");
                    urlConnection.setRequestProperty("charset", "utf-8");
                    urlConnection.setUseCaches(false);

                    // Starts the query
                    urlConnection.connect();
                    DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
                    JSONObject json = new JSONObject();
                    try {
                        json.put("table", tableName);
                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }
                    Log.d(TAG, "downloadUrl: " + json.toString());
                    wr.writeBytes(json.toString());
                    wr.flush();
                    wr.close();
                    break;
            }


            Log.d(TAG, "doInBackground: " + urlConnection.getResponseCode());
            publishProgress(syncClass);
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                publishProgress("In Progress");

                String line;
                while ((line = reader.readLine()) != null) {
                    Log.i(TAG, syncClass + " In: " + line);
                    result.append(line);
                }
            } else {
                return String.valueOf(urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            result.append(e.getMessage());
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }


        return result.toString();
    }

    @Override
    protected void onPostExecute(String result) {

        //Do something with the JSON string
        if (result != null) {
            if (result.length() > 0) {
                DatabaseHelper db = new DatabaseHelper(mContext);
                try {
                    JSONArray jsonArray = new JSONArray();
                    int insertCount = 0;
                    switch (syncClass) {
                        case "User":
                            jsonArray = new JSONArray(result);
                            insertCount = db.syncUser(jsonArray);
                            position = 0;
                            break;
                        case "VersionApp":
                            insertCount = db.syncVersionApp(new JSONObject(result));
                            if (insertCount == 1) jsonArray.put("1");
                            position = 1;
                            break;
                        case "Provinces":
                            jsonArray = new JSONArray(result);
                            insertCount = db.syncProvince(jsonArray);
                            position = 2;
                            break;
                        case "Districts":
                            jsonArray = new JSONArray(result);
                            insertCount = db.syncDistricts(jsonArray);
                            position = 3;
                            break;
                        case "Villages":
                            jsonArray = new JSONArray(result);
                            insertCount = db.syncVillages(jsonArray);
                            position = 4;
                            break;

                    }

                    pd.setMessage("Received: " + jsonArray.length());
                    list.get(position).setmessage("Received: " + jsonArray.length() + ", Saved: " + insertCount);
                    list.get(position).setstatus(insertCount == 0 ? "Unsuccessful" : "Successful");
                    list.get(position).setstatusID(insertCount == 0 ? 2 : 3);
                    adapter.updatesyncList(list);
//                    pd.show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    pd.setTitle("Error");
                    pd.setMessage(result);
                    list.get(position).setstatus("Failed");
                    list.get(position).setstatusID(1);
                    list.get(position).setmessage(result);
                    adapter.updatesyncList(list);
                }
            } else {
                pd.setMessage("Received: " + result.length() + "");
                list.get(position).setmessage("Received: " + result.length() + "");
                list.get(position).setstatus("Successful");
                list.get(position).setstatusID(3);
                adapter.updatesyncList(list);
//                pd.show();
            }
        } else {
            pd.setTitle("Connection Error");
            pd.setMessage("Server not found!");
            list.get(position).setstatus("Failed");
            list.get(position).setstatusID(1);
            list.get(position).setmessage("Server not found!");
            adapter.updatesyncList(list);
//            pd.show();
        }
    }

}
