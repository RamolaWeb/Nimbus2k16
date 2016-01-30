package com.appteam.nimbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Team extends AppCompatActivity {
    private static final String KEY_NAME_TEAM ="Detail" ;
    private String team_name;
    private event_adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i=getIntent();
        if(i!=null){

            team_name=i.getStringExtra(KEY_NAME_TEAM).toLowerCase();
            getSupportActionBar().setTitle(team_name.toUpperCase());
        }
        View teamdetail=findViewById(R.id.team_detail);
        TextView description= (TextView) teamdetail.findViewById(R.id.team_detail_description);
        int id=getResources().getIdentifier(team_name,"string",this.getPackageName());
        String content=getResources().getString(id);
        description.setText(content);

        View contact_detail=findViewById(R.id.contact_detail);
        TextView contact_description= (TextView) contact_detail.findViewById(R.id.contact_detail_description);
        int id1=getResources().getIdentifier(team_name+"_contact","string",this.getPackageName());
        String content_contact=getResources().getString(id1);
        contact_description.setText(content_contact);

       RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recycler_view_team_event);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
int id3=getResources().getIdentifier(team_name+"_event","array",this.getPackageName());
     String list[]=  getResources().getStringArray(id3);
        adapter=new event_adapter(this,list);
        recyclerView.setAdapter(adapter);
    }

}
