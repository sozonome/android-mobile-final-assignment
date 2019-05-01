package id.ac.umn.keburusarjanainc.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import id.ac.umn.keburusarjanainc.R;
import id.ac.umn.keburusarjanainc.adapter.ArticlesAdapter;
import id.ac.umn.keburusarjanainc.model.ArticlesList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
//    private TextView textView;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ArticlesList> articlesLists;

    private static final String URL_DATA = "http://ultimagz.com/wp-json/wp/v2/posts";
//    private String URL_PARAM = "";
//    private String title = "";

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = view.findViewById(R.id.newfeed_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        articlesLists = new ArrayList<>();
        loadUrlData(getArguments().getString("param"));

        return view;
    }

    private void loadUrlData(String URL_PARAM){
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading . . .");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA + URL_PARAM, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                try {
                    JSONArray array = new JSONArray(response);
                    for(int i=0; i<array.length(); i++){
                        JSONObject jo = array.getJSONObject(i);
                        JSONObject jo_title = jo.getJSONObject("title");
                        JSONObject jo_image = jo.getJSONObject("better_featured_image");
                        JSONObject jo_content = jo.getJSONObject("content");
                        ArticlesList articles = new ArticlesList(jo_title.getString("rendered"), jo_image.getString("source_url"), jo_content.getString("rendered"), jo.getString("date"));
                        articlesLists.add(articles);
                    }

                    adapter = new ArticlesAdapter(articlesLists, getContext());
                    recyclerView.setAdapter(adapter);
                    Log.d("Test Data ViewPager", "Title : " + articlesLists.get(0).getArticle_title());
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Error" + error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        stringRequest.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });

        Log.d("URL ViewPager", "URL yang ditarik : " + URL_DATA + URL_PARAM);
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }
}
